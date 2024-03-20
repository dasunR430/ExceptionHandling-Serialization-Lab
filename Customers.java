import java.util.ArrayList;
import java.util.List;

public class Customers {
    List<Customer> customerList = new ArrayList<>();


    private void setCustomers(){

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
