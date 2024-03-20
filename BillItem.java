import java.io.Serializable;

public class BillItem implements Serializable {

    private GroceryItem groceryItem;
    private double quantity;
    private double netprice;
    private double discount;

    public BillItem(GroceryItem groceryItem, double quantity) {
        this.groceryItem = groceryItem;
        this.quantity = quantity;
        calculate_discount();
        calculate_netprice();
    }

    public void calculate_netprice(){
        netprice= groceryItem.getUnitPrice()* quantity;
    }
    public void calculate_discount(){
        discount=(groceryItem.getUnitPrice()* groceryItem.getDiscount())/100* quantity;
    }
    public double getNetPrice(){
        return netprice;
    }
    public double getDiscount(){
        return discount;
    }
    public void printDetails(){
        System.out.println(groceryItem.getItemCode()+"\t"+groceryItem.getItemName()+"\t"+ groceryItem.getUnitPrice()+"\t"+ quantity +"\t"+discount+"\t"+netprice);
    }
}
