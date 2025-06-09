/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author armando
 */
abstract class Cuenta {
    protected String numeroCuenta;
    protected double saldo;

    public Cuenta(double saldoInicial) {
        this.numeroCuenta = Banco.generarNumeroCuenta();
        this.saldo = saldoInicial;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public abstract String getTipo();

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }

    public abstract boolean retirar(double monto);
}
