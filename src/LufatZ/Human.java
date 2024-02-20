package LufatZ;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static LufatZ.Cat.animalList;
import static LufatZ.Cat.petMap;

public class Human extends LivingEnity {
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
                System.out.println("We found " + person.name + "!");
                return person;
            }
        }
        System.out.println(name + " not found!");
        return null;
    }
    public static void neighborhood(){
        System.out.println("There are "+ Human.getCount() +" People in your neighborhood:");
        for (int count = 0; count < Human.getCount(); count++) {
            System.out.println(Human.neighboarsList.get(count).name);
        }
    }

}
