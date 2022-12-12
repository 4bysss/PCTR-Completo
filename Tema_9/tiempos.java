import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/**
 * tiempos
 */
public class tiempos {
    tiempos(){};
    private ReentrantLock lock = new ReentrantLock();
    private Semaphore sem = new Semaphore(1);
    long ini = 0;
    long fin = 0;
    AtomicLong result = new AtomicLong(0);
    public synchronized long funcionSyncro(long iter){
        ini = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            result.incrementAndGet();
        }
        fin = System.nanoTime();
        return (fin-ini);
    }


    public  long funcionLock(long iter){
        ini = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            lock.lock();
            result.incrementAndGet();
            lock.unlock();
            
        }
        fin = System.nanoTime();
        return (fin-ini);
    }


    public  long funcionSem(long iter){
        ini = System.nanoTime();
        for (int i = 0; i < iter; i++) {
            try {sem.acquire();} catch (Exception e) {}
            result.incrementAndGet();
            sem.release();
            
        }
        fin = System.nanoTime();
        return (fin-ini);
    }


    public static void main(String[] args)throws Exception {
        long tiempo= 0;
        Integer tipo = Integer.parseInt(args[0]);
        tiempos T = new tiempos();
        for (long i = 0; i < 1000000; i= i+10000) {
            switch(tipo){
                case 1:
                    tiempo = T.funcionSyncro(i);
                    break;
                case 2:
                    tiempo = T.funcionLock(i);
                    break;
                case 3:
                    tiempo = T.funcionSem(i);
                    break;
            }
            System.out.println(i+"\t"+(double)(tiempo));
        }
    }
}
