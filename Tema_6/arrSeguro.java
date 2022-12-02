public class arrSeguro extends Thread {
    public int tipo;
    public int indice;
    static private int buffer[];
    arrSeguro(int t,int i, int[]v){
        tipo = t;
        buffer = v;
        indice = i;
    }
    public synchronized void cambiamodo(int m){tipo = m;}
    public void run(){
        synchronized(buffer){
            for (int i = 0; i < buffer.length; i++) {
                buffer[i] += i;
                System.out.print(buffer[i]+ " ");
            }
            System.out.println("");
        }

        }

    }

    
