import java.util.ArrayList;
import java.util.List;

public class LivingEntity {
    protected final String picture;
    protected String name;
    protected int age;
    protected static int count = 0;
    protected static List<LivingEntity> livingEntityList = new ArrayList<>();

    public LivingEntity(String picture, String name, int age) {
        this.picture = picture;
        this.name = name;
        this.age =age;

        count++;
        livingEntityList.add(this);
    }

    public static int getCount(){
        return count;
    }
    public static String getName(LivingEntity entity){
        return entity.name;
    }
    public static String getImg(LivingEntity entity){
        return entity.picture;
    }
    public static int getAge(LivingEntity entity){
        return entity.age;
    }
    public static void birthday(LivingEntity entity){
        entity.age++;
    }

}
