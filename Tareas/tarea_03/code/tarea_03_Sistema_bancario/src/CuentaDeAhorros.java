/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author armando
 */
class CuentaDeAhorros extends Cuenta {
    private double tasaInteres;
    private int retirosEsteMes = 0;
    private static final int MAX_RETIROS = 6;
    private static final double SALDO_MINIMO = 1000.0;

    public CuentaDeAhorros(double saldoInicial, double tasaInteres) {
        super(saldoInicial);
        this.tasaInteres = tasaInteres;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public int getRetirosEsteMes() {
        return retirosEsteMes;
    }

    @Override
    public String getTipo() {
        return "Cuenta de Ahorros";
    }

    @Override
    public boolean retirar(double monto) {
        if (monto <= 0) {
            return false;
        }
        
        if (retirosEsteMes >= MAX_RETIROS) {
            System.out.println("Límite de retiros mensuales alcanzado. Espera al proximo mes.");
            return false;
        }
        
        if (saldo - monto < SALDO_MINIMO) {
            System.out.println("No puede retirar esa cantidad. El saldo mínimo debe ser de $" + SALDO_MINIMO);
            return false;
        }
        
        saldo -= monto;
        retirosEsteMes++;
        return true;
    }
}