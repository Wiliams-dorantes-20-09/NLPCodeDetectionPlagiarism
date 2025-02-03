public class HelloWorld {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Hola, mundo");
        new Thread(runnable).start();
    }
}
