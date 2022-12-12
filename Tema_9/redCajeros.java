
public class redCajeros {
    public static void main(String[] args) throws Exception {
        ccSem cuenta1 = new ccSem(123, 0);
        ccSem cuenta2 = new ccSem(456, 100);


        Thread hilos1[] = new Thread[10000];
        Thread hilos2[] = new Thread[10000];
        double cantidad = 0;
        double cantiT = 0;
        for (int i = 0; i < 9999; i=i+2) {
            cantidad = Math.random();
            hilos1[i] = new Thread(new cajero(cantidad, 0,cuenta1));
            hilos1[i + 1] = new Thread(new cajero(cantidad, 1,cuenta1));
            hilos2[i] = new Thread(new cajero(cantidad, 0,cuenta2));
            hilos2[i + 1] = new Thread(new cajero(cantidad, 1,cuenta2));
            cantiT += cantidad;
        }
        for (int i = 0; i < 10000; i++) {
            hilos1[i].start();
            hilos1[i].join();
            hilos2[i].start();
            hilos2[i].join();
        }
        System.out.println("Utilizando semaforos: ");
        System.out.println("La cantidad de dinero en el cajero es: " + cuenta1.valorFinal() + " Y la cantidad sumada/restada es: " + cantiT);
        System.out.println("La cantidad de dinero en el cajero es: " + cuenta2.valorFinal() + " Y la cantidad sumada/restada es: " + cantiT);
    }
}
