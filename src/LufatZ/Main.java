package LufatZ;


import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Human alex = new Human("alex.png","Alex", 18);
        Human paul = new Human("pul.png","Paul", 22);
        Human gustav = new Human("gustav.png","Gustav", 44);

        String command ="";

        while (!command.contains("exit")){
            commands();

            command = scanner.nextLine();
            switch (command){
                case "neighborhood" : neighborhood(); break;
                case "commands": continue;
                case "neighbor":
                    System.out.println("Please enter a human name");
                    neighborOperation(scanner.nextLine()); break;
                case "exit": return;
                default: System.out.println("Operation " + command + " not found"); break;
            }
        }
        System.out.println("See you next time!");
        scanner.close();
    }
    public static void commands(){
        System.out.println("Type \"neighborhood\" to get informed who lives in your neighborhood");
        System.out.println("Type \"commands\" to get all commands");
        System.out.println("Type \"neighbor\" for information about a human.");
        System.out.println("Type \"exit\" to exit");
    }
    public static void neighborhood(){
        System.out.println("There are "+ Human.getCount() +" People in your neighborhood:");
        for (int count = 0; count< Human.getCount(); count++) {
            System.out.println(Human.neighboarsList.get(count).name);
        }
    }
    public static void neighborOperation(String name) {
        Human neighbor = Human.getHuman(name);
        if (neighbor != null) {
            name = Human.getName(neighbor);
            System.out.println("what do you want to know about " + name);
            System.out.println("Available options: age | picture | birthday");
            String info = scanner.nextLine();
            if (info.contains("ag")){
                System.out.println(name + " is " + Human.getAge(neighbor) + " years old!");
            } else if (info.contains("pi")) {
                System.out.println("This is the path to the picture"+Human.getImg(neighbor));
            } else if (info.contains("bi")) {
                Human.birthday(neighbor);
                System.out.println("You should congratulate " + name +" to birthday! "+name+" is now " + Human.getAge(neighbor) + " years old!");
            } else {System.out.println(info + "not found!");}
        }
    }
}