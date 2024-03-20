import java.util.ArrayList;
import java.util.List;

public class Customers {
    List<Customer> customerList = new ArrayList<>();

    public Customer getCustomer(String phoneNo){
        for (Customer customer: customerList){
            if(customer.getPhoneNo().equals(phoneNo)){
                return customer;
            }
        }

    }
}
