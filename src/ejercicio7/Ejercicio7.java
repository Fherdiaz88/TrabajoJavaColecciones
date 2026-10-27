package ejercicio7; // Declara que el archivo pertenece al paquete ejercicio7

import java.util.Scanner; // Importa la clase para leer los datos del teclado

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Inicializa el lector de teclado

        // 1. Definir la cantidad de estudiantes
        System.out.print("Ingrese la cantidad de estudiantes (N): ");
        int n = scanner.nextInt(); // Lee el número N de estudiantes
        scanner.nextLine(); // Limpia el buffer (el salto de línea residual)

        int numMaterias = 8; // Constante de 8 materias definida por el problema

        // 2. Declarar las estructuras de datos (Arreglos y Matrices)
        String[] codigos = new String[n]; // Vector para guardar el código de cada estudiante
        double[][] notas = new double[n][numMaterias]; // Matriz [estudiantes][materias] para las calificaciones

        // Arreglos paralelos para ir guardando los resultados solicitados
        double[] promedioEstudiante = new double[n]; 
        double[] sumaMateria = new double[numMaterias]; 
        int[] aprobadosMateria = new int[numMaterias]; 
        int[] reprobadosMateria = new int[numMaterias]; 

        // 3. Ingreso de datos al sistema
        System.out.println("\n--- REGISTRO DE CALIFICACIONES ---");
        for (int i = 0; i < n; i++) { // Bucle externo: Recorre cada estudiante
            System.out.print("\nIngrese el CÓDIGO del estudiante #" + (i + 1) + ": ");
            codigos[i] = scanner.nextLine(); // Guarda el código del estudiante actual
            
            for (int j = 0; j < numMaterias; j++) { // Bucle interno: Recorre las 8 materias del estudiante
                System.out.print("Nota de la materia " + (j + 1) + " (0 a 10): ");
                notas[i][j] = scanner.nextDouble(); // Guarda la nota en la matriz
            }
            scanner.nextLine(); // Limpia el buffer antes de leer el siguiente código de estudiante
        }

        // 4. Procesamiento de cálculos y estadísticas
        double mejorPromedio = -1; // Variable para encontrar la nota más alta
        String estudianteMejorPromedio = ""; // Variable para guardar quién tiene la nota más alta

        for (int i = 0; i < n; i++) { // Bucle para recorrer filas (estudiantes)
            double sumaEstudiante = 0; // Acumulador de notas para el estudiante actual

            for (int j = 0; j < numMaterias; j++) { // Bucle para recorrer columnas (materias)
                double notaActual = notas[i][j]; // Extrae la nota actual para hacer los cálculos
                
                sumaEstudiante += notaActual; // Suma la nota para el promedio del estudiante
                sumaMateria[j] += notaActual; // Suma la nota para el promedio general de esa materia

                // Condicional para contar aprobados y reprobados en la materia actual
                if (notaActual >= 7 && notaActual <= 10) {
                    aprobadosMateria[j]++; // Aumenta en 1 el contador de aprobados de esa columna
                } else if (notaActual < 7) {
                    reprobadosMateria[j]++; // Aumenta en 1 el contador de reprobados de esa columna
                }
            }

            // Calcula y guarda el promedio dividiendo la suma total para las 8 materias
            promedioEstudiante[i] = sumaEstudiante / numMaterias;

            // Condicional para verificar si el promedio actual es el más alto hasta ahora
            if (promedioEstudiante[i] > mejorPromedio) {
                mejorPromedio = promedioEstudiante[i]; // Actualiza el récord del mejor promedio
                estudianteMejorPromedio = codigos[i]; // Guarda el código del estudiante ganador
            }
        }

        // 5. Impresión de los Reportes (Resultados a, b, c, d, e)
        System.out.println("\n================ REPORTES DE SECRETARÍA ================");
        
        // a. Promedio por estudiante
        System.out.println("\na) PROMEDIO POR ESTUDIANTE:");
        for (int i = 0; i < n; i++) { // Bucle para imprimir el vector de promedios de estudiantes
            System.out.println("Estudiante [" + codigos[i] + "] - Promedio: " + promedioEstudiante[i]);
        }

        // b, d, e. Estadísticas por materia
        System.out.println("\n--- ESTADÍSTICAS POR MATERIA ---");
        for (int j = 0; j < numMaterias; j++) { // Bucle para imprimir vectores de materias
            double promedioMat = sumaMateria[j] / n; // Calcula el promedio final de la materia
            System.out.println("Materia " + (j + 1) + ":");
            System.out.println("  b) Promedio: " + promedioMat);
            System.out.println("  d) Aprobados: " + aprobadosMateria[j]);
            System.out.println("  e) Reprobados: " + reprobadosMateria[j]);
        }

        // c. Estudiante con mayor promedio
        System.out.println("\nc) MEJOR ESTUDIANTE:");
        System.out.println("El estudiante con mayor promedio es [" + estudianteMejorPromedio + "] con " + mejorPromedio);
        
        System.out.println("========================================================");

        scanner.close(); // Cierra el lector de teclado
    }
}