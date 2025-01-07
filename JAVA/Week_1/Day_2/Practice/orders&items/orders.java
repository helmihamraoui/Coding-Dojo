import java.util.ArrayList;

public class orders {
    private String name;
    private ArrayList<items> items;
    private double total;
    private boolean ready;

    public orders(String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.total = 0;
        this.ready = false;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public ArrayList<items> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    public boolean isReady() {
        return ready;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void addItem(items item) {
        this.items.add(item);
        this.total += item.getPrice();
    }

    public void markReady() {
        this.ready = true;
    }
}
