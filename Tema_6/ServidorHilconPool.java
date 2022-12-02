/*NaN
 *@Abel Garcia Pascual
 *@version 1.0
*/

import java.net.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class ServidorHilconPool
    implements Runnable
{
    private Socket enchufe;
    ServidorHilconPool(Socket s)
    {enchufe = s;}

    public void run()
    {
    try{
        BufferedReader entrada = new BufferedReader(
                                    new InputStreamReader(
                                        enchufe.getInputStream()));
        String datos = entrada.readLine();
        int j;
        int i = Integer.valueOf(datos).intValue();
        for(j=1; j<=20; j++){
        System.out.println(" escribiendo el dato "+i);
        java.lang.Thread.sleep(1000);
        //TimeUnit.MILLISECONDS.wait(1000);
        }
        enchufe.close();
        System.out.println("cierra su conexion...");
    } catch(Exception e) {System.out.println("Error...");}
    }//run

public static void main (String[] args)
{
    int puerto = 2001;
        try{
            int i = 0;
            int cores  =  Runtime.getRuntime().availableProcessors();
            ServerSocket chuff = new ServerSocket (puerto, 3000);
            while(i<100000){
                ThreadPoolExecutor hilos  = new ThreadPoolExecutor (cores ,cores ,0L ,TimeUnit.MILLISECONDS , new LinkedBlockingQueue < Runnable >() );
                System.out.println("Esperando solicitud de conexion...");
                Socket cable = chuff.accept();
                System.out.println("Recibida solicitud de conexion...");
                hilos.execute(new ServidorHilconPool(cable));
                ++i;
            }
            chuff.close();
      } catch (Exception e)
        {System.out.println("Error en sockets...");}
}//main





}//Servidor_Hilos

