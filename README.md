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
