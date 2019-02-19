import java.util.ArrayList;
import java.util.List;

class Parent{

}
class Child extends Parent{

}


public class Main  {

    public static void main(String[] args) throws Exception {
        List<Parent> list = new ArrayList<>();
        list.add(new Parent());
        Main main = new Main();
        main.method(list);
    }

    void method(List<? super Child> list){

        for (Object o : list){
            System.out.println(o);
        }
    }

}