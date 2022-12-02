public class matVectorConcurrente implements Runnable {
    private static double matriz[][];
    private static double vector[];
    private static double result[];
    private int inicio, fin;

    matVectorConcurrente(int ini, int fini) {
        if (matriz == null) {
            vector = new double[10000];
            result = new double[10000];
            matriz = new double[10000][10000];
            for (int i = 0; i < 10000; i++) {
                vector[i] = Math.random();
                for (int j = 0; j < 10000; j++) {
                    matriz[i][j] = Math.random();
                }
            }
        }
        inicio = ini;
        fin = fini;
    }

    public void run() {
        for (int i = inicio; i < fin; i++) {
            for (int j = 0; j < 10000; j++) {
                result[i] += matriz[i][j] * vector[j];

            }

        }
    }
}
