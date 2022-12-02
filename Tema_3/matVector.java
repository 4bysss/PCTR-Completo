public class matVector {
    private double matriz[][];
    private double vector[];
    private double resultado[];

    public matVector() {
        if (matriz == null) {
            matriz = new double[10000][10000];
            vector = new double[10000];
            resultado = new double[10000];
            for (int i = 0; i < 10000; i++) {
                vector[i] = Math.random();
                for (int j = 0; j < 10000; j++) {
                    matriz[i][j] = Math.random();

                }
            }
        }
    }

    public void matrizador() {
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                resultado[i] += matriz[i][j] * vector[j];

            }

        }
    }
}
