
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author armando
 */
// Clase principal para ejecutar el programa
import java.util.Scanner;

public class Main {
    private static Banco banco = new Banco();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = obtenerEntero("Seleccione una opción: ");
            
            switch (opcion) {
                case 1:
                    gestionarBanco();
                    break;
                case 2:
                    gestionarClientes();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
        
        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\nSistema de Gestión Bancaria");
        System.out.println("===================================");
        System.out.println("[1] Banco");
        System.out.println("[2] Cliente");
        System.out.println("[0] Salir");
    }

    private static void gestionarBanco() {
        int opcion;
        do {
            System.out.println("\nAjustes del banco:");
            System.out.println("[1] Establecer tasa de interés para cuentas de ahorro");
            System.out.println("[2] Mostrar información del banco");
            System.out.println("[0] Volver al menú principal");
            
            opcion = obtenerEntero("Seleccione una opción: ");
            
            switch (opcion) {
                case 1:
                    double tasa = obtenerDouble("Ingrese la nueva tasa de interés (%): ");
                    banco.setTasaInteresAhorros(tasa);
                    System.out.println("Tasa de interés actualizada a: " + tasa + "%");
                    break;
                case 2:
                    banco.mostrarInformacion();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private static void gestionarClientes() {
        int opcion;
        do {
            System.out.println("\nGestioanr los clientes:");
            System.out.println("===================================");
            System.out.println("[1] Agregar cliente");
            System.out.println("[2] Mostrar clientes");
            System.out.println("[3] Gestionar cuentas de un cliente");
            System.out.println("[0] Volver al menú principal");
            
            opcion = obtenerEntero("Seleccione una opción: ");
            
            switch (opcion) {
                case 1:
                    agregarCliente();
                    break;
                case 2:
                    banco.mostrarClientes();
                    break;
                case 3:
                    gestionarCuentasCliente();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private static void agregarCliente() {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        
        Cliente cliente = new Cliente(nombre); // ID se genera automáticamente
        banco.agregarCliente(cliente);
        System.out.println("Cliente agregado exitosamente.");
        System.out.println("ID asignado: " + cliente.getId()); // Mostramos el ID generado
    }

    private static void gestionarCuentasCliente() {
        banco.mostrarClientes();
        if (banco.getClientes().isEmpty()) {
            return;
        }
        
        int indiceCliente = obtenerEntero("Seleccione el número de cliente: ") - 1;
        if (indiceCliente < 0 || indiceCliente >= banco.getClientes().size()) {
            System.out.println("Número de cliente no válido.");
            return;
        }
        
        Cliente cliente = banco.getClientes().get(indiceCliente);
        
        int opcion;
        do {
            System.out.println("\nModificar las cuentas de" + cliente.getNombre().toUpperCase());
            System.out.println("[1] Crear cuenta de ahorros");
            System.out.println("[2] Crear cuenta de cheques");
            System.out.println("[3] Mostrar cuentas");
            System.out.println("[4] Depositar");
            System.out.println("[5] Retirar");
            System.out.println("[0] Volver");
            
            opcion = obtenerEntero("Seleccione una opción: ");
            
            switch (opcion) {
                case 1:
                    crearCuentaAhorros(cliente);
                    break;
                case 2:
                    crearCuentaCheques(cliente);
                    break;
                case 3:
                    cliente.mostrarCuentas();
                    break;
                case 4:
                    realizarDeposito(cliente);
                    break;
                case 5:
                    realizarRetiro(cliente);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    private static void crearCuentaAhorros(Cliente cliente) {
        double saldoInicial = obtenerDouble("Ingrese el saldo inicial (mínimo $1000): ");
        if (saldoInicial < 1000) {
            System.out.println("El saldo inicial debe ser de al menos $1000.");
            return;
        }
        
        CuentaDeAhorros cuenta = new CuentaDeAhorros(saldoInicial, banco.getTasaInteresAhorros());
        cliente.agregarCuenta(cuenta);
        System.out.println("Cuenta de ahorros creada exitosamente. Número: " + cuenta.getNumeroCuenta());
    }

    private static void crearCuentaCheques(Cliente cliente) {
        double saldoInicial = obtenerDouble("Ingrese el saldo inicial: ");
        CuentaDeCheques cuenta = new CuentaDeCheques(saldoInicial);
        cliente.agregarCuenta(cuenta);
        System.out.println("Cuenta de cheques creada exitosamente. Número: " + cuenta.getNumeroCuenta());
    }

    private static void realizarDeposito(Cliente cliente) {
        cliente.mostrarCuentas();
        if (cliente.getCuentas().isEmpty()) {
            return;
        }
        
        int indiceCuenta = obtenerEntero("Seleccione el número de cuenta: ") - 1;
        if (indiceCuenta < 0 || indiceCuenta >= cliente.getCuentas().size()) {
            System.out.println("Número de cuenta no válido.");
            return;
        }
        
        double monto = obtenerDouble("Ingrese el monto a depositar: ");
        cliente.getCuentas().get(indiceCuenta).depositar(monto);
        System.out.println("Depósito realizado exitosamente.");
    }

    private static void realizarRetiro(Cliente cliente) {
        cliente.mostrarCuentas();
        if (cliente.getCuentas().isEmpty()) {
            return;
        }
        
        int indiceCuenta = obtenerEntero("Seleccione el número de cuenta: ") - 1;
        if (indiceCuenta < 0 || indiceCuenta >= cliente.getCuentas().size()) {
            System.out.println("Número de cuenta no válido.");
            return;
        }
        
        double monto = obtenerDouble("Ingrese el monto a retirar: ");
        boolean exito = cliente.getCuentas().get(indiceCuenta).retirar(monto);
        System.out.println(exito ? "Retiro realizado exitosamente." : "No se pudo realizar el retiro.");
    }

    private static int obtenerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número entero válido.");
            }
        }
    }

    private static double obtenerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }
}