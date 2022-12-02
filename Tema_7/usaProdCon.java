/**
 * usaProdCon
 */
public class usaProdCon extends Thread{
    private prodCon Sema;
    usaProdCon(int tipo,int tam,Object  aalgo){Sema = new prodCon(tipo, tam,aalgo);}
    public void run(){
        Sema.metodo();
    }
    public static void main(String[] args)
    {  
       Object algo = new Object();
       usaProdCon h1 = new usaProdCon(0,  Integer.parseInt(args[0]),algo);
       usaProdCon h2 = new usaProdCon(1,  Integer.parseInt(args[0]),algo);
       h1.start();
       h2.start();
    }
}