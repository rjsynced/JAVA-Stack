import java.util.ArrayList;

public class CafeUtil {
    public int getStreakGoal(int weeks) {
        int count = 0;
        int total = 0;
        while(count < weeks){
            count += 1;
            total += count;
        }
    return total;
    }

    public double getOrderTotal(double[] prices) {
        double total = 0;
        for (double items : prices) {
            total += items;
        }
    return total;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        int count = 0;
        for(String item : menuItems) {
            System.out.println(count + " " + item);
            count++;
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name: \n");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName + "." + " There are " + customers.size() + " " + "people ahead of you.");
        customers.add(userName);
        System.out.println(customers);
    }
}