import java.util.Arrays;
import java.util.Scanner;

class Coursework {
    static String user_Name = "1234";
    static String user_Password = "1234";
    static String [][]supplier = new String[0][2];
    static String []category = new String[0];

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

    public static void grow_category(String name){
        String []temp = new String[category.length+1];

        for (int i = 0; i < category.length; i++) {
            temp[i] = category[i];
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == null) {
                temp[i] = name;
            }
        }

        category = temp;
        System.out.println(Arrays.deepToString(category));
    }

    public static boolean is_exist_category(String name) {
        for (int i = 0; i < category.length; i++) {
            if (category[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void ungrow_supplier(String id) {
        String[][] temp = new String[supplier.length - 1][2];

        int j = 0;
        for (int i = 0; i < supplier.length; i++) {
            if (supplier[i][0].equals(id)) {
                j++;
                continue;
            }
            temp[i - j][0] = supplier[i][0];
            temp[i - j][1] = supplier[i][1];
        }
        supplier = temp;

    }

    public static void update_Supplier_Name(String name, String new_name) {
        for (int i = 0; i < supplier.length; i++) {
            if (supplier[i][1].equals(name)) {
                supplier[i][1] = new_name;
            }
        }
    }

    public static String getSupplier_by_Id(String id) {
        for (int i = 0; i < supplier.length; i++) {
            if (supplier[i][0].equals(id)) {
                return supplier[i][1];
            }
        }
        return id;
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

        for (int i = 0; i < supplier.length; i++) {
            for (int j = 0; j < supplier[i].length; j++) {
                temp[i][j] = supplier[i][j];
            }
        }

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
                // case 4 -> viewSupplier();
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
        Scanner input = new Scanner(System.in);

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                             SEARCH SUPPLIER                              |");
        System.out.println("+--------------------------------------------------------------------------+\n");

        L1: while (true) {
            System.out.print("Supplier ID: ");
            String id = input.nextLine();

            boolean is_exist_id = is_exist_supplier_id(id);

            if (is_exist_id) {
                System.out.println("Supplier Name: " + getSupplier_by_Id(id));

                L2: while (true) {
                    System.out.print("successfully !. Do you want to search another supplier (Y/N) > ");
                    char option = input.next().charAt(0);

                    switch (option) {
                        case 'y', 'Y' -> searchSupplier();
                        case 'n', 'N' -> supplier_Manage();
                        default -> {
                            System.out.println("You entered the wrong option. Please correct the option again!\n");
                            continue L2;
                        }
                    }
                }
            } else {
                System.out.println("can not find supplier id. try again!\n");
                continue L1;
            }
        }
    }

    // public static void viewSupplier() {

    // }

    public static void deleteSupplier() {
        Scanner input = new Scanner(System.in);

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                              DELETE SUPPLIER                             |");
        System.out.println("+--------------------------------------------------------------------------+\n");

        L1: while (true) {
            System.out.print("Supplier Id: ");
            String id = input.nextLine();

            boolean is_exist_id = is_exist_supplier_id(id);

            if (is_exist_id) {
                ungrow_supplier(id);

                L2: while (true) {
                    System.out.print("delete successfully! . Do you want to delete another? (Y/N)");
                    char option = input.next().charAt(0);

                    switch (option) {
                        case 'y', 'Y' -> deleteSupplier();
                        case 'n', 'N' -> supplier_Manage();
                        default -> {
                            System.out.println("You entered the wrong option. Please correct the option again!\n");
                            continue L2;
                        }
                    }
                }

            } else {
                System.out.println("Can not find supplier id. try again!\n");
                continue L1;
            }
        }
    }

    public static void updateSupplier() {
        Scanner input = new Scanner(System.in);

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                              UPDATE SUPPLIER                             |");
        System.out.println("+--------------------------------------------------------------------------+\n");

        L1: while (true) {
            System.out.print("Supplier Id: ");
            String id = input.nextLine();

            boolean is_exist_id = is_exist_supplier_id(id);

            if (is_exist_id) {
                String name = getSupplier_by_Id(id);
                System.out.println("Supplier name: " + name + "\n");

                System.out.print("Enter the new supplier name: ");
                String new_name = input.nextLine();

                update_Supplier_Name(name, new_name);

                L2: while (true) {
                    System.out.print("Update successfully!. Do you want to update another supplier? (Y/n): ");
                    char option = input.next().charAt(0);

                    switch (option) {
                        case 'y', 'Y' -> updateSupplier();
                        case 'n', 'N' -> supplier_Manage();
                        default -> {
                            System.out.println("You entered the wrong option. Please correct the option again!\n");
                            continue L2;
                        }
                    }
                }
            } else {
                System.out.println("can not find suppiler id. try again!\n");
                continue L1;
            }
        }
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
                                    supplier_Manage();
                                }
                                default -> {
                                    System.out.println(
                                            "You entered the wrong option. Please correct the option again!\n");
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
        Scanner input = new Scanner(System.in);

        clearConsole();

        System.out.println("+------------------------------------------------------------------------+");
        System.out.println("|                            STOCK MANAGEMENT                            |");
        System.out.println("+------------------------------------------------------------------------+");

        System.out.println("[1] Manage Item Categories\t [2] Add Item");
        System.out.println("[3] Get Item Suppliar Wise\t [4] View Item");
        System.out.println("[5] Rank Item Per Unit Price\t [6] Home Page\n");

        while (true) {
            System.out.print("Enter an option to continue > ");
            char option = input.next().charAt(0);

            switch (option) {
                case '1' -> manageItemCategories();
                case '2' -> add_Item();
                case '3' -> getItemSupplierWise();
                case '4' -> view_Item();
                case '5' -> ItemPerUnitPrice();
                case '6' -> home();
                default -> {
                    System.out.println("Invalid option! Please try again.");
                    continue;
                }
            }
        }
    }

    public static void view_Item() {

    }

    public static void ItemPerUnitPrice() {

    }

    public static void getItemSupplierWise() {

    }

    public static void add_Item() {

    }

    public static void manageItemCategories() {
        Scanner input = new Scanner(System.in);

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                           MANAGE ITEM CATEGORY                           |");
        System.out.println("+--------------------------------------------------------------------------+\n");

        System.out.println("[1] Add New Item Category\t [2] Delete Item Category");
        System.out.println("[3] Update Item Category\t [4] Stock Management");

        while (true) {
            System.out.print("\nEnter an option to continue > ");
            char option = input.next().charAt(0);

            switch (option) {
                case '1' -> addNewItem_Category();
                case '2' -> deleteItem_Category();
                case '3' -> updateItem_Category();
                case '4' -> stock_Manage();
                default -> {
                    System.out.println("Invalid option!");
                    continue;
                }
            }
        }
    }

    public static void updateItem_Category() {

    }

    public static void deleteItem_Category() {

    }

    public static void addNewItem_Category() {
        Scanner input = new Scanner(System.in);

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                            ADD ITEM CATEGORY                             |");
        System.out.println("+--------------------------------------------------------------------------+\n");

        L1: while (true) {
            System.out.print("Add new Item category: ");
            String name = input.nextLine();

            boolean is_exist_category = is_exist_category(name);

            if (!is_exist_category) {
                
                grow_category(name);

                L2:while (true) {
                    System.out.print("added successfully! Do you want to add another category (Y/N)? ");
                    char option = input.next().charAt(0);

                    switch (option) {
                        case 'y', 'Y' -> addNewItem_Category();
                        case 'n', 'N' -> stock_Manage();
                        default -> {
                            System.out.println("Invalid option!\n");
                            continue L2;
                        }
                    }
                }
            } else {
                System.out.println("Already exist. try again!\n");
                continue L1;
            }
        }
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
        stock_Manage();
    }
}