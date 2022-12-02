public class cuentaCorriente {
    private int numCuenta;
    private static double saldo;

    public cuentaCorriente() {
        numCuenta = 123;
        saldo = 0;
    }

    public void deposito(double n) {
        saldo += n;
    }

    public void reintegro(double n) {
        saldo -= n;
    }

    public static double valorFinal() {
        return saldo;
    }
}
