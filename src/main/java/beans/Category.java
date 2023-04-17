package beans;

/**
 * Created by kobis on 15 Mar, 2023
 */
public enum Category {

    FOOD,
    HEALTH,
    SPORTS,
    COMPUTERS,
    VACATIONS;

    public  int getDBValue(){
        return this.ordinal()+1;
    }
    public static Category byDBId (int dbid){
        return Category.values()[dbid-1];
    }
}
