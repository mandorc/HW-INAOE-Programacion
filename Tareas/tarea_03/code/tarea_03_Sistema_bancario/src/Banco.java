
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author armando
 */
// Clase Banco
public class Banco {
    private List<Cliente> clientes = new ArrayList<>();
    private double tasaInteresAhorros = 1.0;
    private static int consecutivoCuentas = 1;
    private static int consecutivoClientes = 1;

    // Genera ID de cliente (formato: 1-MM-AA-XXXXX)
    public static String generarIdCliente() {
        Calendar calendario = Calendar.getInstance();
        int mes = calendario.get(Calendar.MONTH) + 1;
        int año = calendario.get(Calendar.YEAR) % 100;
        String id = String.format("%05d", consecutivoClientes);
        consecutivoClientes++;
        return String.format("1-%02d-%02d-%s", mes, año, id);
    }

    // Genera número de cuenta (formato: 2-MM-AA-XXXXX)
    public static String generarNumeroCuenta() {
        Calendar calendario = Calendar.getInstance();
        int mes = calendario.get(Calendar.MONTH) + 1;
        int año = calendario.get(Calendar.YEAR) % 100;
        String id = String.format("%05d", consecutivoCuentas);
        consecutivoCuentas++;
        return String.format("2-%02d-%02d-%s", mes, año, id);
    }

    // Resto de métodos de la clase Banco
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public double getTasaInteresAhorros() {
        return tasaInteresAhorros;
    }

    public void setTasaInteresAhorros(double tasaInteresAhorros) {
        this.tasaInteresAhorros = tasaInteresAhorros;
    }

    public void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        System.out.println("\nLista de clientes:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNombre() + 
                             " (ID: " + clientes.get(i).getId() + ")");
        }
    }

    public void mostrarInformacion() {
        System.out.println("\n############################################");
        System.out.println("Número de clientes: " + clientes.size());
        System.out.println("Tasa de interés para cuentas de ahorro: " + tasaInteresAhorros + "%");
    }
}