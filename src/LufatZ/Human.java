package LufatZ;

import java.util.ArrayList;
import java.util.List;

public class Human {
    public String picture;
    public  String name;
    public int age;
    private static int count = 0;
    public static List<Human> neighboarsList = new ArrayList<>();

    public Human(String picture, String name, int age) {
        this.picture = picture;
        this.name = name;
        this.age =age;

        count++;
        neighboarsList.add(this);
    }

    public static int getCount(){
        return count;
    }
    public static String getName(Human person){
        return person.name;
    }
    public static String getImg(Human person){
        return person.picture;
    }
    public static int getAge(Human person){
        return person.age;
    }

    public void birthday(){
        age++;
    }

}