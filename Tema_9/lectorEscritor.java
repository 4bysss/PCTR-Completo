import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
 /* lectorEscritor
 */
public class lectorEscritor {

    private ReentrantLock lock = new ReentrantLock();
    private Condition lector = lock.newCondition();
    private Condition escritor = lock.newCondition();
    private static boolean escribiendo;
    private int lectores = 0;
    

     lectorEscritor(){
        lectores = 0;
        escribiendo = false;

     }


    public void iniciaLectura(){
        lock.lock();
        while(escribiendo){
            try {
                lector.await();
            } catch (Exception e) {}
        }
        ++lectores;
        lector.signal();
        lock.unlock();
    }

    public void acabarLectura(){
        lock.lock();
        --lectores;
        if(lectores==0){
            escritor.signal();
        }
        lock.unlock();

    }


    public void iniciarEscritura(){
        lock.lock();
        while(lectores!=0 || escribiendo){
            try {escritor.await();}catch (Exception e) {}
        }
        escribiendo = true;
        lock.unlock();
    }



    public void acabarEscritura(){
        lock.lock();

        escribiendo = false;
        lector.signal();
        escritor.signal();
        lock.unlock();

    } 

}
