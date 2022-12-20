import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

/**
 * sBonoLoto
 */
public class sBonoLoto extends UnicastRemoteObject implements iBonoLoto  {
    private int [] NumerosBuenos = new int [6];
    sBonoLoto()throws RemoteException{resetServidor();}
    public void resetServidor(){
        for (int i = 0; i < 6; i++) {
            NumerosBuenos[i] =i; //((int)(Math.random()*50)%49)+1;
        }
    }
    public boolean compApuesta(int[]apuesta){
        boolean comp = true;
        for (int i = 0; i <6 && comp; i++) {
            System.out.print(NumerosBuenos[i]);
        }
        System.out.println(" ");
        for (int i = 0; i <6 && comp; i++) {
            System.out.print(apuesta[i]);
        }
        for (int i = 0; i <6 && comp; i++) {
            comp = (NumerosBuenos[i] == apuesta[i] );
        }
        return comp;
    
    }
    public static void main(String[] args)throws Exception {
        sBonoLoto ORemoto = new sBonoLoto();
        Naming.rebind("BonoServer", ORemoto);
        System.out.println("Servidor escuchando...");
    }

    
}
