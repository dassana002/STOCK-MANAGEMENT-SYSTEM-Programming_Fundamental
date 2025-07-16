import java.util.Arrays;
import java.util.Scanner;

class Coursework {
    static String user_Name = "1234";
    static String user_Password = "1234";

    // static String[][] supplier = new String[0][2];
    static String[][] supplier = { { "s001", "dassana" }, { "s002", "amandi" }, { "s003", "tharushi" },
            { "s004", "shashi" } };

    // static String[] category = new String[0];
    static String[] category = { "biscult", "shoose", "bag" };

    // static String[][] item = new String[0][4];
    static String[][] item = {
            { "I001", "biscult", "s001", "Maliban Biscult" },
            { "I002", "shoose", "s003", "Adidas" },
            { "I003", "biscult", "s004", "Manchee comee" },
            { "I004", "shoose", "s001", "Grenical" }
    };

    // static int[] qty = new int[0];
    static int[] qty = { 12, 44, 66, 23 };

    // static double[] price = new double[0];
    static double[] price = { 230.0, 5600.0, 150.0, 11000.0 };

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

    public static void grow_category(String name) {
        String[] temp = new String[category.length + 1];

        for (int i = 0; i < category.length; i++) {
            temp[i] = category[i];
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == null) {
                temp[i] = name;
            }
        }

        category = temp;
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

    public static boolean is_exist_item(String id) {
        for (int i = 0; i < item.length; i++) {
            if (item[i][2].equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static void exit_the_System() {

    }

    public static void supplier_Manage() {
        Scanner input = new Scanner(System.in);

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                           SUPLIAR MANAGE                                 |");
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

                boolean is_exist_item = is_exist_item(id);

                if (is_exist_item) {
                    System.out.println(
                            "\n+-----------------+-----------------+-----------------+-----------------+-----------------+");
                    System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                            "ITEM CODE", "DESCRIPTION", "UNIT PRICE", "QTY", "CATEGORY");
                    System.out.println(
                            "+-----------------+-----------------+-----------------+-----------------+-----------------+");

                    for (int i = 0; i < item.length; i++) {
                        if (item[i][2].equals(id)) {
                            System.out.printf("| %-15s | %-15s | %-15.2f | %-15d | %-15s |\n",
                                    item[i][0],
                                    item[i][3],
                                    price[i],
                                    qty[i],
                                    item[i][1]);
                        }
                    }

                    System.out.println(
                            "+-----------------+-----------------+-----------------+-----------------+-----------------+");

                }

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

    public static void viewSupplier() {
        Scanner input = new Scanner(System.in);

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------+");

        String title = "VIEW SUPPLIER";
        int boxWidth = 74;
        int padding = (boxWidth - title.length()) / 2;
        String line = String.format(
                "|%" + (padding + title.length()) + "s%" + (boxWidth - padding - title.length()) + "s|\n", title, "");
        System.out.print(line);

        System.out.println("+--------------------------------------------------------------------------+");

        System.out.println("+-----------------------+------------------------+");
        System.out.printf("| %-21s | %-22s |\n", "SUPPLIER ID", "SUPPLIER NAME"); // Left width align
        System.out.println("+-----------------------+------------------------+");

        for (int i = 0; i < supplier.length; i++) {
            System.out.printf("| %-21s | %-22s |\n", supplier[i][0], supplier[i][1]);
        }

        System.out.println("+-----------------------+------------------------+");

        while (true) {
            System.out.print("Do you want to go supplier manage page(Y/N)? ");
            char option = input.next().charAt(0);

            switch (option) {
                case 'y', 'Y' -> supplier_Manage();
                case 'n', 'N' -> home();
                default -> {
                    System.out.println("Invalid option. Please try again! ");
                    continue;
                }
            }
        }

    }

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
                case '5' -> item_Ranking();
                case '6' -> home();
                default -> {
                    System.out.println("Invalid option! Please try again.");
                    continue;
                }
            }
        }
    }

