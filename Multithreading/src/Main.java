public class Main {
    public static void Main(String[] args){
        otherMethod();
    }

    private static void otherMethod(){
        throw new RuntimeException();
    }
}
