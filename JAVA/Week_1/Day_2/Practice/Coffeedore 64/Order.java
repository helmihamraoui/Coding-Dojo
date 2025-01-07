import java.util.ArrayList;

public class Order {
    private String customerName;
    private ArrayList<Item> items;

    public Order(String customerName) {
        this.customerName = customerName;
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void printOrder() {
        System.out.println("Order for " + customerName + ":");
        for (Item item : items) {
            System.out.println(item);
        }
    }
}
