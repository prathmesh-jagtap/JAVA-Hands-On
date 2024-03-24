package Students;

import java.util.*;
import java.sql.*;

public class StudentInfo {
    private Connection connection;
    private Scanner scanner;

    public StudentInfo(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public void Insert() {
        scanner.nextLine();
        System.out.println("Enter Student Name : ");
        String name = scanner.nextLine();
        System.out.println("Enter Student Enrollment Number : ");
        String enroll = scanner.nextLine();
        System.out.println("Enter Student Email : ");
        String email = scanner.nextLine();
        System.out.println("Enter Student Phone Number : ");
        String phone = scanner.nextLine();

        String query = "Insert into Student(stud_name, stud_enroll_no, stud_email, stud_phone) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, enroll);
            stmt.setString(3, email);
            stmt.setString(4, phone);
            int i = stmt.executeUpdate();
            if (i > 0) {
                System.out.println(i + " records inserted!");
            } else {
                System.out.println("Failed to Insert Record!");
            }
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Read() {
        String query = "SELECT * FROM Student";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(
                    "|----------|--------------------|--------------------|--------------------|--------------------|");
            System.out.printf("|%10s|%20s|%20s|%20s|%20s|\n", rsmd.getColumnName(1), rsmd.getColumnName(2),
                    rsmd.getColumnName(3), rsmd.getColumnName(4), rsmd.getColumnName(5));
            System.out.println(
                    "|----------|--------------------|--------------------|--------------------|--------------------|");

            while (rs.next()) {
                System.out.printf("|%10d|%20s|%20s|%20s|%20s|\n", rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5));
            }
            System.out.println(
                    "|----------|--------------------|--------------------|--------------------|--------------------|");

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Update() {
        scanner.nextLine();
        System.out.println("Enter the Field name to be Update:  ");
        String field = scanner.nextLine();
        System.out.println("Enter the value to be Updated:  ");
        String value = scanner.nextLine();
        System.out.println("Enter the Student id to update:  ");
        int id = scanner.nextInt();

        String query = "UPDATE Student set " + field + "= ? where stud_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, value);
            stmt.setInt(2, id);
            int rs = stmt.executeUpdate();
            if (rs > 0) {
                System.out.println(rs + " record updated successfully!");
            } else {
                System.out.println("Failed to Update");
            }
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Delete() {
        String query = "DELETE FROM Student where stud_id=?";
        System.out.println("Enter Id to Delete Record : ");
        int id = scanner.nextInt();
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            int rs = stmt.executeUpdate();
            if (rs > 0) {
                System.out.println(rs + " record deleted successfully!");
            } else {
                System.out.println("Failed to delete!");
            }
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}