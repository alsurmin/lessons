import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set set1 = new HashSet();
        Set set3 = new LinkedHashSet();
        Set set = new TreeSet();

        set.add("11");
        set.add("33");
        set.add("22");

       //System.out.println(map.get("3"));

       for(Object o : set){
           System.out.println(o.toString());
       }

    }
}
