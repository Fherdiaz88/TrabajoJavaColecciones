package ejercicio3; // Define que el archivo pertenece al paquete ejercicio3

import java.util.Scanner; // Importa la herramienta para leer datos ingresados por teclado

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Inicializa el lector de consola

        // 1. Definir la cantidad de empleados
        System.out.print("Ingrese la cantidad de empleados (N): ");
        int n = scanner.nextInt(); // Lee el número entero N ingresado por el usuario
        scanner.nextLine(); // Limpia el salto de línea residual en la memoria

        // 2. Declarar los arreglos paralelos
        String[] codigos = new String[n]; // Arreglo para almacenar los códigos (como texto)
        String[] nombres = new String[n]; // Arreglo para almacenar los nombres de los empleados

        // 3. Llenar los arreglos con los datos
        System.out.println("\n--- REGISTRO DE EMPLEADOS ---");
        for (int i = 0; i < n; i++) { // Bucle que se repite N veces
            System.out.print("Ingrese el CÓDIGO del empleado #" + (i + 1) + ": ");
            codigos[i] = scanner.nextLine(); // Guarda el código en la posición actual i
            
            System.out.print("Ingrese el NOMBRE del empleado #" + (i + 1) + ": ");
            nombres[i] = scanner.nextLine(); // Guarda el nombre en la misma posición i
        }

        // 4. Búsqueda del empleado
        System.out.println("\n--- BÚSQUEDA DE EMPLEADO ---");
        System.out.print("Ingrese el código del empleado que desea buscar: ");
        String codigoBuscado = scanner.nextLine(); // Lee el código que el usuario quiere encontrar

        boolean encontrado = false; // Bandera lógica para saber si tuvimos éxito en la búsqueda

        // 5. Recorrer el arreglo para encontrar la coincidencia
        for (int i = 0; i < n; i++) { // Recorre todas las posiciones de los arreglos
            if (codigos[i].equals(codigoBuscado)) { // Compara si el código actual coincide con el buscado
                // Si coincide, imprime el nombre que está exactamente en la misma posición (i)
                System.out.println("Resultado: El código " + codigoBuscado + " pertenece a " + nombres[i]);
                encontrado = true; // Cambia la bandera a verdadero
                break; // Rompe el bucle porque ya no tiene sentido seguir buscando
            }
        }

        // 6. Validar si el código no existía
        if (!encontrado) { // Si la bandera sigue siendo falsa...
            System.out.println("Error: No se encontró ningún empleado con ese código.");
        }

        scanner.close(); // Cierra la herramienta de lectura para liberar memoria
    }
}