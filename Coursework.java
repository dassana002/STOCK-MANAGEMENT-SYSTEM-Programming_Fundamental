import java.util.Scanner;

class Coursework {
    static final String user_Name = "Dassana";
    static final String user_Password = "Dassana@123";

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

    private static void exit_the_System() {
        
    }

    private static void log_out() {
        
    }

    private static void supplier_Manage() {
        
    }

    private static void change_The_Credentials() {
        
    }

    public static void Menu() {
        Scanner input = new Scanner(System.in);

        clearConsole();

        System.out.println("+---------------------------------------------------------------------------------------+");
        System.out.println("|\t\t\t\tWELCOME TO STOCK MANAGEMENT SYSTEM\t\t\t\t|");
        System.out.println("+---------------------------------------------------------------------------------------+\n");

        System.out.println("[1] Change the Credentials\t [2] Suppliar Manage");
        System.out.println("[3] Stock  Manage\t\t [4] Log out");
        System.out.println("[5] Exit the system");
        System.out.println();

        while (true) {
            System.out.print("Enter an option to continue >");
            char option = input.next().charAt(0);

            switch (option) {
                case '1'-> change_The_Credentials();
                case '2'-> supplier_Manage();
                case '3'-> supplier_Manage();
                case '4'-> log_out();
                case '5'-> exit_the_System();
                default-> {
                    continue;
                }
            }
        }
    }

    public static void homePage() {
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
                        Menu();
                        break L1;
                    } else {
                        System.out.println("password is incorrect. please try again!");
                        continue L2;
                    }
                }
            } else {
                System.out.println("user name is invalid. please try again!");
                continue L1;
            }
        }
    }

    public static void main(String[] args) {
        // homePage();
        Menu();
    }
}