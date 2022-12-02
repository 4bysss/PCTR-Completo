public class prodEscalarParalelo extends Thread {
    private static double resuParcial[];
    private static double v1[];
    private static double v2[];
    private int id, inicioV, finalV;

    public prodEscalarParalelo(int idHebra, int Inicio, int Final) {
        int tam = Final - Inicio + 1;
        id = idHebra;
        inicioV = Inicio;
        finalV = Final;
        if (resuParcial == null) {
            resuParcial = new double[8];
            v1 = new double[1000000];
            v2 = new double[1000000];

            for (int i = 0; i < v1.length; i++) {
                v1[i] = Math.random();
                v2[i] = Math.random();

            }
        }
    }

    public void run() {
        for (int i = inicioV; i < finalV; i++) {
            resuParcial[id] += v1[i] * v2[i];
        }
    }

}
