/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author armando
 */
class CuentaDeCheques extends Cuenta {
    public CuentaDeCheques(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public String getTipo() {
        return "Cuenta de Cheques";
    }

    @Override
    public boolean retirar(double monto) {
        if (monto <= 0 || monto > saldo) {
            return false;
        }
        
        saldo -= monto;
        return true;
    }
}