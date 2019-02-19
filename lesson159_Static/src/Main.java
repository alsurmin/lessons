import java.lang.reflect.InvocationTargetException;

enum Level {
    BEGGINER("green") {
        public String getColor(){
            return "color is " + color;
        }
        public void print(){
            System.out.println("print");
        }
    }

    , EXPERT("red");

    String color;

    Level(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println(Level.BEGGINER.getColor());
        Level.BEGGINER.getClass().getMethod("print").invoke(Level.BEGGINER);
    }
}

