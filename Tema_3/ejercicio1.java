public class ejercicio1 {
    public static void main(String[] args) {
        // _________________-Ejecicio 1-_________________
        int NumT = 8;
        prodEscalar secue = new prodEscalar();
        prodEscalarParalelo paral[] = new prodEscalarParalelo[NumT];
        for (int i = 0; i < NumT; i++) {
            System.out.println(i);
            paral[i] = new prodEscalarParalelo(i, i * (1000000 / NumT), (i + 1) * (1000000 / NumT));
        }
        long inicTiempo = System.nanoTime();
        long finSecu, finPara, finMatSecu, finMatPara;
        for (int i = 0; i < NumT; i++) {
            paral[i].start();

        }
        finPara = (System.nanoTime() - inicTiempo) / (long) 1.0e6;
        inicTiempo = System.nanoTime();
        secue.escalador();
        finSecu = (System.nanoTime() - inicTiempo) / (long) 1.0e6;
        inicTiempo = System.nanoTime();
        secue.escalador();
        finSecu = (System.nanoTime() - inicTiempo) / (long) 1.0e6;
        System.out.println("=======");
        System.out.println("Ejercicio 1");
        System.out.println("=======");
        System.out.println("El tiempo que ha tardado Paralelenamente es: " + finPara);
        System.out.println("El tiempo que ha tardado Secuencialmente es: " + finSecu);
        // _________________-Ejecicio 2-_________________
        matVector matSec = new matVector();
        System.out.println("Contruyendo secuencial...");
        inicTiempo = System.nanoTime();
        matSec.matrizador();
        finMatSecu = (System.nanoTime() - inicTiempo) / (long) 1.0e6;
        matVectorConcurrente matCon[] = new matVectorConcurrente[10];
        System.out.println("Contruyendo hilos...");
        Thread hilos[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            matCon[i] = new matVectorConcurrente(((10000) / 10) * i, ((10000) / 10) * (i + 1));
            hilos[i] = new Thread(matCon[i]);
        }
        System.out.println("Iniciando hilos...");
        inicTiempo = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            hilos[i].start();
        }
        finMatPara = (System.nanoTime() - inicTiempo) / (long) 1.0e6;
        System.out.println("=======");
        System.out.println("Ejercicio 2");
        System.out.println("=======");
        System.out.println("El tiempo que ha tardado Paralelenamente es: " + finPara);
        System.out.println("El tiempo que ha tardado Secuencialmente es: " + finSecu);
    }
}
