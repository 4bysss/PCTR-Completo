public class usalectorEscritor extends Thread {
    private static lectorEscritor le;
    public static recurso r;
    private int tipo;
    usalectorEscritor(recurso R,lectorEscritor rw,int t){
        le = rw;
        r = R;
        tipo = t;

    }
    public void run(){
        switch(tipo){
            case 1:
                for (long i = 0; i < 100000000; i++) {
                    le.iniciaLectura();
                    r.observer();
                    le.acabarLectura();
                }
                break;

            case 2:
                for (long i = 0; i < 100000000; i++) {
                    le.iniciarEscritura();
                    r.inc();
                    le.acabarEscritura();
                }
                break;
        }
    }
    public static void main(String[] args) {
        recurso re = new recurso();
        lectorEscritor lec = new lectorEscritor();
        usalectorEscritor t1 = new usalectorEscritor(re, lec,1);
        usalectorEscritor t2 = new usalectorEscritor(re, lec,1);
        usalectorEscritor t3 = new usalectorEscritor(re, lec,1);
        usalectorEscritor t4 = new usalectorEscritor(re, lec,1);
        usalectorEscritor t5 = new usalectorEscritor(re, lec,2);
        usalectorEscritor t6 = new usalectorEscritor(re, lec,2);
        usalectorEscritor t7 = new usalectorEscritor(re, lec,2);
        usalectorEscritor t8 = new usalectorEscritor(re, lec,2);
        t1.run();
        t5.run();
        t2.run();
        t6.run();
        t3.run();
        t7.run();
        t4.run();
        t8.run();
        System.out.println(re.observer());

    }
}
