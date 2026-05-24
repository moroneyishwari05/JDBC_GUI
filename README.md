# JDBC GUI Management System

A Java Swing-based GUI application integrated with JDBC and PostgreSQL for performing database operations such as Insert, Fetch, Update, Delete, Search, and Sorting.

## Features

- Insert records into the database
- Fetch and display records in a table
- Update existing records
- Delete records
- Search records using:
  - GPA greater than (`WHERE GPA >`)
  - Name search (`LIKE NAME`)
  - GPA range (`BETWEEN GPA`)
- Order records using SQL queries
- Interactive GUI using Java Swing

## Technologies Used

- Java
- Java Swing (GUI)
- JDBC
- PostgreSQL
- Eclipse IDE

## Project Structure

```plaintext
JDBC_GUI/
│── src/
│   ├── jdbc_gui/
│   │   ├── JDBC_Demo.java
│   │   ├── TeamManagement.java
│   ├── module-info.java
│
│── bin/
│── .classpath
│── .project
```

## Database Configuration

This project uses **PostgreSQL**.

### Database Connection

Update the database credentials inside the code if required:

```java
String url = "jdbc:postgresql://localhost:5432/postgres";
String username = "postgres";
String password = "your_password";
```

Also in `TeamManagement.java`:

```java
DriverManager.getConnection(
    "jdbc:postgresql://localhost:5432/postgres",
    "postgres",
    "your_password"
);
```

## Database Table

Create the required table before running the application.

Example SQL:

```sql
CREATE TABLE my_team_ois (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    gender VARCHAR(20),
    course VARCHAR(100),
    year VARCHAR(20),
    email VARCHAR(100),
    phone VARCHAR(20),
    address TEXT,
    gpa DECIMAL(3,2)
);
```
Records which can be directly inserted in the database :

```sql
INSERT INTO my_team_ois
(name, age, gender, course, year, email, phone, address, gpa)

VALUES
('Aarav Sharma', 20, 'Male', 'CSE', 2, 'aarav@gmail.com', '9876543210', 'Nagpur', 8.45),

('Priya Verma', 21, 'Female', 'IT', 3, 'priya@gmail.com', '9876543211', 'Pune', 9.10),

('Rahul Patil', 22, 'Male', 'ENTC', 4, 'rahul@gmail.com', '9876543212', 'Mumbai', 7.85),

('Sneha Joshi', 20, 'Female', 'CSE', 2, 'sneha@gmail.com', '9876543213', 'Nashik', 8.90),

('Kunal Mehta', 23, 'Male', 'MECH', 4, 'kunal@gmail.com', '9876543214', 'Delhi', 7.20),

('Ananya Kulkarni', 21, 'Female', 'AIDS', 3, 'ananya@gmail.com', '9876543215', 'Nagpur', 9.25),

('Rohit Deshmukh', 22, 'Male', 'CIVIL', 4, 'rohit@gmail.com', '9876543216', 'Amravati', 6.95),

('Pooja Singh', 19, 'Female', 'CSE', 1, 'pooja@gmail.com', '9876543217', 'Indore', 8.75),

('Aditya Rao', 20, 'Male', 'ECE', 2, 'aditya@gmail.com', '9876543218', 'Hyderabad', 7.60),

('Neha Kapoor', 21, 'Female', 'IT', 3, 'neha@gmail.com', '9876543219', 'Bhopal', 8.30),

('Yash Thakur', 22, 'Male', 'CSE', 4, 'yash@gmail.com', '9876543220', 'Nagpur', 9.40),

('Isha Jain', 20, 'Female', 'AIML', 2, 'isha@gmail.com', '9876543221', 'Jaipur', 8.05),

('Vikas Nair', 23, 'Male', 'MECH', 4, 'vikas@gmail.com', '9876543222', 'Chennai', 7.50),

('Ritika Sen', 19, 'Female', 'CSE', 1, 'ritika@gmail.com', '9876543223', 'Kolkata', 9.00),

('Arjun Malhotra', 21, 'Male', 'IT', 3, 'arjun@gmail.com', '9876543224', 'Surat', 8.15);
```

## How to Run the Project

### 1. Clone the repository

```bash
git clone https://github.com/your-username/JDBC_GUI.git
```

### 2. Open in Eclipse

- Open Eclipse IDE
- Click **Import Project**
- Select the `JDBC_GUI` folder

### 3. Add PostgreSQL JDBC Driver

Download PostgreSQL JDBC Driver:

https://jdbc.postgresql.org/download/

Add the `.jar` file to your project's build path.

### 4. Configure PostgreSQL

- Ensure PostgreSQL server is running
- Create the database table
- Update username/password in the Java files

### 5. Run the Application

Run:

```plaintext
TeamManagement.java
```

## Screenshots

Add screenshots of your GUI here after uploading to GitHub.

Example:

```md
![GUI Screenshot](images/gui.png)
```

## Future Improvements

- Prepared Statements for better security
- Input validation
- Better UI design
- Login authentication
- Export data to CSV/PDF

## Author

**Ishwari Moroney**
