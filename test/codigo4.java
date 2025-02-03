public class HelloWorld {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("Hola, mundo");
            }
        };
        new Thread(runnable).start();
    }
}
