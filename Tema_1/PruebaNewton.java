import java.util.Scanner;
class Prueba{
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    int itera = s.nextInt();
    double inic = s.nextDouble();
    NewtonRaphson NR=new NewtonRaphson(inic,itera);
    NR.Newton_Raphson();
  }
}
