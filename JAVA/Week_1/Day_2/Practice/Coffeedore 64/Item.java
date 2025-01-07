public class Item {
    private String name;
    private double price;
    private int index; // The new member variable to store the index

    // Constructor
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter and Setter for index
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    // Getters for name and price
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return this.name + " -- $" + this.price;
    }
}
