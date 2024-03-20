public class GroceryItem {
    private int itemCode;
    private double unitPrice;
    private String weightOrSize;
    private String dateOfManufacture;
    private String dateOfExpiry;
    private String manufacturerName;
    private double discountRate;


    public GroceryItem(int itemCode, double unitPrice, String weightOrSize, String dateOfManufacture, String dateOfExpiry, String manufacturerName, double discountRate) {
        this.itemCode = itemCode;
        this.unitPrice = unitPrice;
        this.weightOrSize = weightOrSize;
        this.dateOfManufacture = dateOfManufacture;
        this.dateOfExpiry = dateOfExpiry;
        this.manufacturerName = manufacturerName;
        this.discountRate = discountRate;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getWeightOrSize() {
        return weightOrSize;
    }

    public void setWeightOrSize(String weightOrSize) {
        this.weightOrSize = weightOrSize;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(String dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public double getDiscount() {
        return discountRate;
    }

    public void setDiscount(float discountRate) {
        this.discountRate = discountRate;
    }

    public  void showDetails(){
        System.out.println("Item Code           : "+itemCode);
        System.out.println("Unit price          : "+unitPrice);
        System.out.println("Weight or Size      : "+weightOrSize);
        System.out.println("Date of Manufacture : "+dateOfManufacture);
        System.out.println("Date of Expiry      : "+dateOfExpiry);
        System.out.println("Manufacturer Name   : "+manufacturerName);
        System.out.println("Discount Rate       : "+discountRate);
    }
}