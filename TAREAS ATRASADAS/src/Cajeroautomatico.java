import java.util.ArrayList;
import java.util.Scanner;

public class Cajeroautomatico {

    public static void mostrarMenu() {
        System.out.println("\n1. Consultar saldo");
        System.out.println("2. Depositar dinero");
        System.out.println("3. Retirar dinero");
        System.out.println("4. Salir");
        System.out.print("Opción: ");
    }

    public static void consultarSaldo(double saldo) {
        System.out.printf("Su saldo actual es: Q%.2f\n", saldo);
    }

    public static void depositarDinero(double[] saldo, ArrayList<String> historial, Scanner entrada) {
        System.out.print("Ingrese el monto a depositar: Q");
        double monto = entrada.nextDouble();
        if (monto > 0) {
            saldo[0] += monto;
            System.out.println("Depósito exitoso ");
            historial.add("Depósito de Q" + String.format("%.2f", monto));
        } else {
            System.out.println("Monto inválido ");
        }
    }

    public static void retirarDinero(double[] saldo, ArrayList<String> historial, Scanner entrada) {
        System.out.print("Ingrese el monto a retirar: Q");
        double monto = entrada.nextDouble();
        if (monto <= 0) {
            System.out.println("Monto inválido ");
        } else if (monto > saldo[0]) {
            System.out.println("Fondos insuficientes ");
        } else {
            saldo[0] -= monto;
            System.out.println("Retiro exitoso ");
            historial.add("Retiro de Q" + String.format("%.2f", monto));
        }
    }

    public static void iniciarSesion() {
        Scanner entrada = new Scanner(System.in);
        double[] saldo = {1500.00};
        ArrayList<String> historial = new ArrayList<>();

        System.out.println("Bienvenido al Cajero Automático");

        int opcion;
        do {
            mostrarMenu();
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    consultarSaldo(saldo[0]);
                    historial.add("Consulta de saldo");
                    break;
                case 2:
                    depositarDinero(saldo, historial, entrada);
                    break;
                case 3:
                    retirarDinero(saldo, historial, entrada);
                    break;
                case 4:
                    System.out.println("\nSaliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida ");
            }
        } while (opcion != 4);

        System.out.println("\nHistorial de transacciones:");
        System.out.println("----------------------------");
        for (String transaccion : historial) {
            System.out.println(transaccion);
        }

        entrada.close();
    }

    public static void main(String[] args) {
        iniciarSesion();
    }
}
