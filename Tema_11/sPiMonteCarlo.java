/**
 * sPiMonteCarlo
 */
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
public class sPiMonteCarlo extends UnicastRemoteObject implements iPiMonteCarlo {
    int intentos = 0;
    int vueltas = 0;
    sPiMonteCarlo()throws RemoteException{}
    public double aproxActual(){
        double cx;
        double cy;
        for(long i=0; i<vueltas; i++){
            cx = Math.random();
            cy = Math.random();
            if(Math.sqrt(Math.pow(cx, 2)+Math.pow(cy, 2))<=1){intentos++;}
        }
        return 4.0*intentos/vueltas;
    }

    public void reset(){
        intentos = vueltas = 0;
    }

    public void masPuntos(int nPuntos){
        vueltas+=nPuntos;
    }
    public static void main(String[] args)throws Exception{
      sPiMonteCarlo calculadora = new sPiMonteCarlo();
      Naming.rebind("//localhost/piMonteCarlo",calculadora);
      System.out.println("Servidor listo");
    }
}
