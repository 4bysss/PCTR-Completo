
import java.util.Scanner;
class PruebaMC{
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    int itera = s.nextInt();
    intDefinidaMonteCarlo MC=new intDefinidaMonteCarlo(itera);
    
    MC.MonteCarlo();
  }
}
