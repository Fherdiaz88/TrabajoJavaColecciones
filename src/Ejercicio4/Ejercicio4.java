//Implementar un programa que permita realizar operaciones sobre matrices de 
//M x N y lleno con elementos enteros generados de manera aleatoria. Se debe 
//permitir al usuario seleccionar alguna de las siguientes operaciones: Sumar, restar, 
//multiplicar y trasponer matrices.

import java.util.Scanner; // Importamos Scanner para leer datos del teclado
public class Ejercicio4 { // Declaramos la clase principal
    
 public static void main(String[] args) { // Iniciamos el programa
        Scanner teclado = new Scanner(System.in); // Creamos Scanner
        int filas; // Variable para almacenar el número de filas
        int columnas; // Variable para almacenar el número de columnas
        int opcion; // Variable para guardar la opción del menú

        // Solicitamos el número de filas
        System.out.print("Ingrese el número de filas: ");
        filas = teclado.nextInt(); // Leemos el número de filas

        // Solicitamos el número de columnas
        System.out.print("Ingrese el número de columnas: ");
        columnas = teclado.nextInt(); // Leemos el número de columnas

        // Comprobamos que las dimensiones sean mayores que cero
        if (filas > 0 && columnas > 0) {

            // Creamos la primera matriz
            int[][] matrizA = new int[filas][columnas];

            // Creamos la segunda matriz
            int[][] matrizB = new int[filas][columnas];

            // Creamos la matriz para guardar las operaciones
            int[][] resultado = new int[filas][columnas];

            // Creamos la matriz transpuesta con dimensiones invertidas
            int[][] transpuesta = new int[columnas][filas];

            // Recorremos las filas
            for (int i = 0; i < filas; i++) {

                // Recorremos las columnas
                for (int j = 0; j < columnas; j++) {

                    // Generamos un número aleatorio para la matriz A
                    matrizA[i][j] = (int)(Math.random() * 10) + 1;

                    // Generamos un número aleatorio para la matriz B
                    matrizB[i][j] = (int)(Math.random() * 10) + 1;
                } // Termina el recorrido de columnas
            } // Termina el recorrido de filas

            // Mostramos la primera matriz
            System.out.println("\nMATRIZ A");

            // Recorremos las filas de A
            for (int i = 0; i < filas; i++) {

                // Recorremos las columnas de A
                for (int j = 0; j < columnas; j++) {

                    // Imprimimos cada elemento en la misma línea
                    System.out.print(matrizA[i][j] + "\t");
                }

                // Cambiamos de línea al terminar cada fila
                System.out.println();
            }

            // Mostramos la segunda matriz
            System.out.println("\nMATRIZ B");

            // Recorremos las filas de B
            for (int i = 0; i < filas; i++) {

                // Recorremos las columnas de B
                for (int j = 0; j < columnas; j++) {

                    // Imprimimos cada elemento
                    System.out.print(matrizB[i][j] + "\t");
                }

                // Cambiamos de línea
                System.out.println();
            }

            // Repetimos el menú hasta seleccionar la opción 5 (salir)
            do {
                // Mostramos las opciones disponibles
                System.out.println("\n BIENVENIDO AL MENU DE OPERACIONES");
                System.out.println("1. Sumar matrices");
                System.out.println("2. Restar matrices");
                System.out.println("3. Multiplicar matrices");
                System.out.println("4. Transponer matriz A");
                System.out.println("5. Salir");

                // Solicitamos una opción
                System.out.print("Seleccione una opción: ");
                opcion = teclado.nextInt();

                // Evaluamos la opción seleccionada con switch
                switch (opcion) {
                    case 1: // Opción para sumar matrices
                        System.out.println("\nSUMA DE MATRICES");
                        // Recorremos las filas
                        for (int i = 0; i < filas; i++) {
                            // Recorremos las columnas
                            for (int j = 0; j < columnas; j++) {
                                // Sumamos los elementos de la misma posición
                                resultado[i][j] = matrizA[i][j] + matrizB[i][j];
                                // Mostramos el resultado
                                System.out.print(resultado[i][j] + "\t");
                            }
                            // Cambiamos de línea
                            System.out.println();
                        }
                        break; // Terminamos esta opción
                    case 2: // Opción para restar matrices
                        System.out.println("\nRESTA DE MATRICES");
                        // Recorremos las filas
                        for (int i = 0; i < filas; i++) {
                            // Recorremos las columnas
                            for (int j = 0; j < columnas; j++) {
                                // Restamos los elementos de la misma posición
                                resultado[i][j] = matrizA[i][j] - matrizB[i][j];
                                // Mostramos el resultado
                                System.out.print(resultado[i][j] + "\t");
                            }
                            // Cambiamos de línea
                            System.out.println();
                        }
                        break; // Terminamos esta opción
                    case 3: // Opción para multiplicar matrices
                        // Verificamos si las matrices son cuadradas
                        if (filas == columnas) {
                            System.out.println("\nMULTIPLICACION DE MATRICES");
                            // Recorremos las filas de A
                            for (int i = 0; i < filas; i++) {
                                // Recorremos las columnas de B
                                for (int j = 0; j < columnas; j++) {
                                    // Inicializamos cada resultado en cero
                                    resultado[i][j] = 0;
                                    // Recorremos los elementos para multiplicar
                                    for (int k = 0; k < columnas; k++) {
                                        // Multiplicamos y acumulamos los productos
                                        resultado[i][j] += matrizA[i][k] * matrizB[k][j];
                                    }
                                    // Mostramos el resultado
                                    System.out.print(resultado[i][j] + "\t");
                                }
                                // Cambiamos de línea
                                System.out.println();
                            }
                        } else {
                            // Mostramos un mensaje si no se pueden multiplicar
                            System.out.println("No se pueden multiplicar las matrices.");
                            // Explicamos el motivo
                            System.out.println("Las dimensiones M x N de ambas matrices no son compatibles, deben ser cuadradas");
                        }
                        break; // Terminamos esta opción
                    case 4: // Opción para transponer la matriz A
                        System.out.println("\nTRANSPUESTA DE LA MATRIZ A");
                        // Recorremos las filas originales
                        for (int i = 0; i < filas; i++) {
                            // Recorremos las columnas originales
                            for (int j = 0; j < columnas; j++) {
                                // Intercambiamos las posiciones
                                transpuesta[j][i] = matrizA[i][j];
                            }
                        }
                        // Recorremos las filas de la transpuesta
                        for (int i = 0; i < columnas; i++) {
                            // Recorremos las columnas de la transpuesta
                            for (int j = 0; j < filas; j++) {
                                // Mostramos cada elemento
                                System.out.print(transpuesta[i][j] + "\t");
                            }
                            // Cambiamos de línea
                            System.out.println();
                        }
                        break; // Terminamos esta opción
                    case 5: // Opción para salir
                        System.out.println("Programa finalizado.");
                        break; // Terminamos esta opción
                    default: // Si el usuario ingresa otra opción
                        System.out.println("Opción incorrecta. Intente nuevamente.");
                } // Termina switch
            } while (opcion != 5); // Repetimos mientras la opción sea diferente de 5
        } else {
            // Mensaje cuando las dimensiones no son válidas
            System.out.println("Error: las filas y columnas deben ser mayores que cero.");
        }
        teclado.close(); // Cerramos Scanner
    } // Finalizamos el método principal
} //Finalizamos la clase Main (Ejericio4)