import java.util.ArrayList;
import java.util.List;

public class Human extends LivingEntity {
    protected static List<Human> neighboarsList = new ArrayList<>();
    int count = 0;
    static Cat pet;

    public Human(String picture, String name, int age) {
        super(picture, name, age);
        neighboarsList.add(this);
    }

    public static int getCount(){
        return neighboarsList.size();
    }
    public static Human getHuman(String name){
        for (Human person : neighboarsList) {
            if (Human.getName(person).equalsIgnoreCase(name)) {
                System.out.println("Info: We found " + person.name + "!");
                return person;
            }
        }
        System.out.println("Error: " + name + " not found!");
        return null;
    }

    public static void neighborhood(){
        System.out.println("Info: There are "+ Human.getCount() +" People in your neighborhood:");
        for (int count = 0; count < Human.getCount(); count++) {
            System.out.println(Human.neighboarsList.get(count).name);
        }
    }

}
