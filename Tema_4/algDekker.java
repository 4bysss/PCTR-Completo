


public class algDekker extends Thread{
    private int tipo;
    private static volatile int turno = 1;
    private static volatile boolean wantp = false;
    private static volatile boolean wantq = false;
    public algDekker(int t){this.tipo = t;}
    public static void main(String[] args) {
        algDekker h1 = new algDekker(1);
        algDekker h2 = new algDekker(2);
        h1.start();
        h2.start();
    }
    public void run(){
        switch(tipo){
            case 1:
                while(true){
                    wantp = true;
                    while(wantq){
                        if(turno == 2){
                            wantp = false;
                            while(turno!=1){};
                            wantp = true;
                        }
                    }
                    System.out.println(getName());
                    turno = 2;
                    wantp = false;
                }
            case 2:
              while(true){
                    wantq = true;
                    while(wantp){
                        if(turno == 1){
                            wantq = false;
                            while(turno!=2){};
                            wantq = true;
                            }
                    }
                    System.out.println(getName());
                    turno = 1;
                    wantq = false;

                }
        }
    }
}