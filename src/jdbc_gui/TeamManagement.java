package jdbc_gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

import java.awt.event.*;
import java.sql.*;

@SuppressWarnings("serial")
public class TeamManagement extends JFrame implements ActionListener{
	
	// GUI components
	
	JTextField  tfName, tfAge, tfGender, tfCourse, tfYear, tfEmail, tfPhone, tfAddress, tfGPA;
	JButton btnInsert, btnFetch, btnUpdate, btnDelete, btnOrderBy;
	JTable table;
	DefaultTableModel model;
	JTextField tfSearch1;
	JTextField tfSearch2;
	JComboBox<String> cbSearchType;
	JButton btnSearch;
	
	//JDBC
	Connection con;
	Statement st;
	ResultSet  rs;
	
	TeamManagement(){
		setTitle("My team management system");
		setSize(900, 600);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel formPanel = new JPanel(new GridLayout(10,2,5,5));
		
		formPanel.add(new JLabel("Name"));
		tfName = new JTextField();
		formPanel.add(tfName);
		
		formPanel.add(new JLabel("Age"));
		tfAge = new JTextField();
		formPanel.add(tfAge);
		
		formPanel.add(new JLabel("Gender"));
		tfGender = new JTextField();
		formPanel.add(tfGender);
		
		
		
		formPanel.add(new JLabel("Course"));
		tfCourse = new JTextField();
		formPanel.add(tfCourse);
		
		formPanel.add(new JLabel("Year"));
		tfYear = new JTextField();
		formPanel.add(tfYear);
		
		formPanel.add(new JLabel("Email"));
		tfEmail = new JTextField();
		formPanel.add(tfEmail);
		
		formPanel.add(new JLabel("Phone"));
		tfPhone = new JTextField();
		formPanel.add(tfPhone);
		
		formPanel.add(new JLabel("Address"));
		tfAddress = new JTextField();
		formPanel.add(tfAddress);
		
		formPanel.add(new JLabel("GPA"));
		tfGPA = new JTextField();
		formPanel.add(tfGPA);
		
		// buttons
		btnInsert = new JButton("Insert");
		btnFetch = new JButton("Fetch");
		btnUpdate = new JButton("Update");
		btnDelete = new JButton("Delete");
		btnOrderBy = new JButton("OrderBy");
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(btnInsert);
		buttonPanel.add(btnFetch);
		buttonPanel.add(btnUpdate);
		buttonPanel.add(btnDelete);
		buttonPanel.add(btnOrderBy);
		
		cbSearchType = new JComboBox<>(new String[] {"WHERE GPA>","LIKE NAME", "BETWEEN GPA"});
		
		tfSearch1 = new JTextField(10);
		tfSearch2 = new JTextField(10);
		btnSearch = new JButton("Search");
		
		JPanel searchPanel = new JPanel();
		searchPanel.add(new JLabel("Search Type"));
		searchPanel.add(cbSearchType);
		searchPanel.add(tfSearch1);
		searchPanel.add(tfSearch2);
		searchPanel.add(btnSearch);
		
		add(searchPanel, BorderLayout.SOUTH);
		formPanel.add(buttonPanel);
		add(formPanel, BorderLayout.NORTH);
		
		// Table 
		model = new DefaultTableModel();
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
		

		
		//Generate the events
		btnInsert.addActionListener(this);
		btnFetch.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnOrderBy.addActionListener(this);
		btnSearch.addActionListener(this);

		// Database connection
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ipm@1605");
			JOptionPane.showMessageDialog(this, "Connected to Database");
			
			st = con.createStatement();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Error :" + e.getMessage());
		}
		
