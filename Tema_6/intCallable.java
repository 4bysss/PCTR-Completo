import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class intCallable implements Callable<Integer> {
    int vueltas;
    intCallable(int v){vueltas = v;}
    public Integer call(){
    Integer resultao = 0;
    float numero = 0;
        for (int i = 0; i < vueltas; i++) {
            if(Math.cos(Math.random())>Math.random()){
                ++resultao;
            }
        }
    return resultao;
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int numVueltas = Integer.parseInt(args[0]);
        int cores = Runtime.getRuntime().availableProcessors();
        int particion = numVueltas/cores;
        Integer aciertos = 0;

        ArrayList<Future<Integer>>futuro = new ArrayList<Future<Integer>>();
        ExecutorService ExeSer = Executors.newFixedThreadPool(cores);

        for (int i = 0; i < cores; i++) {
            futuro.add(ExeSer.submit(new intCallable(particion)));       
        }
        for (int i = 0; i < futuro.size(); i++) {
            aciertos += futuro.get(i).get();
        }
        ExeSer.shutdown();
        System.out.println((float)aciertos/numVueltas);
    }
}
