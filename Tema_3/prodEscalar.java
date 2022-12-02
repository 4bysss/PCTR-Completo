public class prodEscalar {
    private double vect[];
    private double vect2[];

    public prodEscalar() {
        vect = new double[1000000];
        vect2 = new double[1000000];
        for (int i = 0; i < vect.length; i++) {
            vect[i] = Math.random();
            vect2[i] = Math.random();
        }
    }

    public double escalador() {
        double resu = 0;
        for (int i = 0; i < vect.length; i++) {
            resu += vect[i] * vect2[i];
        }
        return resu;
    }

}
