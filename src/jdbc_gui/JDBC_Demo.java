package jdbc_gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_Demo {

	public static void main(String args[]) {
		
		String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "ipm@1605";
        
        try {
            // Load Driver
            Class.forName("org.postgresql.Driver");

            // Create Connection
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Connected Successfully!");

            // Create Statement
            Statement st = con.createStatement();

            // Execute Query
            st.executeUpdate(
                "CREATE TABLE IF NOT EXISTS student(id INT, name VARCHAR(50))"
            );

            System.out.println("Table Created!");

            // Close Connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}