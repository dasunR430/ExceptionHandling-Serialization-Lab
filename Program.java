import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        while(true){
            System.out.println("\nWelcome to Super-Saving supermarket POS");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Press Enter to login. Enter 0 to exit. ");
            String option = scanner.nextLine();
            if(option.equals("0")){
                break;
            }
            System.out.print("Enter the branch: ");
            String branch = scanner.nextLine();
            System.out.print("Enter the Cashier's name: ");
            String cashierName = scanner.nextLine();

            POS pos = new POS(cashierName,branch);
            pos.startOperation();
        }
        System.out.println("Exiting.... Developed by Syntax Samurais.");
    }
}
