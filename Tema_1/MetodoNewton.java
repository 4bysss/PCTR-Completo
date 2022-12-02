import java.io.*;

import java.util.Random;
import java.util.Scanner;
import java.security.SecureRandom;//Igual a futuro se utiliza


class NewtonRaphson{
  private double Inicio;
  private int Iteraciones;

  private double Iniiones;
  public NewtonRaphson(double ini,int iter){
    Inicio = ini;
    Iteraciones = iter;

  }
  public void Newton_Raphson(){
    double NI1 =Inicio;
    Scanner sc = new Scanner(System.in);
    System.out.println("Opcion 1(Funcion 1)           Opcion 2(Funcion 2)");
    int opcion = sc.nextInt();
    if(opcion==1){
      System.out.println(-Math.sin(NI1)-3*Math.pow(NI1,2));
      for(int i=0;i<Iteraciones;i++){
       if((-Math.sin(NI1)-3*Math.pow(NI1,2))!=0){

         NI1=NI1-(Math.cos(NI1)-Math.pow(NI1,3))/(-Math.sin(NI1)-3*Math.pow(NI1,2));
         System.out.println("Iteracion: "+ i+" Resultado: "+ NI1);
       }
      }
    }
    if(opcion==2){
      System.out.println("Entra");
      for(int i=0;i<Iteraciones;i++){
       if(2*NI1!=0){

         NI1=NI1-((Math.pow(NI1,2)-5)/(2*NI1));
         System.out.println("Iteracion: "+ i+" Resultado: "+ NI1);
       }
      }

    }
  }




}
