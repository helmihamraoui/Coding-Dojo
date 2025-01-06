public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffeePrice = 2.0;
        double lattePrice = 4.5;
        double cappuccinoPrice = 5.0;
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Jimmy";
        String customer3 = "Sam";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = false;   
        boolean isReadyOrder4 = false;
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        //cindhuir's interaction
        System.out.println(generalGreeting + customer1);
        if (!isReadyOrder1) {
            System.out.println(customer1 + pendingMessage);
        } else {
            System.out.println(customer1 + readyMessage);
        }
        //Noah's interaction
        System.out.println(generalGreeting + customer4);
        if (!isReadyOrder4) {
            System.out.println(customer4 + pendingMessage);
        } else {
            System.out.println(customer4 + readyMessage);
            System.out.println(displayTotalMessage + cappuccinoPrice);
        }
        //sam's interaction
        System.out.println(generalGreeting + customer3);
        double samTotal = lattePrice*2;
        System.out.println(displayTotalMessage + samTotal);
        if (!isReadyOrder3) {
            System.out.println(customer3 + pendingMessage);
        } else {
            System.out.println(customer3 + readyMessage);
        }
        //jimmy's interaction
        System.out.println(generalGreeting + customer2);
        double jimmyTotal = lattePrice - dripCoffeePrice;
        System.out.println(displayTotalMessage + jimmyTotal);
        if (!isReadyOrder2) {
            System.out.println(customer2 + pendingMessage);
        } else {
            System.out.println(customer2 + readyMessage);
        }
        mochaPrice = 4.5;
        isReadyOrder2 = false;
    }
}
