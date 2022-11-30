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
        double cappucinoPrice = 2.5;

        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        // Order completions (add yours below)
        boolean isReadyOrder1 = true;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = false;


        // App interaction simulation (Add your code for the challenges below)
        
        System.out.println(generalGreeting + customer1); // shows greeting for customer SET
        
        // cindhuri customer interaction
        System.out.println(customer1 + pendingMessage);

        // noah customer interaction
        if (isReadyOrder4) {
            System.out.println(customer4 + readyMessage);
            System.out.println(displayTotalMessage + cappucinoPrice);
        }
        else {
            System.out.println(customer4 + pendingMessage);
        }

        // sam customer interaction
        System.out.println(displayTotalMessage + lattePrice * 2);
        if (isReadyOrder2) {
            System.out.println(customer2 + readyMessage);
        }
        else {
            System.out.println(customer2 + pendingMessage);
        }

        // jimmy customer interaction
        System.out.println(displayTotalMessage + (lattePrice - dripCoffeePrice));

    }

}