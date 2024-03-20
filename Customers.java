import java.util.ArrayList;
import java.util.List;

public class Customers {
    List<Customer> customerList = new ArrayList<>();


    private void setCustomers(){
        Customer customer1 = new Customer("Kamal Perera", "0712345678");
        Customer customer2 = new Customer("Nimal Silva", "0723456789");
        Customer customer3 = new Customer("Saman Fernando", "0776543210");
        Customer customer4 = new Customer("Sunil Rajapakse", "0765432109");
        Customer customer5 = new Customer("Bandara Gunawardena", "0754321098");
        Customer customer6 = new Customer("Chamara Jayawardena", "0787654321");
        Customer customer7 = new Customer("Dinesh Wijesinghe", "0709876543");
        Customer customer8 = new Customer("Gayan Seneviratne", "0732109876");
        Customer customer9 = new Customer("Harsha Karunaratne", "0743210987");
        Customer customer10 = new Customer("Janaka Perera", "0798765432");

        customerList.add(customer1);
    }

    public Customer getCustomer(String phoneNo) throws CustomerNotFound {
        for (Customer customer: customerList){
            if(customer.getPhoneNo().equals(phoneNo)){
                return customer;
            }
        }
        throw new CustomerNotFound();
    }
}
