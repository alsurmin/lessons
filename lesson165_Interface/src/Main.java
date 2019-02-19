public class Main {

    public static void main(String[] args) {

    }
}

interface Animal {

    enum E {

    }

    public static interface MyInnerInterface {
        int i = 6;
        void eat();
    }

    public static class MyInnerClass {

    }
    int i = 5;
    void eat();
}

interface Cat extends Animal {
    void move();
}

class Tiger implements Animal, Cat {

    @Override
    public void eat() {
    }
    @Override
    public void move() {
    }
}
