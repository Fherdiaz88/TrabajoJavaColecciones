//Ejercicio 8:     Se desea obtener el grado de eficiencia de N operarios de una fábrica 
// productora de pupitres, de acuerdo con las siguientes condiciones que se les 
// impone para un periodo determinado.
//a. Ausencia del trabajo <= 3 horas
//b. Pupitres defectuosos < 300
//c. Pupitres producidos > 10000

//Los grados de eficiencia del trabajador son asignados de la siguiente forma:
//a. Si no cumple ninguna condición: Grado = 5
//b. Si sólo cumple la primera condición: Grado = 7
//c. Si sólo cumple la segunda condición: Grado = 8
//d. Si sólo cumple la tercera condición: Grado = 9
//e. Si cumple la primera y la segunda: Grado = 12
//f. Si cumple la primera y la tercera: Grado = 13
//g. Si cumple la segunda y la tercera: Grado = 15
//h. Si cumple las tres condiciones: Grado = 20

//Por cada trabajador se tiene un registro con los siguientes datos:
//a. Código del trabajador
//b. Horas de ausencia
//c. Pupitres defectuosos
//d. Pupitres producidos

//Elaborar un programa que calcule para cada trabajador
//  su correspondiente grado de eficiencia e imprima toda su información

import java.util.Scanner; // Importamos Scanner para ingresar datos desde el teclado
public class Ejercicio8 { // Declaramos la clase principal del programa

