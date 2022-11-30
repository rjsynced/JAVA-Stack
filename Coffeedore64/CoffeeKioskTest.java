public class CoffeeKioskTest {
    public static void main(String[] args) {
        CoffeeKiosk kiosk1 = new CoffeeKiosk();
        Item item1 = new Item("banana", 3.33);
        Item item2 = new Item("apple", 4.20);
        Item item3 = new Item("devil's juice", 6.90);

        kiosk1.addMenuItem(item1);
        kiosk1.addMenuItem(item2);
        kiosk1.addMenuItem(item3);

        System.out.println(kiosk1.displayMenu());

        kiosk1.newOrder();
    }
}