import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        readFromFile("src/main/resources/LivingEntitys/Humans.json");
        Human alex = new Human("alex.png","Alex", 18);
        Human paul = new Human("paul.png","Paul", 22);
        Human gustav = new Human("gustav.png","Gustav", 44);

        readFromFile("src/main/resources/LivingEntitys/Pets.json");
        Cat snowball = new Cat("snowball.png", "Snowball", 2,  alex);
        Cat pfoetchen = new Cat("pfoetchen.png", "Pfötchen", 9, paul);

        String command ="";
        while (!command.contains("exit")){
            commands();

            command = scanner.nextLine();
            switch (command){
                case "neighborhood" : Human.neighborhood(); break;
                case "commands": continue;
                case "neighbor":
                    System.out.println("Question: Please enter a human name");
                    neighborOperation(scanner.nextLine()); break;
                case "exit": return;
                default: System.out.println("Error: Operation " + command + " not found"); break;
            }
        }
        System.out.println("Info: See you next time!");
        scanner.close();
    }
    public static void commands(){
        System.out.println("\nQuestion: Type one of the following commands to perform an action.");
        System.out.println("    - \"neighborhood\"   | to get informed who lives in your neighborhood");
        System.out.println("    - \"commands\"       | to get all commands");
        System.out.println("    - \"neighbor\"       | for information about a human.");
        System.out.println("    - \"exit\"           | to exit");
    }
    public static void readFromFile(String directory){
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader(directory);
            System.out.println("Info: Searching for entity's in " + directory);
            if (directory.toLowerCase().contains("human")){
                List<Human> jsonEntities = new Gson().fromJson(reader,new TypeToken<List<Human>>() {}.getType());
                reader.close();
                for (Human jsonEntity : jsonEntities) {
                    Human entity = new Human(jsonEntity.picture, jsonEntity.name, jsonEntity.age);
                    System.out.println("Info: " + jsonEntity.name + " is your new neighbor");
                }
            }
            else {
                List<Cat> jsonEntities = new Gson().fromJson(reader,new TypeToken<List<Cat>>() {}.getType());
                reader.close();
                for (Cat jsonEntity : jsonEntities) {
                    Cat entity = new Cat(jsonEntity.picture, jsonEntity.name, jsonEntity.age, Objects.requireNonNull(Human.getHuman(jsonEntity.owner)));
                    System.out.println("Info: " + jsonEntity.name + " is the new pet of " + jsonEntity.owner);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void neighborOperation(String name) {
        Human neighbor = Human.getHuman(name);
        if (neighbor != null) {
            name = Human.getName(neighbor);
            System.out.println("Question: what do you want to know about " + name + "?");
            System.out.println("Info: Available options are age | picture | birthday | pet");
            String info = scanner.nextLine();
            if (info.contains("ag")){
                System.out.println("Info: " + name + " is " + Human.getAge(neighbor) + " years old!");
            } else if (info.contains("pi")) {
                System.out.println("Info: This is the path to the picture"+Human.getImg(neighbor));
            } else if (info.contains("bi")) {
                Human.birthday(neighbor);
                System.out.println("Info: You should congratulate " + name +" to birthday! "+name+" is now " + Human.getAge(neighbor) + " years old!");
            } else if (info.contains("pe")) {
                Cat.getPet(name);
            } else {System.out.println("Error " + info + "not found!");}
        }
    }
}