import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        List list = new ArrayList();
        List vector = new Vector();
        List linkedList = new LinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        for (Object o : list){
            System.out.println(o);
        }

        }
    }

