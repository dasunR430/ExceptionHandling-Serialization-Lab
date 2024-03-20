import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
                billing(createBill());
                break;
            } else if (option.equals("2")) {
                Bill bill = Bill.getHeldBill();
                billing(bill);
                break;
            } else if (option.equals("3")) {
                break;
            }
        }
    }

    private Bill createBill(){
        System.out.println("Billing....");
        System.out.print("Enter customer phone number: ");
        Scanner scanner = new Scanner(System.in);
        String phone = scanner.nextLine();
        Bill bill;
        try{
            Customer cutomer = new Customers().getCustomer(phone);
            bill = new Bill(cashierName, branch, cutomer.getName());
        } catch (CustomerNotFound e) {
            bill = new Bill(cashierName,branch);
        }
        return bill;
    }

    private void billing(Bill bill){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Choose an Option");
            System.out.println("1. Add Item\n2. Print the Bill\n3. Hold the Bill");
            System.out.print("Option: ");
            String option = scanner.nextLine();
            if (option.equals("1")) {
                GroceryItem gItem = getItemDetails();
                if(gItem != null){
                    gItem.showDetails();
                    System.out.print("Enter the quantity: ");
                    double quantity = Double.parseDouble(scanner.nextLine());
                    bill.addItem(new BillItem(gItem, quantity));
                    System.out.println("Item Added Successfully");
                }

            } else if (option.equals("2")) {
                bill.printBill();
                break;
            } else if (option.equals("3")) {
                bill.holdBill();
            }

        }
    }

    public GroceryItem getItemDetails() {
        GroceryItem item = null;
        try {
            InputStreamReader r = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(r);
            int item_code = Integer.parseInt(br.readLine());
            item = null;
            item = new Store().getItem(item_code);
            br.close();
            r.close();
        } catch (ItemCodeNotFound | IOException e) {
            System.out.println("Item not found!");
        }

        return item;
    }
}
