/**
 * Esta clase contiene un ejemplo de condicion de concurso
 * 
 * @author Abel García Pascual
 * @version 1.0
 * @see tareaRunnable
 */

public class cajero implements Runnable {
    private double cantidad;
    private int sumaOresta;
    private ccSem Cr;

    /**
     * Constructor por defecto
     * 
     * @param som Determina si se suma o resta
     * @param v   Deterermina el numero de iteraciones que hara el bucle
     */
    public cajero(double c, int som,ccSem cuentaC) {
        Cr = cuentaC;
        cantidad = c;
        sumaOresta = som;
    }

    /**
     * Metodo que ejecuta el hilo
     */
    public void run() {
        switch (sumaOresta) {
            case 0:
                Cr.deposito(cantidad);
                break;
            case 1:
                Cr.reintegro(cantidad);
                break;

        }
    }

    public double saldoFinal() {
        return Cr.valorFinal();
    }
}
