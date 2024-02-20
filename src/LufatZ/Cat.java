package LufatZ;

import java.util.*;

public class Cat extends LivingEnity {
    public static List<Cat> animalList = new ArrayList<>();
    public static Map<String,String> petMap = new TreeMap<>();
    protected String owner;
    public Cat(String picture, String name, int age, LivingEnity owner) {
        super(picture, name, age);
        this.owner = owner.name;
        petMap.put(this.name, owner.name);
        animalList.add(this);
    }


    public static void makeSound(Cat cat) {
        System.out.println(cat.name + ": Miau!");
    }
    public static void getPet(LivingEnity person){
        boolean foundCat = false;
        for (Cat cat : animalList) {
            if (Objects.equals(cat.owner, person.name)) {
                System.out.println(cat.name + " is the pet of " +person.name);
                Cat.makeSound(cat);
                foundCat=true;
                break;
            }
        }
        if (!foundCat){
            System.out.println(person.name + " does not hav a pet");
        }
    }
}
