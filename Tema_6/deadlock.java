import java.util.concurrent.TimeUnit;

public class deadlock extends Thread {
   public static Object A;
   public static Object B;
   public static Object C;
    int modo;

    deadlock(int m){
        A = new Object();
        B = new Object();
        C = new Object();
        modo = m;

    }
    public void run(){
        switch(modo){
            case 1:
                synchronized(A){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(B){
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized(C){
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                      
                                e.printStackTrace();
                            }
                            System.out.println("Jesse open the door");
                        }
                    }
                }
            break;
            case 2:
                synchronized(B){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    synchronized(A){
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        synchronized(C){
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            System.out.println("we need to cook some meth");
                        }
                    }
                }
            break;
            case 3:
                synchronized(C){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    synchronized(A){
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        synchronized(B){
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            System.out.println("JESSE!");
                        }
                    }
                }
            break;

                
        }
    }
    public static void main(String[] args) {
        deadlock HiloA = new deadlock(1);
        deadlock HiloB = new deadlock(2);
        deadlock HiloC = new deadlock(3);
        HiloA.start();
        HiloB.start();
        HiloC.start();
    }

    
}
