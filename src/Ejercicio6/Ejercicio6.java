//Ejercicio 6: Elaborar un programa que consolide una matriz de N x M elementos. Cada 
//elemento de la matriz representa las ventas atribuibles a cada uno de los N vendedores de 
// una empresa, para cada uno de los M años de operaciones que ha tenido la misma. 

// Se debe calcular:
//a. El total de ventas de cada vendedor de los M años.
//b. El total de ventas en cada año
//c. El total de ventas de la empresa.

import java.util.Scanner; // Importamos Scanner para ingresar datos por teclado
public class Ejercicio6 { // Creamos la clase principal del programa

    public static void main(String[] args) { // Método principal donde inicia el programa
        Scanner sc = new Scanner(System.in); // Creamos Scanner para leer datos
        
        // PASO 1: DECLARAR LAS VARIABLES
        int N; // Guarda la cantidad de vendedores
        int M; // Guarda la cantidad de años
        double totalVendedor; // Guarda el total de ventas de cada vendedor
        double totalAnio; // Guarda el total de ventas de cada año
        double totalEmpresa = 0; // Guarda el total general de ventas de la empresa

        // PASO 2: SOLICITAR LA CANTIDAD DE VENDEDORES Y AÑOS
        System.out.print("Ingrese la cantidad de vendedores: "); // Solicitamos vendedores
        N = sc.nextInt(); // Guardamos la cantidad de vendedores
        System.out.print("Ingrese la cantidad de años: "); // Solicitamos años
        M = sc.nextInt(); // Guardamos la cantidad de años

        // PASO 3: CREAR LA MATRIZ DE VENTAS
        double[][] ventas = new double[N][M]; // Creamos la matriz con N filas y M columnas

        // PASO 4: INGRESAR LAS VENTAS DE CADA VENDEDOR
        for (int i = 0; i < N; i++) { // Recorremos cada vendedor (filas)
            System.out.println("\nVendedor " + (i + 1)); // Mostramos el número de vendedor
            for (int j = 0; j < M; j++) { // Recorremos cada año (columnas)
                System.out.print("Ingrese las ventas del año " + (j + 1) + ": "); // Pedimos las ventas
                ventas[i][j] = sc.nextDouble(); // Guardamos las ventas en la matriz
            } // Fin del ciclo de los años
        } // Fin del ciclo de los vendedores

        // PASO 5: MOSTRAR LA MATRIZ DE VENTAS
        System.out.println("\nMATRIZ DE VENTAS");
        for (int i = 0; i < N; i++) { // Recorremos las filas de la matriz
            for (int j = 0; j < M; j++) { // Recorremos las columnas de la matriz
                System.out.print(ventas[i][j] + "\t"); // Mostramos cada venta
            } // Fin del ciclo de columnas
            System.out.println(); // Saltamos a la siguiente fila
        } // Fin del ciclo de filas

        // PASO 6: CALCULAR EL TOTAL DE VENTAS POR VENDEDOR (LITERAL A)
        System.out.println("\nTOTAL DE VENTAS POR VENDEDOR");
        for (int i = 0; i < N; i++) { // Recorremos cada vendedor
            totalVendedor = 0; // Reiniciamos la suma para cada vendedor
            for (int j = 0; j < M; j++) { // Recorremos todos los años
                totalVendedor = totalVendedor + ventas[i][j]; // Sumamos las ventas del vendedor
            } // Fin del ciclo de años
            System.out.println("Total del vendedor " + (i + 1) + ": " + totalVendedor); // Mostramos el total
        } // Fin del ciclo de vendedores

        // PASO 7: CALCULAR EL TOTAL DE VENTAS POR AÑO (LITERAL B)
        System.out.println("\nTOTAL DE VENTAS POR AÑO");
        for (int j = 0; j < M; j++) { // Recorremos cada año
            totalAnio = 0; // Reiniciamos la suma para cada año
            for (int i = 0; i < N; i++) { // Recorremos todos los vendedores
                totalAnio = totalAnio + ventas[i][j]; // Sumamos las ventas del año
            } // Fin del ciclo de vendedores
            System.out.println("Total del año " + (j + 1) + ": " + totalAnio); // Mostramos el total
        } // Fin del ciclo de años

        // PASO 8: CALCULAR EL TOTAL DE VENTAS DE LA EMPRESA (LITERAL C)
        System.out.println("\nTOTAL DE VENTAS DE LA EMPRESA");
        for (int i = 0; i < N; i++) { // Recorremos cada vendedor
            for (int j = 0; j < M; j++) { // Recorremos cada año
                totalEmpresa = totalEmpresa + ventas[i][j]; // Sumamos todas las ventas
            } // Fin del ciclo de años
        } // Fin del ciclo de vendedores
        System.out.println("Total de ventas de la empresa: " + totalEmpresa); // Mostramos el resultado
        sc.close(); // Cerramos Scanner
    } // Fin del método main (Ejercicio6)
} // Fin de la clase Ejercicio6