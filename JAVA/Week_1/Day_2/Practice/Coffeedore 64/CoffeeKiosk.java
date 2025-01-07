import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    public CoffeeKiosk() {
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    // Method to add a new item to the menu
    public void addMenuItem(String name, double price) {
        Item newItem = new Item(name, price);
        newItem.setIndex(menu.size()); // Set the index of the item to its position in the menu
        menu.add(newItem);
    }

    // Display the menu
    public void displayMenu() {
        for (Item item : menu) {
            System.out.println(item.getIndex() + " " + item);
        }
    }

    // Method to create a new order by taking user input
    public void newOrder() {
        Scanner scanner = new Scanner(System.in);

        // Get customer name for new order
        System.out.println("Please enter customer name for new order:");
        String name = scanner.nextLine();

        // Create a new order with the customer's name
        Order order = new Order(name);

        // Display the menu
        displayMenu();

        // Collect the user's order
        System.out.println("Please enter a menu item index or q to quit:");

        String itemNumber = scanner.nextLine();

        while (!itemNumber.equals("q")) {
            try {
                int itemIndex = Integer.parseInt(itemNumber);
                if (itemIndex >= 0 && itemIndex < menu.size()) {
                    // Add the selected item to the order
                    order.addItem(menu.get(itemIndex));
                } else {
                    System.out.println("Invalid item index.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number.");
            }

            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = scanner.nextLine();
        }

        // Print the order details
        order.printOrder();
        orders.add(order);
    }

    // Ninja Bonus: Method to add menu items manually via user input
    public void addMenuItemByInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the name of the menu item:");
        String name = scanner.nextLine();

        System.out.println("Please enter the price of the menu item:");
        double price = Double.parseDouble(scanner.nextLine());

        addMenuItem(name, price);
    }

    // Main method to test the CoffeeKiosk functionality
    public static void main(String[] args) {
        CoffeeKiosk kiosk = new CoffeeKiosk();

        // Adding some items to the menu
        kiosk.addMenuItem("Banana", 2.00);
        kiosk.addMenuItem("Coffee", 1.50);
        kiosk.addMenuItem("Latte", 4.50);
        kiosk.addMenuItem("Cappuccino", 3.00);
        kiosk.addMenuItem("Muffin", 4.00);

        // Displaying the menu
        kiosk.displayMenu();

        // Creating a new order
        kiosk.newOrder();

        // Adding new items via input
        kiosk.addMenuItemByInput();
    }
}
