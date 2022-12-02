public class algPeterson implements Runnable{
    private int tipo;
    private static volatile int ultimo=1;
    private static volatile boolean wantp = false;
    private static volatile boolean wantq = false;


    public algPeterson(int t){tipo=t;}
    public static void main(String[] args) {
        algPeterson r1 = new algPeterson(1);
        algPeterson r2 = new algPeterson(2);
        Thread h1 = new Thread(r1);
        Thread h2 = new Thread(r2);
        h1.start();
        h2.start();
    }
    public void run(){
        switch(tipo){
            case 1:
                while(true){
                    wantp = true;
                    ultimo = 1;
                    while(wantq!=false && ultimo!=2 ){}
                    System.out.println(tipo);
                    wantp = false;
                }
            case 2:
                while(true){
                    wantq = true;
                    ultimo = 2;
                    while(wantp!=false && ultimo!=1){}
                    System.out.println(tipo);
                    wantq = false;
                }

        }
    }
}
