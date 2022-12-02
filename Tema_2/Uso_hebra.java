public class Uso_hebra{
  public static void main(String[] args)throws Exception{
    hebra h1 = new hebra (0,100000);
    hebra h2 = new hebra (1,100000);
    h1.start();
    h2.start();
    h1.join();
    h2.join();
    System.out.println(h1.valorFinal);
  }
}
