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
            } else if (option.equals("2")) {
                Bill bill = Bill.getHeldBill();
                if(bill != null) {
                    bill.showCurrentDetails();
                    billing(bill);
                }
            } else if (option.equals("3")) {
                break;
            }
        }
    }

    // Initialy creating a bill
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
            System.out.println("Customer is not Register! Continuing without customer name.");
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
                    String quantityString = scanner.nextLine();
                    double quantity = Double.parseDouble(quantityString);
                    bill.addItem(new BillItem(gItem, quantity));
                    System.out.println("Item Added Successfully");
                }

            } else if (option.equals("2")) {
                bill.printBill();
                break;
            } else if (option.equals("3")) {
                bill.holdBill();
                System.out.println("Bill Held Successfully");
                break;
            }

        }
    }


    // Get the item of the given item code from the database and return it
    private GroceryItem getItemDetails() {
        GroceryItem item = null;
        try {
            InputStreamReader r = new InputStreamReader(System.in); BufferedReader br = new BufferedReader(r);
            System.out.print("Enter the item code: ");
            int item_code = Integer.parseInt(br.readLine());
            item = null;
            item = new Store().getItem(item_code);
        } catch (ItemCodeNotFound e) {
            // If the item is not found in the database
            System.out.println("Item not found!");
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        // return null if an exception thrown and caught
        return item;
    }
}
