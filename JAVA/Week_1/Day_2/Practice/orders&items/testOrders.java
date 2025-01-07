public class testOrders {
    public static void main(String[] args) {
        // Create Items
        items item1 = new items("mocha", 3.50);
        items item2 = new items("latte", 4.00);
        items item3 = new items("drip coffee", 2.50);
        items item4 = new items("cappuccino", 4.50);

        // Create Orders
        orders order1 = new orders("Cindhuri");
        orders order2 = new orders("Jimmy");
        orders order3 = new orders("Noah");
        orders order4 = new orders("Sam");

        // Print order1 to the console
        System.out.println("Order 1: " + order1.getName());

        // Predict what happens when printing 'order1.getTotal()'
        System.out.println("Order 1 Total: " + order1.getTotal());

        // Add item1 to order2 and update total
        order2.addItem(item1);
        System.out.println("Order 2 Total after adding mocha: " + order2.getTotal());

        // Add cappuccino to order3 and update total
        order3.addItem(item4);
        System.out.println("Order 3 Total after adding cappuccino: " + order3.getTotal());

        // Add latte to order4 and update total
        order4.addItem(item2);
        System.out.println("Order 4 Total after adding latte: " + order4.getTotal());

        // Mark Cindhuri's order as ready
        order1.markReady();
        System.out.println("Order 1 Ready Status: " + order1.isReady());

        // Sam ordered 2 more lattes
        order4.addItem(item2);
        order4.addItem(item2);
        System.out.println("Order 4 Total after adding 2 more lattes: " + order4.getTotal());

        // Mark Jimmy's order as ready
        order2.markReady();
        System.out.println("Order 2 Ready Status: " + order2.isReady());
    }
}
