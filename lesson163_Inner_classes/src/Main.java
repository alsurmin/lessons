public class Main {

    private static int j = 6;
    private int i = 5;

    void method() {
        Inner inner = new Inner();
    }

    class Inner {
        int q = j;
        int w = i;
        void method() {
            q = j + i;
        }

        final static int e = 5;

    }

    public static void main(String[] args) {
        Inner inner = new Main().new Inner();
    }
}

class OtherClass {
    Main.Inner inner = new Main().new Inner();
}