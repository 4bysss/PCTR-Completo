
 /* lectorEscritor
 */
public class lectorEscritor {
    private int waiting;
    private static boolean escribiendo;
    private static Object lector;
    private static Object escritor;
    private int lectores = 0;

     lectorEscritor(){
        waiting = 0;
        lectores = 0;
        escribiendo = false;
        lector = new Object();
        escritor = new Object();

     }


    public void iniciaLectura(){
        ++waiting;
        synchronized(lector){
    
            while(escribiendo){
                try {
                    lector.wait();
                } catch (Exception e) {}
        }
        ++lectores;
        --waiting;
        lector.notifyAll();
        }
    }


    public void acabarLectura(){
        --lectores;
        if(lectores==0){
            synchronized(escritor){
                escritor.notifyAll();
            }
        }
    }


    public void iniciarEscritura(){
        synchronized(escritor){
            if(lectores!=0 || escribiendo){
                try {escritor.wait();}catch (Exception e) {}
                escribiendo = true;
            }
        }
    }



    public void acabarEscritura(){
        escribiendo = false;
        if(waiting == 0){
            synchronized(escritor){
                escritor.notifyAll();
            }
        }
        else{
            synchronized(lector){
                lector.notifyAll();
            }
        }
    } 

}
