import java.util.ArrayList;

public class CafeUtil {

    // Calculate the streak goal
    public int getStreakGoal(int numWeeks) {
        int sum = 0;
        for (int i = 1; i <= numWeeks; i++) {
            sum += i;
        }
        return sum;
    }

    // Calculate the order total
    public double getOrderTotal(double[] prices) {
        double total = 0.0;
        for (double price : prices) {
            total += price;
        }
        return total;
    }

    // Display the menu
    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + " " + menuItems.get(i));
        }
    }

    // Add a customer
    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String username = System.console().readLine();
        System.out.println("Hello, " + username + "!");
        System.out.println("There are " + customers.size() + " people in front of you.");
        customers.add(username);
        System.out.println(customers);
    }

    // Print Price Chart
    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(product);
        for (int i = 1; i <= maxQuantity; i++) {
            double discountedPrice = price * i - 0.50 * (i - 1);
            System.out.printf("%d - $%.2f\n", i, discountedPrice);
        }
    }

    // Overloaded displayMenu
    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if (menuItems.size() != prices.size()) {
            return false;
        }
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%d %s -- $%.2f\n", i, menuItems.get(i), prices.get(i));
        }
        return true;
    }

    // Add multiple customers
    public void addCustomers(ArrayList<String> customers) {
        System.out.println("Enter customer names. Type 'q' to quit:");
        while (true) {
            String name = System.console().readLine();
            if (name.equals("q")) {
                break;
            }
            customers.add(name);
            System.out.println("Added: " + name);
        }
        System.out.println("Final Customer List: " + customers);
    }
}
