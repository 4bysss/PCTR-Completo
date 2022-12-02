/**
 * Esta clase contiene un ejemplo de condicion de concurso
 * @author Abel García Pascual
 * @version 1.0
 * @see tareaRunnable
 */

public class tareaRunnable implements Runnable{
  private int sumaOresta;
  public static int valorFinal=0;
  private int vueltas;
  /**
   * Constructor por defecto
   * @param som Determina si se suma o resta
   * @param v Deterermina el numero de iteraciones que hara el bucle
   */
  public tareaRunnable(int som,int v){sumaOresta=som;vueltas=v;}
  /**
   * Metodo que ejecuta el hilo
   */
  public void run(){
    switch (sumaOresta) {
      case 0: for (int i=0;i<vueltas;i++){valorFinal++;
      }
        
        break;
      case 1: for (int i=0;i<vueltas;i++){valorFinal--;
      }
        
        break;

    }
  }
}
