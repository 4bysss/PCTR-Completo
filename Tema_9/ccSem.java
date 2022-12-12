import java.util.concurrent.Semaphore;

/**
 * ccSem
 */
public class ccSem {
    Semaphore sem = new Semaphore(1); 
    boolean modifing = false;
    boolean reading = false;
    private int numCuenta;
    private double saldo;
    ccSem(int nc,double s){
        numCuenta = nc;
        saldo = s;
    }
    
    public void deposito(double n){
        try {
            sem.acquire();
        } catch (Exception e) {}
        modifing = true;
        saldo+=n;
        modifing = false;
        sem.release();
    }

    public void reintegro(double n){
        try {
            sem.acquire();
        } catch (Exception e) {}
        modifing = true;
        saldo-=n;
        modifing = false;
        sem.release();

    }

    public double valorFinal(){return saldo;}
}
