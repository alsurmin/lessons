public class Main {

    private static int i = 5;

    static  class StaticClass{
        static void method(){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {

        StaticClass.method();

        Main main = new Main();
        main.method();
        Inner inner = main.new Inner();
        inner.method2();
    }

    void method(){
        class  NewInner{
            void newMethod(){
                System.out.println("bla");
            }
        }
        NewInner newInner = new NewInner();
        newInner.newMethod();
    }

    class Inner{
        int k = 6;
        void method2(){
            System.out.println(i);
        }
    }

}
