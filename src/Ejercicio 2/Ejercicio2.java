// EJERCICIO 2: VECTORES EN JAVA

// Se tiene un vector de 20 elementos con valores numéricos enteros aleatorios.

// Se debe realizar:
// a. Leer por teclado un número y buscar en qué posición del vector se encuentra.
// b. Crear un segundo vector con los elementos de los índices impares del vector original.
// c. Buscar en el segundo vector cuántos elementos son mayores a 20 y mostrar el resultado.


// RESOLUCIÓN

import java.util.Scanner; // Importamos Scanner para leer datos desde el teclado
public class Ejercicio2 { // Declaramos la clase principal del programa

    public static void main(String[] args) { // Iniciamos el método principal
        Scanner entrada = new Scanner(System.in); // Creamos un objeto Scanner


        // DECLARACIÓN DE VARIABLES
        int[] vector1 = new int[20]; // Creamos el primer vector de 20 elementos
        int[] vector2 = new int[10]; // Creamos el segundo vector de 10 elementos
        int numero; // Variable para guardar el número que ingresará el usuario
        int j = 0; // Contador para llenar el segundo vector
        int contador = 0; // Contador de números mayores a 20
        boolean encontrado = false; // Variable para saber si encontramos el número


        // PASO 1: LLENAR EL PRIMER VECTOR CON NÚMEROS ALEATORIOS
        System.out.println("VECTOR ORIGINAL:");
        for (int i = 0; i < 20; i++) { // Recorremos las 20 posiciones del vector
            vector1[i] = (int)(Math.random() * 50) + 1; // Generamos números aleatorios del 1 al 50
            System.out.print(vector1[i] + " "); // Mostramos cada número del vector
        }
        System.out.println(); // Realizamos un salto de línea

        // APARTADO A: BUSCAR UN NÚMERO EN EL PRIMER VECTOR
        System.out.println("\nIngrese un número para buscar:");
        numero = entrada.nextInt(); // Guardamos el número ingresado por el usuario
        for (int i = 0; i < 20; i++) { // Recorremos el primer vector
            if (vector1[i] == numero) { // Comparamos el elemento con el número ingresado
                System.out.println("Número encontrado en el índice: " + i); // Mostramos el índice
                encontrado = true; // Indicamos que encontramos el número
            }
        }
        if (encontrado == false) { // Verificamos si el número no fue encontrado
            System.out.println("El número no se encuentra en el vector."); // Mostramos el mensaje
        }


        // APARTADO B: CREAR EL SEGUNDO VECTOR CON LOS ÍNDICES IMPARES
        for (int i = 0; i < 20; i++) { // Recorremos el primer vector
            if (i % 2 != 0) { // Verificamos si el índice es impar
                vector2[j] = vector1[i]; // Copiamos el elemento al segundo vector
                j++; // Aumentamos el contador del segundo vector
            }
        }

        System.out.println("\nSEGUNDO VECTOR (ÍNDICES IMPARES):");
        for (int i = 0; i < 10; i++) { // Recorremos el segundo vector
            System.out.print(vector2[i] + " "); // Mostramos sus elementos
        }
        System.out.println(); // Realizamos un salto de línea


        // APARTADO C: CONTAR LOS NÚMEROS MAYORES A 20
        for (int i = 0; i < 10; i++) { // Recorremos el segundo vector
            if (vector2[i] > 20) { // Verificamos si el elemento es mayor a 20
                contador++; // Aumentamos el contador en una unidad
            }
        }
        System.out.println("\nCantidad de elementos mayores a 20: " + contador); // Mostramos el resultado
        entrada.close(); // Cerramos Scanner
    } // Finalizamos el método principal
} // Finalizamos la clase Main