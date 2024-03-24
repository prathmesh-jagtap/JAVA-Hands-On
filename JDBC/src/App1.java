import java.sql.*;
import java.util.*;
import Students.*;

public class App1 {
    private static final String url = "jdbc:mysql://localhost:3306/Students";
    private static final String username = "root";
    private static final String password = "192000";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded!");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Scanner scanner = new Scanner(System.in);
            StudentInfo studInfo = new StudentInfo(connection, scanner);

            while (true) {
                System.out.println("\n------------Main Menu------------");
                System.out.println("\n0.Exit\n1.Insert\n2.Show\n3.Update\n4.Delete\n");
                System.out.println("Choose operation from menu :");
                int ch = scanner.nextInt();
                switch (ch) {
                    case 1 -> studInfo.Insert();
                    case 2 -> studInfo.Read();
                    case 3 -> studInfo.Update();
                    case 4 -> studInfo.Delete();
                    case 0 -> System.exit(0);
                    default -> System.out.println("Invalid Choice!!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
