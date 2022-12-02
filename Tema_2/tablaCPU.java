public class tablaCPU {
    public static void main(String[] args) throws Exception {
        escalaVPar hilitos[] = new escalaVPar[10];
        for (int i = 0; i < escalaVPar.vectorino.length; i++) {
            escalaVPar.vectorino[i] = Math.random();
        }
        for (int i = 0; i < hilitos.length; i++) {
            hilitos[i] = new escalaVPar((escalaVPar.vectorino.length / hilitos.length) * i,
                    (escalaVPar.vectorino.length / hilitos.length) * (i + 1) - 1);
        }
        for (int i = 0; i < hilitos.length; i++) {
            hilitos[i].start();
        }
        for (int i = 0; i < escalaVPar.vectorino.length; i++) {
            System.out.print("[" + escalaVPar.vectorino[i] + "]");
        }
    }
}
