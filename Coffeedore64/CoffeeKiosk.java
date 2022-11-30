import java.util.ArrayList;
public class CoffeeKiosk {
    // attributes
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    // constructor
    public CoffeeKiosk() {
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    // getter

    public ArrayList<Item> addMenuItem() {
        return this.menu;
    }

    // setter

    public void addMenuItem(Item item) {
        this.menu.add(item);
    }

    // methods
    public String displayMenu() {
        int count;
        String output = "";
        for(Item item: menu) {
            output += item.getIndx() + ": " + item.getName() + " -- ";
            output += "$" + item.getPrice() + "\n";
        }
        return output;
    }

    public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
        // Create a new order with the given input string
        // Show the user the menu, so they can choose items to add.
        Order incomingOrder = new Order(name);
        System.out.println(displayMenu());
        
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            for(Item item: menu) {
                if(item.getIndx() == (Integer.parseInt(itemNumber))){
                    incomingOrder.addItem(item);
                }
            }
            // Get the item object from the menu, and add the item to the order
            // Ask them to enter a new item index or q again, and take their input
            System.out.println("Please enter the index of the coffee you would like to order, or press q to exit");
            itemNumber = System.console().readLine();
        }
        incomingOrder.display();
        this.orders.add(incomingOrder);
        // After you have collected their order, print the order details 
    	// as the example below. You may use the order's display method.
    }

}