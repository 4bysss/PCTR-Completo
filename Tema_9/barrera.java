import java.util.concurrent.CyclicBarrier;

/**
 * barrera
 */
public class barrera implements Runnable {
    private static CyclicBarrier barrier = new CyclicBarrier(3);
    private long iter = 10000000;
    private long result = 0;
    barrera(){}
    public void run(){
        for (int i = 0; i < iter; i++) {
            ++result;  
        }
        System.out.println("Me quedo esperando");
        try { 
            barrier.await();
        } catch (Exception e) {}
        System.out.println("El resultado de mi suma es "+ result);
    }



    public static void main(String[] args)throws Exception {
         for (int i = 0;i<3; i++) {
           new Thread(new barrera()).start();
           Thread.sleep(5000);//Cinco segundos de espera entre la creacion de un hilo y otro para que se perciba la espera.
         } 
    }

    
}
