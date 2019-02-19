public class Main {

    private static int i = 1;
    int j = 2;

    static class Inner {
        static int q = i;
        int w = 3;

        void method() {
            System.out.println("method");
        }
        Inner(){
            System.out.println("constructor");
        }

        int getI() {
            return i;
        }
    }
    static class Inner2 extends Inner {

    }

    class Inner3 extends Inner {
        void method() {
            System.out.println("method3");
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Main.Inner inner = main.new Inner3();
        inner.method();
    }
}

class OtherClass {
    public static void main(String[] args) {
        Main main = new Main();
        Main.Inner inner = new Main.Inner2();
        inner.method();
    }
}


