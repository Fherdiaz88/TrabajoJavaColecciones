package ejercicio5; // Define que el archivo pertenece al paquete ejercicio5

import java.util.Scanner; // Importa la herramienta para leer datos desde el teclado

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Inicializa el lector de consola

        // 1. Definir el tamaño de las matrices
        System.out.print("Ingrese la cantidad de artículos producidos (N): ");
        int n = scanner.nextInt(); // Lee el número de artículos (Filas)
        System.out.print("Ingrese la cantidad de sucursales (M): ");
        int m = scanner.nextInt(); // Lee el número de sucursales (Columnas)

        // 2. Declarar las matrices bidimensionales [filas][columnas]
        double[][] matrizPrecios = new double[n][m]; // Matriz para guardar precios con decimales
        int[][] matrizCantidades = new int[n][m]; // Matriz para guardar cantidades enteras

        // 3. Llenar la matriz de PRECIOS
        System.out.println("\n--- REGISTRO DE PRECIOS ---");
        for (int i = 0; i < n; i++) { // Bucle externo: Recorre cada artículo (fila)
            for (int j = 0; j < m; j++) { // Bucle interno: Recorre cada sucursal (columna)
                System.out.print("Precio del Artículo #" + (i + 1) + " en Sucursal #" + (j + 1) + ": $");
                matrizPrecios[i][j] = scanner.nextDouble(); // Guarda el precio en la coordenada exacta [i][j]
            }
        }

        // 4. Llenar la matriz de CANTIDADES VENDIDAS
        System.out.println("\n--- REGISTRO DE CANTIDADES VENDIDAS ---");
        for (int i = 0; i < n; i++) { // Bucle externo: Recorre cada artículo
            for (int j = 0; j < m; j++) { // Bucle interno: Recorre cada sucursal
                System.out.print("Cantidad vendida del Artículo #" + (i + 1) + " en Sucursal #" + (j + 1) + ": ");
                matrizCantidades[i][j] = scanner.nextInt(); // Guarda la cantidad en la coordenada exacta [i][j]
            }
        }

        // 5. Arreglos para guardar los totales calculados
        double[] totalPorArticulo = new double[n]; // Un vector del tamaño N para los artículos
        double[] totalPorSucursal = new double[m]; // Un vector del tamaño M para las sucursales

        // 6. Procesamiento de los datos (Cálculo de ventas)
        for (int i = 0; i < n; i++) { // Recorre las filas (artículos)
            for (int j = 0; j < m; j++) { // Recorre las columnas (sucursales)
                // Multiplica el precio por la cantidad vendida en esa posición específica
                double ventaGenerada = matrizPrecios[i][j] * matrizCantidades[i][j];
                
                // Acumula la venta generada en el total del artículo actual
                totalPorArticulo[i] += ventaGenerada; 
                // Acumula la venta generada en el total de la sucursal actual
                totalPorSucursal[j] += ventaGenerada; 
            }
        }

        // 7. Mostrar resultados finales de Artículos
        System.out.println("\n================ REPORTES DE VENTAS ================");
        System.out.println("TOTAL DE VENTAS POR ARTÍCULO:");
        for (int i = 0; i < n; i++) { // Bucle para imprimir el vector de totales por artículo
            System.out.println("Artículo #" + (i + 1) + ": $" + totalPorArticulo[i]);
        }

        // 8. Mostrar resultados finales de Sucursales
        System.out.println("\nTOTAL DE VENTAS POR SUCURSAL:");
        for (int j = 0; j < m; j++) { // Bucle para imprimir el vector de totales por sucursal
            System.out.println("Sucursal #" + (j + 1) + ": $" + totalPorSucursal[j]);
        }
        System.out.println("====================================================");

        scanner.close(); // Cierra la herramienta de lectura
    }
}