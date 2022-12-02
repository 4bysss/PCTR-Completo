import java.util.Scanner;

class intDefinidaMonteCarlo{
  private double contadorSin=0;
  private double contadorX=0;
  private double iter;
  public intDefinidaMonteCarlo(int n){iter=n;}
  public void MonteCarlo(){
    for(int i = 0;i<iter;i++){
      double coordenda_x = Math.random();
      double coordenda_y = Math.random();
      if(coordenda_y<coordenda_x){
        contadorX++;
      }
      if(coordenda_y<Math.sin(coordenda_x)){
        contadorSin++;
      }
    }
    System.out.println("Integral de Seno: " + contadorSin / iter +" Integral X: " + contadorX / iter);

  }
}
