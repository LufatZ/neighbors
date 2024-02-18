package LufatZ;


import java.util.Scanner;

import static LufatZ.Human.neighboarsList;

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
                case "commands": commands(); break;
                case "neighbor":
                    System.out.println("Please enter a human name");
                    findNeighbor(scanner.nextLine()); break;
                default: commands(); break;
            }
        }
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
    public static void findNeighbor(String human) {
        for (Human person : neighboarsList) {
            if (Human.getName(person).equalsIgnoreCase(human)) {
                human = Human.getName(person);
                System.out.println("We found " + human + "!");
                System.out.println("what do you want to know about " + human);
                String info = scanner.nextLine();
                if (info.contains("ag")){
                    System.out.println(human + " is " + Human.getAge(person) + " years old!");
                } else if (info.contains("pi")) {
                    System.out.println("This is the path to the picture"+Human.getImg(person));
                }
                return;
            }
        }
        System.out.println("Person not found!");
    }
}