    public static void view_Item() {
        Scanner input = new Scanner(System.in);

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                                VIEW ITEMS                                |");
        System.out.println("+--------------------------------------------------------------------------+\n");

        if (supplier.length != 0) {

            if (category.length != 0) {

                if (item.length != 0) {
                    for (int i = 0; i < category.length; i++) {
                        System.out.println(category[i] + ":");

                        System.out.println(
                                "\n+-----------------+-----------------+-----------------+-----------------+-----------------+");
                        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                                "S_ID", "CODE", "DESC", "PRICE", "QTY");
                        System.out.println(
                                "+-----------------+-----------------+-----------------+-----------------+-----------------+");

                        for (int j = 0; j < item.length; j++) {
                            if (item[j][1].equals(category[i])) {
                                System.out.printf("| %-15s | %-15s | %-15s | %-15.2f | %-15d|\n",
                                        item[j][2],
                                        item[j][0],
                                        item[j][3],
                                        price[j],
                                        qty[j]);
                            }
                        }
                        System.out.println(
                                "+-----------------+-----------------+-----------------+-----------------+-----------------+\n");

                    }

                    while (true) {
                        System.out.print("Do you want to stock manage page(Y/N)? ");
                        char option = input.next().charAt(0);

                        switch (option) {
                            case 'y', 'Y' -> stock_Manage();
                            case 'n', 'N' -> home();
                            default -> {
                                System.out.println("invalid option. try agian!\n");
                                continue;
                            }
                        }
                    }

                } else {
                    System.out.println("OOPS! It seems that you do not have any item in the system");

                    while (true) {
                        System.out.print("Do you want to add a new item (Y/N)?");
                        char option = input.next().charAt(0);

                        switch (option) {
                            case 'y', 'Y' -> add_Item();
                            case 'n', 'N' -> stock_Manage();
                            default -> {
                                System.out.println("invalid option. try agian!\n");
                                continue;
                            }
                        }
                    }
                }
            } else {
                System.out.println("OOPS! It seems that you do not have any item categories in the system");

                while (true) {
                    System.out.print("Do you want to add a new item category(Y/N)?");
                    char option = input.next().charAt(0);

                    switch (option) {
                        case 'y', 'Y' -> addNewItem_Category();
                        case 'n', 'N' -> stock_Manage();
                        default -> {
                            System.out.println("invalid option. try agian!\n");
                            continue;
                        }
                    }
                }
            }

        } else {
            System.out.println("OOPS! It seems that you do not have any supplier in the system");

            while (true) {
                System.out.print("Do you want to add a new supplier(Y/N)?");
                char option = input.next().charAt(0);

                switch (option) {
                    case 'y', 'Y' -> addSupplier();
                    case 'n', 'N' -> stock_Manage();
                    default -> {
                        System.out.println("invalid option. try agian!\n");
                        continue;
                    }
                }
            }
        }
    }

    public static void item_Ranking() {
        Scanner input = new Scanner(System.in);

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                             RANKED UNIT PRICE                            |");
        System.out.println("+--------------------------------------------------------------------------+\n");

        double[] temp_price = new double[price.length];
        int[] ranking = new int[price.length];

        // ranking initailization
        for (int i = 0; i < price.length; i++) {
            ranking[i] = i;
        }

        // price sorting
        for (int i = 0; i < temp_price.length; i++) {
            temp_price[i] = price[i];
        }

        for (int i = 0; i < price.length - 1; i++) {
            for (int j = 0; j < price.length - i - 1; j++) {

                if (temp_price[j] > temp_price[j + 1]) {

                    double temp = temp_price[j];
                    temp_price[j] = temp_price[j + 1];
                    temp_price[j + 1] = temp;

                    // ranking set
                    int temp2 = ranking[j];
                    ranking[j] = ranking[j + 1];
                    ranking[j + 1] = temp2;
                }
            }
        }

        System.out.println(
                "\n+-------+-------+----------------------+------------+-------+------------+");
        System.out.printf("| %-5s | %-5s | %-20s | %-10s | %-5s | %-10s |\n",
                "S_ID", "CODE", "DESC", "PRICE", "QTY", "CATEGORY");
        System.out.println(
                "+-------+-------+----------------------+------------+-------+------------+");

        for (int j = 0; j < ranking.length; j++) {
            int index = ranking[j];

            System.out.printf("| %-5s | %-5s | %-20s | %-10.2f | %-5d |",
                    item[index][2], // S_ID
                    item[index][0], // CODE
                    item[index][3], // DESC
                    price[index], // PRICE
                    qty[index] // QTY
            ); 

            for (int i = 0; i < category.length; i++) {
                if (item[i][2].equals(item[index][2])) {
                    System.out.printf("%-12s|\n",item[index][1]);// CATEGORY
                }
            }

        }

        System.out.println
                ("+-------+-------+----------------------+------------+-------+------------+");

    }

    public static void getItemSupplierWise() {
        Scanner input = new Scanner(System.in);

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                       SEARCH ITEMS SUPPLIER WISE                         |");
        System.out.println("+--------------------------------------------------------------------------+\n");

        while (true) {
            System.out.print("Enter the suppllier Id: ");
            String id = input.next();

            boolean is_true = is_exist_supplier_id(id);

            if (is_true) {
                System.out.print("Supplier name: " + getSupplier_by_Id(id));

                System.out.println(
                        "\n+-----------------+-----------------+-----------------+-----------------+-----------------+");
                System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                        "ITEM CODE", "DESCRIPTION", "UNIT PRICE", "QTY", "CATEGORY");
                System.out.println(
                        "+-----------------+-----------------+-----------------+-----------------+-----------------+");

                for (int i = 0; i < item.length; i++) {
                    if (item[i][2].equals(id)) {
                        System.out.printf("| %-15s | %-15s | %-15.2f | %-15d | %-15s |\n",
                                item[i][0],
                                item[i][3],
                                price[i],
                                qty[i],
                                item[i][1]);
                    }
                }

                System.out.println(
                        "+-----------------+-----------------+-----------------+-----------------+-----------------+");

                while (true) {
                    System.out.print("Search successfully. Do you want to another search? (Y/N) ");
                    char option = input.next().charAt(0);

                    switch (option) {
                        case 'y', 'Y' -> searchSupplier();
                        case 'n', 'N' -> stock_Manage();
                        default -> {
                            System.out.println("Invalid option. Please try again!\n");
                            continue;
                        }
                    }
                }

            } else {
                System.out.println("Enter the Invaild supplier Id. please try again!");
                continue;
            }
        }
    }

    public static boolean exist_suppiler() {
        for (int i = 0; i < supplier.length; i++) {
            return true;
        }
        return false;
    }

    public static boolean exist_category() {
        for (int i = 0; i < category.length; i++) {
            return true;
        }
        return false;
    }

    public static boolean is_exist_item_code(String code) {
        for (int i = 0; i < item.length; i++) {
            if (item[i][0].equals(code)) {
                return true;
            }
        }
        return false;
    }

    public static void item_grow(String code, String catogery, String supplier, String description) {
        String[][] temp = new String[item.length + 1][4];

        for (int i = 0; i < item.length; i++) {
            temp[i][0] = item[i][0];
            temp[i][1] = item[i][1];
            temp[i][2] = item[i][2];
            temp[i][3] = item[i][3];
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i][0] == null) {
                temp[i][0] = code;
                temp[i][1] = catogery;
                temp[i][2] = supplier;
                temp[i][3] = description;
            }
        }

        item = temp;
    }

    public static void qty_grow(int value) {
        int[] temp = new int[qty.length + 1];

        for (int i = 0; i < qty.length; i++) {
            temp[i] = qty[i];
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) {
                temp[i] = value;
            }
        }

        qty = temp;

    }

    public static void price_grow(double value) {
        double[] temp = new double[price.length + 1];

        for (int i = 0; i < price.length; i++) {
            temp[i] = price[i];
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0.0) {
                temp[i] = value;
            }
        }

        price = temp;

    }

    public static void add_Item() {
        Scanner input = new Scanner(System.in);

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                                 ADD ITEM                                 |");
        System.out.println("+--------------------------------------------------------------------------+\n");

        if (exist_category()) {

            if (exist_suppiler()) {

                L1: while (true) {
                    System.out.print("Item code: ");
                    String code = input.nextLine();

                    boolean is_item = is_exist_item_code(code);

                    if (!is_item) {

                        System.out.println("\nSupplier List: ");

                        System.out
                                .println("+--------------------+-------------------------+-------------------------+");
                        System.out.printf("| %-18s | %-23s | %-23s |\n", "#", "SUPPLIER ID", "SUPPLIER NAME");
                        System.out
                                .println("+--------------------+-------------------------+-------------------------+");

                        for (int i = 0; i < supplier.length; i++) {
                            System.out.printf("| %-18d | %-23s | %-23s |\n", (i + 1), supplier[i][0], supplier[i][1]);
                        }

                        System.out.println(
                                "+--------------------+-------------------------+-------------------------+\n");

                        while (true) {
                            System.out.print("Enter the supplier number: ");
                            int sp_num = input.nextInt();

                            if (sp_num <= supplier.length) {

                                for (int i = 0; i < supplier.length; i++) {

                                    if (sp_num == (i + 1)) {
                                        String supplier_id = supplier[i][0];

                                        System.out.println();
                                        System.out.println("Item categories:");

                                        System.out.println("+--------------------+-------------------------+");
                                        System.out.printf("| %-18s | %-23s |\n", "#", "CATEGORY NAME");
                                        System.out.println("+--------------------+-------------------------+");

                                        for (int j = 0; j < category.length; j++) {
                                            System.out.printf("| %-18s | %-23s |\n", (j + 1), category[j]);
                                        }

                                        System.out.println("+--------------------+-------------------------+\n");

                                        while (true) {
                                            System.out.print("Enter the catogery name: ");
                                            int cat_num = input.nextInt();
                                            input.nextLine();

                                            if (cat_num <= category.length) {

                                                for (int j = 0; j < category.length; j++) {

                                                    if (cat_num == (j + 1)) {
                                                        String catogery_name = category[j];

                                                        System.out.println();

                                                        System.out.print("Description:");
                                                        String des = input.nextLine();

                                                        System.out.print("Unit price:");
                                                        double price = Double.parseDouble(input.nextLine());

                                                        System.out.print("qty On Hand:");
                                                        int qty = Integer.parseInt(input.nextLine());

                                                        item_grow(code, catogery_name, supplier_id, des);
                                                        qty_grow(qty);
                                                        price_grow(price);

                                                        while (true) {
                                                            System.out.print(
                                                                    "added successfully! do you want to another Item(Y/N)? ");
                                                            char option = input.next().charAt(0);

                                                            switch (option) {
                                                                case 'y', 'Y' -> add_Item();
                                                                case 'n', 'N' -> stock_Manage();
                                                                default -> {
                                                                    System.out.println(
                                                                            "Invalid option. please try again!\n");
                                                                    continue;
                                                                }
                                                            }
                                                        }

                                                    }
                                                }
                                            } else {
                                                System.out.println("Invalid supplier number. please try again!\n");
                                                continue;
                                            }
                                        }
                                    }
                                }
                            } else {
                                System.out.println("Invalid supplier number. please try again!\n");
                                continue;
                            }
                        }

                    } else {
                        System.out.println("Already exists. please try again!\n");
                        continue L1;
                    }
                }

            } else {
                System.out.println("OOPS! It seems that you do not have any supplier in the system");

                while (true) {
                    System.out.print("Do you want to add a new supplier(Y/N)?");
                    char option = input.next().charAt(0);

                    switch (option) {
                        case 'y', 'Y' -> addSupplier();
                        case 'n', 'N' -> stock_Manage();
                        default -> {
                            System.out.println("invalid option. try agian!");
                            continue;
                        }
                    }
                }
            }
        } else {
            System.out.println("OOPS! It seems that you do not have any item categories in the system");

            while (true) {
                System.out.print("Do you want to add a new item category(Y/N)?");
                char option = input.next().charAt(0);

                switch (option) {
                    case 'y', 'Y' -> addNewItem_Category();
                    case 'n', 'N' -> stock_Manage();
                    default -> {
                        System.out.println("invalid option. try agian!");
                        continue;
                    }
                }
            }

        }
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

    public static void update_category_name(String name, String newName) {
        for (int i = 0; i < category.length; i++) {
            if (category[i].equals(name)) {
                category[i] = newName;
            }
        }
    }

    public static void updateItem_Category() {
        Scanner input = new Scanner(System.in);

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                           UPDATE ITEM CATEGORY                           |");
        System.out.println("+--------------------------------------------------------------------------+\n");

        L1: while (true) {
            System.out.print("Category name: ");
            String name = input.next();

            boolean is_exist = is_exist_category_with_name(name);

            if (is_exist) {
                System.out.print("New category name: ");
                String newName = input.next();

                update_category_name(name, newName);

                System.out.println("Update successfully!\n");

                L2: while (true) {
                    System.out.print("Do you want to Update another category (Y/N): ");
                    char ch = input.next().charAt(0);

                    switch (ch) {
                        case 'Y', 'y' -> updateItem_Category();
                        case 'N', 'n' -> manageItemCategories();
                        default -> {
                            System.out.println("Invalid choice!");
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

    public static boolean is_exist_category_with_name(String name) {
        for (int i = 0; i < category.length; i++) {
            if (category[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void ungrow_category(String id) {
        String[] temp = new String[category.length - 1];

        int j = 0;
        for (int i = 0; i < temp.length; i++) {
            if (category[i].equals(id)) {
                j++;
                continue;
            } else {
                temp[i - j] = category[i];
            }

        }

        category = temp;
    }

    public static void deleteItem_Category() {
        Scanner input = new Scanner(System.in);

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                           DELETE ITEM CATEGORY                           |");
        System.out.println("+--------------------------------------------------------------------------+\n");

        L1: while (true) {
            System.out.print("Category name: ");
            String name = input.nextLine();

            boolean is_exist_id = is_exist_category_with_name(name);

            if (is_exist_id) {
                ungrow_category(name);

                L2: while (true) {
                    System.out.print("delete successfully! . Do you want to delete another? (Y/N)");
                    char option = input.next().charAt(0);

                    switch (option) {
                        case 'y', 'Y' -> deleteItem_Category();
                        case 'n', 'N' -> manageItemCategories();
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

    public static void addNewItem_Category() {
        Scanner input = new Scanner(System.in);

        clearConsole();

        System.out.println("+--------------------------------------------------------------------------+");
        System.out.println("|                            ADD ITEM CATEGORY                             |");
        System.out.println("+--------------------------------------------------------------------------+\n");

        L1: while (true) {
            System.out.print("Add new Item category: ");
            String name = input.nextLine();

            boolean is_exist_category = is_exist_category_with_name(name);

            if (!is_exist_category) {

                grow_category(name);

                L2: while (true) {
                    System.out.print("added successfully! Do you want to add another category (Y/N)? ");
                    char option = input.next().charAt(0);

                    switch (option) {
                        case 'y', 'Y' -> addNewItem_Category();
                        case 'n', 'N' -> manageItemCategories();
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

        System.out.println("+----------------------------------------------------------------------------+");
        System.out.println("|                              LOGIN PAGE                              |");
        System.out.println("+----------------------------------------------------------------------------+");

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
        login();
    }
}