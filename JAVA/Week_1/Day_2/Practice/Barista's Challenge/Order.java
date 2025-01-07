import java.util.ArrayList;

public class Order {

    // MEMBER VARIABLES
    private String name; // default value "Guest"
    private boolean ready; // default value false
    private ArrayList<Item> items; // defaults to an empty list

    // CONSTRUCTOR (No arguments)
    public Order() {
        this.name = "Guest";
        this.items = new ArrayList<Item>();
    }

    // OVERLOADED CONSTRUCTOR (Takes a name as an argument)
    public Order(String name) {
        this.name = name;
        this.items = new ArrayList<Item>();
    }

    // GETTERS & SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    // ORDER METHODS

    // Add an Item to the order
    public void addItem(Item item) {
        this.items.add(item);
    }

    // Get the status message of the order
    public String getStatusMessage() {
        if (this.ready) {
            return "Your order is ready.";
        } else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }

    // Calculate the total price of the order
    public double getOrderTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    // Display the order details
    public void display() {
        System.out.println("Customer Name: " + this.name);
        for (Item item : items) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total: $" + getOrderTotal());
    }
}
