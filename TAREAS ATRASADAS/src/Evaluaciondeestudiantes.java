import java.util.Scanner;
import java.util.Arrays;

public class Evaluaciondeestudiantes {

    public static double calcularPromedio(double[] notas) {
        double suma = 0;
        for (double n : notas) suma += n;
        return suma / notas.length;
    }

    public static char obtenerLiteral(double promedio) {
        if (promedio >= 90) return 'A';
        else if (promedio >= 80) return 'B';
        else if (promedio >= 70) return 'C';
        else if (promedio >= 60) return 'D';
        else return 'F';
    }

    public static boolean estaAprobado(char literal) {
        return (literal == 'A' || literal == 'B' || literal == 'C');
    }

    public static void mostrarResultado(String nombre, double[] notas) {
        double promedio = calcularPromedio(notas);
        char literal = obtenerLiteral(promedio);
        boolean aprobado = estaAprobado(literal);

        System.out.println("\nEstudiante: " + nombre);
        System.out.println("Notas: " + Arrays.toString(notas));
        System.out.printf("Promedio: %.2f\n", promedio);
        System.out.println("Literal: " + literal);
        System.out.println("Resultado: " + (aprobado ? "Aprobado ✅" : "Reprobado ❌"));
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("¿Cuántos estudiantes deseas ingresar? ");
        int cantidad = entrada.nextInt();
        entrada.nextLine();

        String[] nombres = new String[cantidad];
        double[][] notas = new double[cantidad][];

        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n--- Estudiante #" + (i + 1) + " ---");
            System.out.print("Nombre: ");
            nombres[i] = entrada.nextLine();

            System.out.print("¿Cuántas notas tiene " + nombres[i] + "? ");
            int numNotas = entrada.nextInt();
            notas[i] = new double[numNotas];

            for (int j = 0; j < numNotas; j++) {
                System.out.print("Nota " + (j + 1) + ": ");
                notas[i][j] = entrada.nextDouble();
            }
            entrada.nextLine();
        }

        System.out.println("\n===== RESULTADOS =====");
        for (int i = 0; i < cantidad; i++) {
            mostrarResultado(nombres[i], notas[i]);
        }

        entrada.close();
    }
}
