import java.util.ArrayList;
import java.util.List;

public class Store {
    private static Store instance; //instance variable
    public static Store getInstance(){
        //checking is the instance is null abd creating if needed
        if(instance == null){
            instance = new Store();
        }
        return instance;
    }//

    List<GroceryItem> items = new ArrayList<>(); //List of items in the store

    //Constructor of the store class
    public Store(){
        setItems();
    }

    //adding example items to the store
    public void setItems(){
        GroceryItem SignalToothPaste = new GroceryItem(1,"Signal Toothpaste", 256.00,"160g","01-02-2024","12-09-2025","Unilever",0);
        GroceryItem Samaposha = new GroceryItem(2,"Samaposha",565.00, "700g","11-03-2024","12-12-2024","CBL",0);
        GroceryItem FreshMilk = new GroceryItem(3,"FreshMilk",550.00, "1l","01-02-2024","12-09-2025","Ambewela",0);
        GroceryItem Kottume = new GroceryItem(4,"Kottume",130.00, "80g","01-02-2024","12-09-2025","Prima",0);
        GroceryItem Whitesugar = new GroceryItem(5,"White Sugar",42.00, "100g","01-02-2024","12-09-2025","Keells",0);
        GroceryItem Dhal = new GroceryItem(6,"Dhal",48.00, "100g","01-02-2024","12-09-2025","Keells",0);
        GroceryItem Sambarice = new GroceryItem(7,"Samba Rice",32.00, "100g","01-02-2024","12-09-2025","Araliya",0);
        GroceryItem CocaCola = new GroceryItem(8,"Coca Cola",400.00, "1.5l","01-02-2024","12-09-2025","CocaCola",0);
        items.add(SignalToothPaste);
        items.add(Samaposha);
        items.add(FreshMilk);
        items.add(Kottume);
        items.add(Whitesugar);
        items.add(Dhal);
        items.add(Sambarice);
        items.add(CocaCola);
    }

    public GroceryItem getItem(int itemCode) throws ItemCodeNotFound{
        for(GroceryItem item: items){
            if(item.getItemCode() == itemCode){
                return item;
            }
        }
        throw new ItemCodeNotFound("Item not found!");
    }

}