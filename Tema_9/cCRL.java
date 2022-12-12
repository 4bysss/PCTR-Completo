import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * cCRL
 */
public class cCRL {
    ReentrantLock lock = new ReentrantLock();
    Condition modSaldo = lock.newCondition();
    boolean modifing = false;
    boolean reading = false;
    private int numCuenta;
    private double saldo;
    cCRL(int nc,double s){
        numCuenta = nc;
        saldo = s;
    }
    
    public void deposito(double n){
        lock.lock();
        while(modifing){try {modSaldo.await();}catch(Exception e) {}}
        modifing = true;
        saldo+=n;
        modifing = false;
        modSaldo.signal();
        lock.unlock();

    }

    public void reintegro(double n){
        lock.lock();
        while(modifing){try {modSaldo.await();}catch(Exception e) {}}
        modifing = true;
        saldo-=n;
        modifing = false;
        modSaldo.signal();
        lock.unlock();

    }

    public double valorFinal(){return saldo;}
}
