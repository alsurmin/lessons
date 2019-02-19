public class Main {

    public static void main(String[] args) {
        MyNewCar myNewCar = new MyNewCar();
        myNewCar.drive();
    }
}

interface Car {
    default void drive() {
        System.out.println("Car drive");
    }
}

class Ford implements Car {
    public void drive() {
        System.out.println("Ford drive");
    }
}

interface Motorcycle {
    void drive();
}

class Yamaha implements Motorcycle {
    public void drive() {
        System.out.println("Yamaha drive");
    }
}

class MyNewCar implements Car, Motorcycle {
    public void drive() {
        System.out.println("MyNewCar drive");
    }

}