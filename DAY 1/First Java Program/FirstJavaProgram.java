public class FirstJavaProgram {
    public static void main(String[] args){
        String name = "Coding Dojo";
        int age = 100;
        String hometown = "Burbank, CA";
        System.out.println("My name is " + name + "\n" +
                            "I am " + age + " " +"years old" + "\n" + 
                            "My hometown is " + hometown);
        System.out.printf("My name is %s \n", name);
        System.out.printf("I am %d years old \n", age);
        System.out.printf("My hometown is %s \n", hometown);
    }
}