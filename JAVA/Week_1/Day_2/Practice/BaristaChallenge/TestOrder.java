public class TestOrder {
    public static void main(String[] args) {

        // Create 2 orders for unspecified guests
        Order order1 = new Order();
        Order order2 = new Order();

        // Create 3 orders with specified names
        Order order3 = new Order("Cindhuri");
        Order order4 = new Order("Kaitlin");
        Order order5 = new Order("Joe");

        // Add items to the orders
        order1.addItem(new Item("drip coffee", 1.50));
        order1.addItem(new Item("capuccino", 3.50));

        order2.addItem(new Item("latte", 4.00));
        order2.addItem(new Item("muffin", 2.50));

        order3.addItem(new Item("espresso", 2.00));
        order3.addItem(new Item("croissant", 2.50));

        order4.addItem(new Item("mocha", 3.75));
        order4.addItem(new Item("bagel", 1.25));

        order5.addItem(new Item("americano", 2.25));
        order5.addItem(new Item("scone", 3.00));

        // Test getStatusMessage (set some orders to ready)
        order1.setReady(true);
        order2.setReady(false);
        order3.setReady(true);
        order4.setReady(false);
        order5.setReady(true);

        System.out.println(order1.getStatusMessage()); // Should print "Your order is ready."
        System.out.println(order2.getStatusMessage()); // Should print "Thank you for waiting. Your order will be ready soon."
        System.out.println(order3.getStatusMessage()); // Should print "Your order is ready."
        System.out.println(order4.getStatusMessage()); // Should print "Thank you for waiting. Your order will be ready soon."
        System.out.println(order5.getStatusMessage()); // Should print "Your order is ready."

        // Test getOrderTotal
        System.out.println("Order 1 total: $" + order1.getOrderTotal());
        System.out.println("Order 2 total: $" + order2.getOrderTotal());
        System.out.println("Order 3 total: $" + order3.getOrderTotal());
        System.out.println("Order 4 total: $" + order4.getOrderTotal());
        System.out.println("Order 5 total: $" + order5.getOrderTotal());

        // Test display method
        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();
    }
}