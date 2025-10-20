
import java.util.Scanner;

public class Semana2_Edad {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Declaramos una variable String para el nombre

        String nombre;

        int anioNacimiento;

        // Pedimos los datos al usuario
        System.out.print("Ingresa tu nombre: ");
        nombre = entrada.nextLine();

        System.out.print("Ingresa tu año de nacimiento: ");
        anioNacimiento = entrada.nextInt();

        // Calculamos la edad aproximada
        int edad = 2025 - anioNacimiento;

        // Mostramos el resultado
        System.out.println("Hola " + nombre + ", tu edad aproximada es: " + edad + " años.");

        // Cerramos el Scanner
        entrada.close();
    }
}
