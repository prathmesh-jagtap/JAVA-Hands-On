import java.sql.*;
import java.util.*;
import UserAuthentication.*;

public class App {
    private static final String url = "jdbc:mysql://localhost:3306/authenticate";
    private static final String username = "root";
    private static final String password = "192000";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Scanner scanner = new Scanner(System.in);
            User user = new User(connection, scanner);

            String email;

            while (true) {
                System.out.println("\n********** WELCOME TO AUTHENTICATION SYSTEM **********\n");
                System.out.println("1. Register\n2. Login\n3. Exit");
                System.out.println("\nEnter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        user.register();
                        System.out.println("\033[H\033[2J");
                        System.out.flush();
                        break;
                    case 2:
                        email = user.login();
                        if (email != null) {
                            System.out.println();
                            System.out.println("Successful Login!!");
                            break;
                        } else {
                            System.out.println("Invalid Username or Password!");
                            break;
                        }
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Enter valid choice!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
