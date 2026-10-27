package ejercicio1; // Define que este archivo pertenece a la subcarpeta (paquete) ejercicio1

import java.util.Scanner; // Importamos la herramienta para leer datos desde el teclado

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Inicializamos el lector de teclado

        // 1. Definir el tamaño de los arreglos
        System.out.print("Ingrese la cantidad de reprobados en MATEMATICA: ");
        int n = scanner.nextInt(); // Leemos el tamaño N para el primer arreglo
        System.out.print("Ingrese la cantidad de reprobados en INGLES: ");
        int m = scanner.nextInt(); // Leemos el tamaño M para el segundo arreglo
        scanner.nextLine(); // Limpiamos el salto de línea de la memoria

        // 2. Crear los dos arreglos principales (uso string porque las cédulas pueden empezar con 0)
        String[] reprobadosMatematica = new String[n];
        String[] reprobadosIngles = new String[m];

        // 3. Llenar el arreglo de Matemática
        System.out.println("\n--- REGISTRO DE MATEMÁTICA ---");
        for (int i = 0; i < n; i++) { // Bucle para pedir cada cédula según la cantidad N
            System.out.print("Ingrese cédula del reprobado #" + (i + 1) + ": ");
            reprobadosMatematica[i] = scanner.nextLine(); // Guardamos el dato en la posición i
        }

        // 4. Llenar el arreglo de Inglés
        System.out.println("\n--- REGISTRO DE INGLÉS ---");
        for (int i = 0; i < m; i++) { // Bucle para pedir cada cédula según la cantidad M
            System.out.print("Ingrese cédula del reprobado #" + (i + 1) + ": ");
            reprobadosIngles[i] = scanner.nextLine(); // Guardamos el dato en la posición i
        }

        // 5. Crear el tercer vector para los que reprobaron ambas
        // El tamaño máximo posible es la cantidad más pequeña entre n y m
        int tamañoMaximo = Math.min(n, m); 
        String[] reprobadosAmbas = new String[tamañoMaximo];
        int contadorAmbas = 0; // Variable para saber cuántos coinciden realmente

        // 6. Lógica para buscar coincidencias (comparar un arreglo con el otro)
        for (int i = 0; i < n; i++) { // Recorremos el arreglo de Matemática
            for (int j = 0; j < m; j++) { // Por cada estudiante de Mate, recorremos el de Inglés
                // Si la cédula de Matemática es igual a la de Inglés...
                if (reprobadosMatematica[i].equals(reprobadosIngles[j])) {
                    reprobadosAmbas[contadorAmbas] = reprobadosMatematica[i]; // Lo guardamos en el vector 3
                    contadorAmbas++; // Aumentamos el contador de coincidencias
                    break; // Rompemos el bucle interno porque ya encontramos la coincidencia
                }
            }
        }

        // 7. Imprimir los resultados finales requeridos por la rúbrica
        System.out.println("\n================ RESULTADOS ================");
        
        System.out.println("Vector 1 - Reprobados MATEMÁTICA:");
        for (int i = 0; i < n; i++) { // Bucle para imprimir el primer arreglo
            System.out.print(reprobadosMatematica[i] + "  ");
        }

        System.out.println("\n\nVector 2 - Reprobados INGLÉS:");
        for (int i = 0; i < m; i++) { // Bucle para imprimir el segundo arreglo
            System.out.print(reprobadosIngles[i] + "  ");
        }

        System.out.println("\n\nVector 3 - Reprobados en AMBAS MATERIAS:");
        if (contadorAmbas == 0) { // Validamos si hubo o no hubo coincidencias
            System.out.println("Ningún estudiante reprobó ambas materias.");
        } else {
            for (int i = 0; i < contadorAmbas; i++) { // Imprimimos solo los espacios llenos del tercer vector
                System.out.print(reprobadosAmbas[i] + "  ");
            }
        }
        System.out.println("\n============================================");

        scanner.close(); // Cerramos la herramienta de lectura
    }
}