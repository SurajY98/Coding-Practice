public class FunctionalInterface {
    public static void main(String[] args) {
        Operation operation = (a,b) -> a+b;

        System.out.println(operation.add(4,7));
    }
}


@java.lang.FunctionalInterface
interface Operation{
    int add(int a, int b);
//    int sub(int a, int b);
    String toString();
}

