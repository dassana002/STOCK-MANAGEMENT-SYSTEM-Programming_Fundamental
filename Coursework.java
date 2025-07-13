import java.util.Arrays;
import java.util.Scanner;

class Coursework {
    static String user_Name = "Dassana";
    static String user_Password = "Dassana@123";
    static String[][] supplier = new String[0][2];

    public static final void clearConsole() {
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

    public static boolean is_exist_supplier_id(String id) {
        for (int i = 0; i < supplier.length; i++) {
            if (id.equals(supplier[i][0])) {
                return true;
            }
        }
        return false;
    }

    public static boolean is_exist_supplier_name(String name) {
        for (int i = 0; i < supplier.length; i++) {
            if (name.equals(supplier[i][1])) {
                return true;
            }
        }
        return false;
    }

    public static void grow_Supplier(String id, String name) {
        String[][] temp = new String[supplier.length + 1][2];

        for (int i = 0; i < temp.length; i++) {
            if (temp[i][0] == null) {
                temp[i][0] = id;
                temp[i][1] = name;
            }
        }
        supplier = temp;
    }

    public static void exit_the_System() {

    }

    public static void supplier_Manage() {
        Scanner input = new Scanner(System.in);

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                         SUPLIAR MANAGE                                   |");
        System.out.println("+--------------------------------------------------------------------------+\n");

        System.out.println("[1] Add Suppliar\t [2] Update Suppliar");
        System.out.println("[3] Delete Suppliar\t [4] View Suppliar");
        System.out.println("[5] Search Suppliar\t [6] Home page\n");

        while (true) {
            System.out.print("Enter an option to continue > ");
            int option = input.nextInt();

            switch (option) {
                case 1 -> addSupplier();
                case 2 -> updateSupplier();
                case 3 -> deleteSupplier();
                case 4 -> viewSupplier();
                case 5 -> searchSupplier();
                case 6 -> home();
                default -> {
                    System.out.println("Invalid option!\n");
                    continue;
                }
            }
        }
    }

    public static void searchSupplier() {

    }

    public static void viewSupplier() {

    }

    public static void deleteSupplier() {

    }

    public static void updateSupplier() {

    }

    public static void addSupplier() {
        Scanner input = new Scanner(System.in);

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                               ADD SUPPLIER                               |");
        System.out.println("+--------------------------------------------------------------------------+\n");

        L1: while (true) {
            System.out.print("Supplier ID: ");
            String id = input.nextLine();

            boolean is_exist_id = is_exist_supplier_id(id);

            if (!(is_exist_id)) {

                L2: while (true) {
                    System.out.print("Supplier name: ");
                    String name = input.nextLine();

                    boolean is_exist_name = is_exist_supplier_name(name);

                    if (!(is_exist_name)) {
                        grow_Supplier(id, name);

                        L3: while (true) {
                            System.out.print("added successfully! Do you want to add another supplier(Y/N): ");
                            char option = input.next().charAt(0);

                            switch (option) {
                                case 'y', 'Y' -> {
                                    addSupplier();
                                }
                                case 'n', 'N' -> {
                                    home();
                                }
                                default -> {
                                    System.out.println("You entered the wrong option. Please correct the option again!\n");
                                    continue L3;
                                }
                            }
                        }

                    } else {
                        System.out.println("Already exists. try another supplier name!\n");
                        continue L2;
                    }
                }

            } else {
                System.out.println("Already exists. try another supplier id!\n");
                continue L1;
            }

        }
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
                System.out.println("Hey " + user_Name + "\n");

                L2: while (true) {
                    System.out.print("Enter your current password: ");
                    String password = input.nextLine();

                    if (user_Password.equals(password)) {
                        System.out.print("Enter your new password: ");
                        String new_password = input.nextLine();

                        user_Password = new_password;

                        L3: while (true) {
                            System.out.print("password changed succesfully. Do you want to go home page (Y/N): ");
                            char option = input.next().charAt(0);

                            switch (option) {
                                case 'y', 'Y' -> home();
                                case 'n', 'N' -> login();
                                default -> {
                                    System.out.println(
                                            "You entered the wrong option. Please correct the option again!\n");
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

    public static void stock_Manage() {

    }

    public static void home() {
        Scanner input = new Scanner(System.in);

        clearConsole();

        System.out.println("\n+----------------------------------------------------------------------+");
        System.out.println("|                WELCOME TO IJSE STOCK MANAGEMENT SYSTEM               |");
        System.out.println("+----------------------------------------------------------------------+\n");

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
                case '3' -> stock_Manage();
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

        System.out.println("+----------------------------------------------------------------------+");
        System.out.println("|                              LOGIN PAGE                              |");
        System.out.println("+----------------------------------------------------------------------+\n");

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
        // supplier_Manage();
        addSupplier();
    }
}