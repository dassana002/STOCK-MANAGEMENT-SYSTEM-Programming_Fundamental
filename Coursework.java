import java.util.Scanner;

class Coursework {
    static final String user_Name = "Dassana";
    static final String user_Password = "Dassana@123";

    public static void homePage() {
        Scanner input = new Scanner(System.in);

        System.out.println("+---------------------------------------------------------------------------------------+");
        System.out.println("|\t\t\t\t\tLOGIN PAGE\t\t\t\t\t|");
        System.out.println("+---------------------------------------------------------------------------------------+\n");

        L1: while (true) {
            System.out.print("User name: ");
            String name = input.nextLine();

            if (user_Name.equals(name)) {

                L2: while (true) {
                    System.out.print("Password: ");
                    String password = input.nextLine();

                    if (user_Password.equals(password)) {
                        System.out.println("Login successful!");
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
        homePage();
    }
}