    public static void main(String[] args) { // Iniciamos el método principal
        // Creamos un objeto Scanner para leer los datos ingresados
        Scanner entrada = new Scanner(System.in);
        // Declaramos la variable que almacenará el número de trabajadores
        int totalOperarios;
        // Solicitamos al usuario la cantidad de trabajadores
        System.out.print("Ingrese la cantidad de trabajadores: ");
        totalOperarios = entrada.nextInt();

        // Validamos que la cantidad de trabajadores sea mayor que cero
        while (totalOperarios <= 0) {
            // Mostramos un mensaje cuando la cantidad ingresada no es válida
            System.out.println("Error: debe ingresar al menos un trabajador.");
            // Solicitamos nuevamente la cantidad de trabajadores
            System.out.print("Ingrese la cantidad de trabajadores: ");
            totalOperarios = entrada.nextInt();
        }

        // Repetimos el proceso según la cantidad de trabajadores ingresada
        for (int numeroOperario = 1; numeroOperario <= totalOperarios; numeroOperario++) {
            // Mostramos el número del trabajador que estamos evaluando
            System.out.println("\nTRABAJADOR " + numeroOperario + " :");
            // Solicitamos el código del trabajador
            System.out.print("Ingrese el código del trabajador: ");
            String codigoOperario = entrada.next();
            // Solicitamos las horas de ausencia
            System.out.print("Ingrese las horas de ausencia: ");
            double tiempoAusente = entrada.nextDouble();

            // Validamos que las horas de ausencia no sean negativas
            while (tiempoAusente < 0) {
                // Mostramos un mensaje de error
                System.out.println("Error: las horas no pueden ser negativas.");
                // Solicitamos nuevamente las horas de ausencia
                System.out.print("Ingrese las horas de ausencia: ");
                tiempoAusente = entrada.nextDouble();
            }

            // Solicitamos la cantidad de pupitres defectuosos
            System.out.print("Ingrese la cantidad de pupitres defectuosos: ");
            int pupitresConFallas = entrada.nextInt();
            // Validamos que la cantidad de pupitres defectuosos no sea negativa
            while (pupitresConFallas < 0) {
                // Mostramos un mensaje de error
                System.out.println("Error: la cantidad no puede ser negativa.");
                // Solicitamos nuevamente la cantidad de pupitres defectuosos
                System.out.print("Ingrese la cantidad de pupitres defectuosos: ");
                pupitresConFallas = entrada.nextInt();
            }
            // Solicitamos la cantidad total de pupitres producidos
            System.out.print("Ingrese la cantidad de pupitres producidos: ");
            int cantidadFabricada = entrada.nextInt();

            // Validamos que la producción no sea negativa ni menor que los defectuosos
            while (cantidadFabricada < 0 || cantidadFabricada < pupitresConFallas) {
                // Mostramos un mensaje de error
                System.out.println("Error: la producción no puede ser negativa ni menor que los pupitres defectuosos.");
                // Solicitamos nuevamente la cantidad producida
                System.out.print("Ingrese la cantidad de pupitres producidos: ");
                cantidadFabricada = entrada.nextInt();
            }

            // Verificamos si las horas de ausencia son menores o iguales a 3
            boolean asistenciaAceptable = tiempoAusente <= 3;
            // Verificamos si los pupitres defectuosos son menos de 300
            boolean defectosAceptables = pupitresConFallas < 300;
            // Verificamos si la cantidad producida supera los 10000 pupitres
            boolean produccionAceptable = cantidadFabricada > 10000;
            // Declaramos la variable donde almacenaremos el grado de eficiencia
            int nivelEficiencia;

            // CASO 1: El trabajador cumple las tres condiciones
            if (asistenciaAceptable && defectosAceptables && produccionAceptable) {
                // Asignamos el grado 20.
                nivelEficiencia = 20;

            // CASO 2: Cumple la primera y segunda, pero no la tercera
            } else if (asistenciaAceptable && defectosAceptables && !produccionAceptable) {
                // Asignamos el grado 12.
                nivelEficiencia = 12;

            // CASO 3: Cumple la primera y tercera, pero no la segunda
            } else if (asistenciaAceptable && !defectosAceptables && produccionAceptable) {
                // Asignamos el grado 13.
                nivelEficiencia = 13;

            // CASO 4: Cumple la segunda y tercera, pero no la primera
            } else if (!asistenciaAceptable && defectosAceptables && produccionAceptable) {
                // Asignamos el grado 15.
                nivelEficiencia = 15;

            // CASO 5: Cumple solamente la primera condición
            } else if (asistenciaAceptable && !defectosAceptables && !produccionAceptable) {
                // Asignamos el grado 7.
                nivelEficiencia = 7;

            // CASO 6: Cumple solamente la segunda condición
            } else if (!asistenciaAceptable && defectosAceptables && !produccionAceptable) {
                // Asignamos el grado 8.
                nivelEficiencia = 8;

            // CASO 7: Cumple solamente la tercera condición
            } else if (!asistenciaAceptable && !defectosAceptables && produccionAceptable) {
                // Asignamos el grado 9.
                nivelEficiencia = 9;

            // CASO 8: No cumple ninguna de las tres condiciones
            } else {
                // Asignamos el grado 5
                nivelEficiencia = 5;
            }

            // Mostramos los resultados del trabajador evaluado
            System.out.println("\n LOS RESULTADOS DEL TRABAJADOR SON:");
            // Mostramos el código del trabajador
            System.out.println("Código del trabajador: " + codigoOperario);
            // Mostramos las horas de ausencia registradas
            System.out.println("Horas de ausencia: " + tiempoAusente);
            // Mostramos la cantidad de pupitres defectuosos
            System.out.println("Pupitres defectuosos: " + pupitresConFallas);
            // Mostramos la cantidad de pupitres producidos
            System.out.println("Pupitres producidos: " + cantidadFabricada);
            // Mostramos el cumplimiento de la primera condición
            System.out.println("Cumple condición 1: " + asistenciaAceptable);
            // Mostramos el cumplimiento de la segunda condición
            System.out.println("Cumple condición 2: " + defectosAceptables);
            // Mostramos el cumplimiento de la tercera condición
            System.out.println("Cumple condición 3: " + produccionAceptable);
            // Mostramos el grado de eficiencia obtenido
            System.out.println("GRADO DE EFICIENCIA: " + nivelEficiencia);            
        }
        // Cerramos el objeto Scanner al finalizar el programa
        entrada.close();
    }
}