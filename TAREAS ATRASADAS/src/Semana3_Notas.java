import java.util.Scanner;

public class Semana3_Notas {

    public static double calcularPromedio(double n1, double n2, double n3) {
        return (n1 + n2 + n3) / 3;
    }


    public static boolean aprueba(double promedio) {
        return promedio >= 61;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);


        int cantidad;
        do {
            System.out.print("¿Cuántos estudiantes deseas ingresar? : ");
            cantidad = entrada.nextInt();
            if (cantidad < 1 || cantidad > 5) {
                System.out.println("  Ingresa un número válido entre 1 y 5.");
            }
        } while (cantidad < 1 || cantidad > 5);


        String[] nombres = new String[cantidad];
        double[] promedios = new double[cantidad];
        String[] estados = new String[cantidad];



        for (int i = 0; i < cantidad; i++) {
            entrada.nextLine(); // limpiar buffer
            System.out.println("\n--- Estudiante #" + (i + 1) + " ---");

            System.out.print("Nombre: ");
            nombres[i] = entrada.nextLine();

            System.out.print("Nota 1: ");
            double n1 = entrada.nextDouble();
            System.out.print("Nota 2: ");
            double n2 = entrada.nextDouble();
            System.out.print("Nota 3: ");
            double n3 = entrada.nextDouble();

            // Calcular promedio y determinar estado
            double promedio = calcularPromedio(n1, n2, n3);
            promedios[i] = promedio;
            estados[i] = aprueba(promedio) ? "Aprobado" : "Reprobado";
        }

        mostrarResumen(nombres, promedios, estados, cantidad);

        entrada.close();
    }

    public static void mostrarResumen(String[] nombres, double[] promedios, String[] estados, int cantidad) {
        System.out.println("\nResumen de estudiantes:");
        System.out.println("------------------------");
        for (int i = 0; i < cantidad; i++) {
            System.out.printf("Nombre: %-10s Promedio: %.2f     Estado: %s\n",
                    nombres[i], promedios[i], estados[i]);
        }
    }
}
