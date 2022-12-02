import java.util.concurrent.*;
public class usaheterogenea extends Thread {
    static private heterogenea PruebaH;
    public int modo;
    usaheterogenea(int m){modo = m;}
    public void run(){
        switch(modo){
            case 1:
                PruebaH.inc();
                PruebaH.incProt();
                break;
            case 2:
                PruebaH.dec();
                PruebaH.decProt();
                break;
        }
    }
    public static void main(String[] args) {
        heterogenea heterP = new heterogenea(0, 0);
        usaheterogenea.PruebaH = heterP;
        ThreadPoolExecutor pl = new ThreadPoolExecutor (Integer.parseInt(args[0]) ,Integer.parseInt(args[0]) ,0L ,TimeUnit.MILLISECONDS , new LinkedBlockingQueue < Runnable >() );
        for (int i = 0; i < Integer.parseInt(args[1]); i++) {
            pl.execute(new usaheterogenea(i%2));
        }
        System.out.println("El valor de la variable no protegida es "+ PruebaH.m);
        System.out.println("El valor de la variable protegida es "+ PruebaH.n);
        pl.shutdown();

    }
}
