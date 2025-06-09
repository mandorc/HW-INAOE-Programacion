
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author armando
 */
public class Cliente {
    private String nombre;
    private String id;  // Generado automáticamente
    private List<Cuenta> cuentas;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.id = Banco.generarIdCliente();  // ID generado aquí
        this.cuentas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public void mostrarCuentas() {
        if (cuentas.isEmpty()) {
            System.out.println("El cliente no tiene cuentas.");
            return;
        }
        System.out.println("\nCuentas de: " + nombre.toUpperCase());
        for (int i = 0; i < cuentas.size(); i++) {
            Cuenta cuenta = cuentas.get(i);
            System.out.println((i + 1) + ". " + cuenta.getTipo() + " #" + cuenta.getNumeroCuenta());
            System.out.println("   Saldo: $" + String.format("%,.2f", cuenta.getSaldo()));
        }
    }
}