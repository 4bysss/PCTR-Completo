public class tryFour extends Thread{
    private static volatile boolean wantp=false;
    private static volatile boolean wantq=false;
    private int tipo;
    public tryFour(int t){this.tipo = t;};
    public static void main(String[] args) {
        tryFour h1 = new tryFour(1);
        tryFour h2 = new tryFour(2);
        h1.start();
        h2.start();
    }
    public void run(){
        switch(tipo){
            case 1:
                while(true){
                    wantp = true;
                    while (wantq){
                        wantp = false;

                        wantp = true;
                    }
                    System.out.println(getName());
                    wantp = false;
                }
            case 2:
                while(true){
                    wantq = true;
                    while (wantp){
                        wantq = false;
                        wantq = true;
                    }
                    System.out.println(getName());
                    wantq = false;
                }
        }
    }

}