		setVisible(true);
	}
	
	public static void main(String args[]) {
		new TeamManagement();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		try {
			if(ae.getSource() == btnInsert) {
				String q = "INSERT INTO my_team_ois "
				        + "(name, age, gender, course, year, email, phone, address, gpa) VALUES ("
				        + "'" + tfName.getText() + "', "
				        + tfAge.getText() + ", "
				        + "'" + tfGender.getText() + "', "
				        + "'" + tfCourse.getText() + "', "
				        + "'" + tfYear.getText() + "', "
				        + "'" + tfEmail.getText() + "', "
				        + "'" + tfPhone.getText() + "', "
				        + "'" + tfAddress.getText() + "', "
				        + tfGPA.getText()
				        + ")";
				st.executeUpdate(q);
			}
			
			else if(ae.getSource() == btnFetch) {
				rs = st.executeQuery("SELECT * FROM my_team_ois");
				ResultSetMetaData rsmd = rs.getMetaData();
				int cols = rsmd.getColumnCount();
				model.setRowCount(0);
				model.setColumnCount(0);
				
				for(int i = 1; i <= cols; i++) {
					model.addColumn(rsmd.getColumnName(i));
				}
				
				while(rs.next()) {
					Object[] row = new Object[cols];
					
					for(int i = 1; i <= cols; i++) {
						row[i-1] = rs.getObject(i);
					}
					
					model.addRow(row);
				}
			}
			
			
			else if(ae.getSource() == btnUpdate) {

			    String q = "UPDATE my_team_ois SET gpa = "
			            + tfGPA.getText()
			            + " WHERE name = '"
			            + tfName.getText()
			            + "';";

			    st.executeUpdate(q);

			    JOptionPane.showMessageDialog(this,
			            "Updated data");
			}
			
			else if(ae.getSource() == btnDelete) {

			    String q = "DELETE FROM my_team_ois "
			            + "WHERE name = '"
			            + tfName.getText()
			            + "';";

			    st.executeUpdate(q);

			    JOptionPane.showMessageDialog(this,
			            "Deleted Record Successfully");
			}
			
			else if(ae.getSource() == btnOrderBy) {
				rs = st.executeQuery("SELECT * FROM"
						+ " my_team_ois ORDER BY age DESC"
						+ ";");
				
				ResultSetMetaData rsmd = rs.getMetaData();
				int cols = rsmd.getColumnCount();
				model.setRowCount(0);
				model.setColumnCount(0);
				
				for(int i = 1; i <= cols; i++) {
					model.addColumn(rsmd.getColumnName(i));
				}
				
				while(rs.next()) {
					Object[] row = new Object[cols];
					
					for(int i = 1; i <= cols; i++) {
						row[i-1] = rs.getObject(i);
					}
					
					model.addRow(row);
				}
				

			}
			
			else if(ae.getSource() == btnSearch) {
				
				String type = (String)cbSearchType.getSelectedItem();
				String q = "";
				
				if(type.equals("WHERE GPA >")) {

			        q = "SELECT * FROM my_team_ois "
			                + "WHERE gpa > "
			                + tfSearch1.getText()
			                + ";";
			    }

			    else if(type.equals("LIKE NAME")) {

			        q = "SELECT * FROM my_team_ois "
			                + "WHERE name LIKE '%"
			                + tfSearch1.getText()
			                + "%';";
			    }

			    else if(type.equals("BETWEEN GPA")) {

			        q = "SELECT * FROM my_team_ois "
			                + "WHERE gpa BETWEEN "
			                + tfSearch1.getText()
			                + " AND "
			                + tfSearch2.getText()
			                + ";";
			    }
				
				rs = st.executeQuery(q);
				ResultSetMetaData rsmd = rs.getMetaData();
				int cols = rsmd.getColumnCount();
				model.setRowCount(0);
				model.setColumnCount(0);
				
				for(int i = 1; i <= cols; i++) {
					model.addColumn(rsmd.getColumnName(i));
				}
				
				while(rs.next()) {
					Object[] row = new Object[cols];
					
					for(int i = 1; i <= cols; i++) {
						row[i-1] = rs.getObject(i);
					}
					
					model.addRow(row);
				}
				
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "Error :" + e.getMessage());
			
		}
		
	}
}

