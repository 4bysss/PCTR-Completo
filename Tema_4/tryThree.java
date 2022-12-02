

class tryThree extends Thread{
    private int tipo;
    private static volatile boolean wantp = false;
    private static volatile boolean wantq = false;
    public tryThree(int t){this.tipo = t;}
    public static void main(String[] args) {
        tryThree h1 = new tryThree(1);
        tryThree h2 = new tryThree(2);
        h1.start();
        h2.start();
        
    }
    public void run(){
        switch(tipo){
            case 1:
                while(true){
                    wantp = true;
                    while(wantq!=false){};
                    System.out.println(getName());
                    wantp = false;
                }
            case 2:
                while(true){
                    wantq = true;
                    while(wantp!=false){};
                    System.out.println(getName());
                    wantq = false;
                }
        }

    }
}
