

import java.util.concurrent.*;
public class usaarrSeguro {
    public static void main(String[] args) throws InterruptedException {
        int [] vectorPrueba =new int [Integer.parseInt(args[1])];
        arrSeguro prueba = new arrSeguro(1, 0, vectorPrueba);
        ThreadPoolExecutor pl = new ThreadPoolExecutor (Integer.parseInt(args[0]) ,Integer.parseInt(args[0]) ,0L ,TimeUnit.MILLISECONDS , new LinkedBlockingQueue < Runnable >() );
        for (int i = 0; i < vectorPrueba.length; i++) {
            vectorPrueba[i] = 0;
        }
        for (int i = 0; i < vectorPrueba.length; i++) {
            pl.execute(prueba);
        }

        pl.shutdown();
    }
}
