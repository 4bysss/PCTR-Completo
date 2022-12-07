
 /* lectorEscritor
 */
public class lectorEscritor {
    private int waiting;
    private static boolean escribiendo;
    private int lectores = 0;


     lectorEscritor(){
        waiting = 0;
        lectores = 0;
        escribiendo = false;

     }


    synchronized public void iniciaLectura(){
        ++waiting; 
        while(escribiendo){
            try {
                wait();
            } catch (Exception e) {}
        }
        ++lectores;
        notifyAll();
    
        --waiting;
    }

    synchronized public void acabarLectura(){
        --lectores;
        if(lectores==0){
            notifyAll();
        }

    }


    synchronized public void iniciarEscritura(){
        while(lectores!=0 || escribiendo){
            try {wait();}catch (Exception e) {}
        }
        escribiendo = true;
    }



    synchronized public void acabarEscritura(){
        escribiendo = false;
            notifyAll();
    } 

}
