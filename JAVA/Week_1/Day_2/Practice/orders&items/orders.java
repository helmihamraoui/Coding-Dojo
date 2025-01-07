import java.util.ArrayList;

public class orders {
    String name;
    ArrayList<items> items;
    double total;
    boolean ready;

    public orders(String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.total = 0;
        this.ready = false;
    }

    public void addItem(items item) {
        this.items.add(item);
        this.total += item.price;
    }

    public void markReady() {
        this.ready = true;
    }
}
