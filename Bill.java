import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bill implements Serializable {
    private String cashierName, branch, customerName ="Not Registered";
    private double total = 0, totalDiscount = 0, totalPrice = 0;

    private List<BillItem> billItems = new ArrayList<>();

    public Bill(String cashierName, String branch, String customerName) {
        this.cashierName = cashierName;
        this.branch = branch;
        this.customerName = customerName;
    }

    public Bill(String cashierName, String branch) {
        this.cashierName = cashierName;
        this.branch = branch;
    }

    public void addItem(BillItem billItem){
        billItems.add(billItem);
        total += billItem.getNetPrice();
        totalDiscount+=billItem.getDiscount();
        totalPrice = total - totalDiscount;
    }

    public void printBill(){
        //Get current time
        Date currentDate = new Date();

        // Format current date as string
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = dateFormat.format(currentDate);

        // Format current time as string
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String timeString = timeFormat.format(currentDate);

        System.out.println("***** Super-Saving supermarket *****");
        System.out.println("Cashier Name: "+cashierName);
        System.out.println("Branch: "+branch);
        System.out.println("Customer Name: "+customerName);
        System.out.println("Date: "+dateString);
        System.out.println("Time: "+timeString);
        System.out.println();
        System.out.println("Items");
        System.out.println("Items Code\tItem Name\tUnit Price\tQuantity\tDiscount\tNet Price");

        for(int i=0; i<billItems.size(); i++){
            BillItem billItem = billItems.get(i);
            System.out.print((i+1)+". "); billItem.printDetails();

        }
        System.out.println();
        System.out.println("Total Discount: "+ totalDiscount);
        System.out.println("Total Price: "+totalPrice);
    }

    public void holdBill()  {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("BillsOnHold.ser"));
            objectOutputStream.writeObject(this);

        } catch (IOException e) {
            System.out.println("Bill holding Failed!");
        }
        finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                System.out.println("Bill holding Failed!");
            }
        }

    }
    public void showCurrentDetails(){
        System.out.println("Held bill details");
        System.out.println("Items");
        System.out.println("Items Code\tItem Name\tUnit Price\tQuantity\tDiscount\tNet Price");

        for(int i=0; i<billItems.size(); i++){
            BillItem billItem = billItems.get(i);
            System.out.print((i+1)+". "); billItem.printDetails();

        }
        System.out.println();

    }
}
