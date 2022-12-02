public class Usa_tareaRunnable {
    public static void main(String[] args) throws Exception {
        tareaRunnable hr1 = new tareaRunnable(0, 100000);
        tareaRunnable hr2 = new tareaRunnable(1, 100000);
        Thread h1 = new Thread(hr1);
        Thread h2 = new Thread(hr2);
        h1.start();
        h2.start();
        h1.join();
        h2.join();
        System.out.println(hr1.valorFinal);
    }
}
