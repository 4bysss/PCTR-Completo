import java.rmi.*;

/**
 * cBonoLoto
 */
public class cBonoLoto {
    public static void main(String[] args)throws Exception {
        int[] apuesta = new int[6];
        iBonoLoto RefBonoServer = (iBonoLoto) Naming.lookup("//localhost/BonoServer");
        for (int i = 0; i < 6; i++) {
            apuesta[i] = Integer.parseInt(args[i]);// ((int)(Math.random()*50)%49)+1;
        }
        boolean comp = RefBonoServer.compApuesta(apuesta);
            if(comp){
                System.out.println("Oleeee!!");
            }
            else{
                System.out.println("Acabas de perder un euro champion.");
            }
    }
}
