import java.util.Scanner;

public class POS {
    private String cashierName, branch;

    public POS(String cashierName, String branch) {
        this.cashierName = cashierName;
        this.branch = branch;
    }

    public void startOperation(){
        System.out.println("Logged in as "+ cashierName);
        while (true) {
            System.out.println("Choose an Option");
            System.out.println("1. Create a Bill\n2. Get held bill\n3. Logout");
            System.out.print("Option: ");
            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            if (option.equals("1")) {
                System.out.println("Billing....");
                System.out.print("Enter customer phone number: ");
                String phone = scanner.nextLine();
                Bill bill;
                try{
                    Customer cutomer = new Customers().getCustomer(phone);
                    bill = new Bill(cashierName, branch, cutomer.getName());
                } catch (CustomerNotFound e) {
                    bill = new Bill(cashierName,branch);
                }


            } else if (option.equals("2")) {

            } else if (option.equals("3")) {
                break;
            }
        }
    }
}
