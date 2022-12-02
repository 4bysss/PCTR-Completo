import java.util.*;

/**
 * Esta clase contiene el inicio y el fin del fragmento del vector que escalara
 * 
 * @author Abel García Pascual
 * @version 3.0
 * @see escalaVPar
 */
public class escalaVPar extends Thread {
    public static double[] vectorino = new double[10000];
    private double escala = 10;
    private int ini, fin;

    /**
     * Metodo constructor por defecto
     * 
     * @param i el inicio del fragmento del vector
     * @param f el fin del fragmento del vector
     */
    public escalaVPar(int i, int f) {
        ini = i;
        fin = f;

    }

    /**
     * Metodo que inicia las hebras
     */
    public void run() {
        System.out.println("Hilo: " + Thread.currentThread().getName() + " iniciado");
        for (int i = ini; i < fin; i++) {
            vectorino[i] = vectorino[i] * escala;
        }
    }
}
