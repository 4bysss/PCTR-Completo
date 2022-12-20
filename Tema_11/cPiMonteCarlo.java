/**
 * cPiMonteCarlo
 */
import java.rmi.*;
public class cPiMonteCarlo {
    public static void main(String[] args)throws Exception {
        iPiMonteCarlo server = (iPiMonteCarlo) Naming.lookup("//localhost/piMonteCarlo");
        server.masPuntos(Integer.parseInt(args[0]));
        System.out.println(server.aproxActual());

    }
    
}
