public class Item {
    private static int count;
    private int indx;
    private String name;
    private double price;

public Item(){
    this.name = "placeholder";
    this.price = 0;
    this.indx = count;
    count++;
}

public Item(String name, double price) {
    this.name = name;
    this.price = price;
    this.indx = count;
    count++;
}


public String getName(){
    return this.name;
}

public double getPrice(){
    return this.price;
}

public int getIndx(){
    return this.indx;
}

}