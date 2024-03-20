public class GroceryItem {
    private int itemCode;
    private String itemName;
    private double unitPrice;
    private String weightOrSize;
    private String dateOfManufacture;
    private String dateOfExpiry;
    private String manufacturerName;
    private double discountRate;
    //asd


    public GroceryItem(int itemCode,String itemName, double unitPrice, String weightOrSize, String dateOfManufacture, String dateOfExpiry, String manufacturerName, double discountRate) {
        this.itemCode = itemCode;
        this.itemName = itemName;
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

    public String getItemName() {
        return itemName;
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

}