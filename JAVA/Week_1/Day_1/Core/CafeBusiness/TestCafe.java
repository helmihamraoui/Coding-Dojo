import java.util.ArrayList;
import java.util.Arrays;

public class TestCafe {
    public static void main(String[] args) {
        // Create an instance of CafeUtil
        CafeUtil appTest = new CafeUtil();

        // Streak Goal Test
        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal(10));

        // Order Total Test
        System.out.println("----- Order Total Test -----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %.2f \n\n", appTest.getOrderTotal(lineItems));

        // Display Menu Test
        System.out.println("----- Display Menu Test -----");
        ArrayList<String> menu = new ArrayList<>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        appTest.displayMenu(menu);

        // Add Customer Test
        System.out.println("\n----- Add Customer Test -----");
        ArrayList<String> customers = new ArrayList<>();
        // Uncomment below to test multiple customer entries
        for (int i = 0; i < 4; i++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }

        //Print Price Chart
        System.out.println("\n----- Price Chart Test -----");
        appTest.printPriceChart("Columbian Coffee Grounds", 15.0, 3);

        //Overloaded Display Menu
        System.out.println("\n----- Overloaded Display Menu Test -----");
        ArrayList<Double> prices = new ArrayList<>(Arrays.asList(1.5, 3.5, 4.5, 3.5));
        appTest.displayMenu(menu, prices);

        //Add Multiple Customers
        System.out.println("\n----- Add Multiple Customers Test -----");
        appTest.addCustomers(customers);
    }
}
