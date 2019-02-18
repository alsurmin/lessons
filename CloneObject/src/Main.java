public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        MyObject myObject = new MyObject();
        myObject.i = 1;

        NewObject newObject = new NewObject();
        newObject.j =3;

        myObject.newObject = newObject;

        MyObject myObject1 = myObject.clone();
        myObject1.i = 2;

        System.out.println(myObject.i);

        myObject1.newObject.j = 4;
        System.out.println(myObject.newObject.j);

    }
}

class MyObject implements Cloneable{
    int i;
    NewObject newObject;

    @Override
    protected MyObject clone() throws CloneNotSupportedException {
        MyObject myObject = (MyObject) super.clone();
        myObject.newObject = newObject.clone();
        return myObject;
    }
}

class NewObject implements Cloneable{
    int j;

    @Override
    protected NewObject clone() throws CloneNotSupportedException {
        return (NewObject)super.clone();
    }
}
