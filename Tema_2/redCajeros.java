
public class redCajeros {
    public static void main(String[] args) throws Exception {
        cajero.Cr = new cuentaCorriente();
        System.out.println(cajero.saldoFinal());
        Thread hilos[] = new Thread[100];
        double cantidad = 0;
        double cantiT = 0;
        for (int i = 0; i < 99; i++) {
            cantidad = Math.random();
            hilos[i] = new Thread(new cajero(cantidad, 0));
            hilos[i + 1] = new Thread(new cajero(cantidad, 1));
            cantiT += cantidad;
        }
        for (int i = 0; i < 100; i++) {
            hilos[i].start();
            hilos[i].join();
        }
        System.out.println("La cantidad de dinero en el cajero es: " + cajero.saldoFinal()
                + "Y la cantidad sumada/restada es: " + cantiT);
    }
}
