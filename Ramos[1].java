import java.util.Scanner;

public class LoginSystem {
    private static String[][] users = new String[100][2];
    private static int userCount = 0;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("==== LOGIN SYSTEM ====");
            System.out.println("[1] Login");
            System.out.println("[2] Register");
            System.out.println("[3] Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    loginUser();
                    break;
                case 2:
                    registerUser();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void registerUser() {
        System.out.print("Enter a username: ");
        String username = input.nextLine();
        System.out.print("Enter a password: ");
        String password = input.nextLine();
        System.out.print("Confirm password: ");
        String confirm = input.nextLine();

        if (usernameExists(username)) {
            System.out.println(" Choose another.");
        } else if (!password.equals(confirm)) {
            System.out.println("Passwords don't match. Try again.");
        } else {
            users[userCount][0] = username;
            users[userCount][1] = password;
            userCount++;
            System.out.println("Registration successful!");
        }
    }

    private static void loginUser() {
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();

        boolean found = false;
        for (int i = 0; i < userCount; i++) {
            if (users[i][0].equals(username) && users[i][1].equals(password)) {
                System.out.println("Hello," + username +  " wellcome to smcbi collage"  + "!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Invalid username or password!");
        }
    }

    private static boolean usernameExists(String username) {
        for (int i = 0; i < userCount; i++) {
            if (users[i][0].equals(username)) {
                return true;
            }
        }
        return false;
    }
}