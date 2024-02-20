package LufatZ;

import java.util.ArrayList;
import java.util.List;

public abstract class LivingEnity {
    protected final String picture;
    protected String name;
    protected int age;
    protected static int count = 0;
    protected static List<LivingEnity> livingEntityList = new ArrayList<>();

    public LivingEnity(String picture, String name, int age) {
        this.picture = picture;
        this.name = name;
        this.age =age;

        count++;
        livingEntityList.add(this);
    }

    public static int getCount(){
        return count;
    }
    public static String getName(LivingEnity entity){
        return entity.name;
    }
    public static String getImg(LivingEnity entity){
        return entity.picture;
    }
    public static int getAge(LivingEnity entity){
        return entity.age;
    }
    public static void birthday(LivingEnity entity){
        entity.age++;
    }

}
