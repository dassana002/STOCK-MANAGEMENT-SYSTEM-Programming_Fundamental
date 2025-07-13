import java.util.Scanner;

class Coursework {
    static String user_Name = "Dassana";
    static String user_Password = "Dassana@123";

    private static final void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Linux")) {
                System.out.print("\033\143");
            } else if (os.equals("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void exit_the_System() {
        
    }

    public static void supplier_Manage() {
        
    }

    public static void change_The_Credentials() {
        Scanner input = new Scanner(System.in);

        clearConsole();

        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|\t\t\t\tCREDENTIAL MANAGE\t\t\t\t|");
        System.out.println("+---------------------------------------------------------------------------+");

        L1: while (true) {
            System.out.print("Please enter the user name to verfy it's you: ");
            String name = input.nextLine();

            if (user_Name.equals(name)) {
                System.out.println("Hey " + user_Name+"\n");

                L2: while (true) {
                    System.out.print("Enter your current password: ");
                    String password = input.nextLine();

                    if (user_Password.equals(password)) {
                        System.out.print("Enter your new password: ");
                        String new_password = input.nextLine();

                        user_Password = new_password;

                        L3:while (true) {
                            System.out.print("password changed succesfully. Do you want to go home page (Y/N): ");
                            char option = input.next().charAt(0);

                            switch (option) {
                                case 'y', 'Y' -> home();
                                case 'n', 'N' -> login();
                                default -> {
                                    System.out.println("You entered the wrong option. Please correct the option again!\n");
                                    continue L3;
                                }
                            }
                        }
                    } else {
                        System.out.println("incorrect password. try again!\n");
                        continue L2;
                    }
                }
            } else {
                System.out.println("Invalid User name. Please try again!\n");
                continue L1;
            }
        }

    }

    public static void home() {
        Scanner input = new Scanner(System.in);

        clearConsole();

        System.out.println("+---------------------------------------------------------------------------------------+");
        System.out.println("|\t\t\t\tWELCOME TO STOCK MANAGEMENT SYSTEM\t\t\t\t|");
        System.out
                .println("+---------------------------------------------------------------------------------------+\n");

        System.out.println("[1] Change the Credentials\t [2] Suppliar Manage");
        System.out.println("[3] Stock  Manage\t\t [4] Log out");
        System.out.println("[5] Exit the system");
        System.out.println();

        while (true) {
            System.out.print("Enter an option to continue >");
            char option = input.next().charAt(0);

            switch (option) {
                case '1' -> change_The_Credentials();
                case '2' -> supplier_Manage();
                case '3' -> supplier_Manage();
                case '4' -> login();
                case '5' -> exit_the_System();
                default -> {
                    System.out.println("You entered the wrong option. Please correct the option again!\n");
                    continue;
                }
            }
        }
    }

    public static void login() {
        Scanner input = new Scanner(System.in);

        clearConsole();

        System.out.println("+---------------------------------------------------------------------------------------+");
        System.out.println("|\t\t\t\t\tLOGIN PAGE\t\t\t\t\t|");
        System.out
                .println("+---------------------------------------------------------------------------------------+\n");

        L1: while (true) {
            System.out.print("User name: ");
            String name = input.nextLine();

            if (user_Name.equals(name)) {

                L2: while (true) {
                    System.out.print("Password: ");
                    String password = input.nextLine();

                    if (user_Password.equals(password)) {
                        System.out.println("Login successful!");
                        home();
                    } else {
                        System.out.println("password is incorrect. please try again!\n");
                        continue L2;
                    }
                }
            } else {
                System.out.println("user name is invalid. please try again!\n");
                continue L1;
            }
        }
    }

    public static void main(String[] args) {
        // login();
        // home();
        // change_The_Credentials();
        exit_the_System();
    }
}