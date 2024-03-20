import java.io.Serializable;

public class BillItem implements Serializable {

    private String itemName;
    private double itemprice;
    private double discountprecentage;
    private double quentity;
    private double netprice;
    private double discount;

    public BillItem(String itemName,double itemprice,double discountprecentage,double quentity){
        this.itemName=itemName;
        this.discountprecentage=discountprecentage;
        this.quentity=quentity;
        this.itemprice=itemprice;
        calculate_netprice();
        calculate_discount();
    }
    public void calculate_netprice(){
        netprice=itemprice*quentity;
    }
    public void calculate_discount(){
        discount=itemprice*(discountprecentage/100)*quentity;
    }
    public double getNetPrice(){
        return netprice;
    }
    public double getDiscount(){
        return discount;
    }
    public void print(){
        System.out.println("Item Name : "+itemName+" | Item Price : "+itemprice+" | Quentity : "+quentity);
        System.out.println("Net Price : "+(itemprice*quentity));
        System.out.println("Discount  : "+(itemprice*(discountprecentage/100)*quentity));

    }
}
