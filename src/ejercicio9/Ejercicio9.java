package ejercicio9; // Define el paquete al que pertenece este archivo

import java.util.Scanner; // Importa la herramienta de lectura de teclado

// 1. CREACIÓN DEL TIPO DE DATO DEFINIDO POR EL USUARIO (Registro)
// Esto agrupa características de distintos tipos en un solo "molde"
class Medicamento {
    String nombre; // Variable de texto para el nombre
    int stockActual; // Variable entera para la cantidad que hay en farmacia
    int stockMinimo; // Variable entera para la alerta de escasez
    double precioUnitario; // Variable decimal para el costo
}

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Inicializa el lector
        
        // 2. Crear un arreglo de nuestro nuevo tipo de dato (Inventario)
        // Le damos una capacidad máxima de 100 medicamentos diferentes
        Medicamento[] inventario = new Medicamento[100]; 
        int cantidadMedicamentos = 0; // Contador para saber cuántos hemos registrado
        int opcion = 0; // Variable para controlar el menú interactivo

        // 3. Bucle do-while para mantener el menú abierto hasta que el usuario decida salir
        do {
            System.out.println("\n===== SISTEMA DE FARMACIA =====");
            System.out.println("1. Registrar medicamentos");
            System.out.println("2. Mostrar medicamentos con stock bajo");
            System.out.println("3. Calcular valor total del inventario");
            System.out.println("4. Actualizar stock por venta");
            System.out.println("5. Reporte general del inventario");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt(); // Lee la opción del menú
            scanner.nextLine(); // Limpia el salto de línea residual del buffer

            // 4. Estructura condicional Switch para ejecutar la opción elegida
            switch (opcion) {
                
                // a. Registrar medicamentos
                case 1:
                    System.out.print("\n¿Cuántos medicamentos desea registrar ahora?: ");
                    int n = scanner.nextInt(); // Lee cuántos va a ingresar
                    scanner.nextLine(); // Limpia buffer
                    
                    for (int i = 0; i < n; i++) { // Bucle para pedir datos
                        System.out.println("\nMedicamento #" + (cantidadMedicamentos + 1));
                        
                        // Instanciamos (creamos) un nuevo medicamento en el arreglo
                        inventario[cantidadMedicamentos] = new Medicamento(); 
                        
                        System.out.print("Nombre: ");
                        inventario[cantidadMedicamentos].nombre = scanner.nextLine(); // Guarda el nombre
                        System.out.print("Stock actual: ");
                        inventario[cantidadMedicamentos].stockActual = scanner.nextInt(); // Guarda stock actual
                        System.out.print("Stock mínimo: ");
                        inventario[cantidadMedicamentos].stockMinimo = scanner.nextInt(); // Guarda stock mínimo
                        System.out.print("Precio unitario: $");
                        inventario[cantidadMedicamentos].precioUnitario = scanner.nextDouble(); // Guarda precio
                        scanner.nextLine(); // Limpia buffer tras el último número
                        
                        cantidadMedicamentos++; // Aumenta el contador de medicamentos registrados
                    }
                    break;

                // b. Mostrar stock bajo el mínimo
                case 2:
                    System.out.println("\n--- ALERTA DE STOCK BAJO ---");
                    boolean hayBajos = false; // Bandera para saber si encontró alguno
                    for (int i = 0; i < cantidadMedicamentos; i++) { // Recorre el inventario
                        // Compara si el actual es menor al mínimo
                        if (inventario[i].stockActual < inventario[i].stockMinimo) { 
                            System.out.println("- " + inventario[i].nombre + " (Actual: " + inventario[i].stockActual + ", Mínimo: " + inventario[i].stockMinimo + ")");
                            hayBajos = true;
                        }
                    }
                    if (!hayBajos) System.out.println("Todos los medicamentos tienen buen stock.");
                    break;

                // c. Calcular valor total económico
                case 3:
                    double valorTotal = 0; // Acumulador de dinero
                    for (int i = 0; i < cantidadMedicamentos; i++) { // Recorre inventario
                        // Multiplica el stock por el precio de cada uno y lo suma al total
                        valorTotal += (inventario[i].stockActual * inventario[i].precioUnitario); 
                    }
                    System.out.println("\nValor económico total del inventario: $" + valorTotal);
                    break;

                // d. Actualizar stock tras venta
                case 4:
                    System.out.print("\nIngrese el nombre del medicamento vendido: ");
                    String nombreVenta = scanner.nextLine(); // Lee el nombre a buscar
                    boolean encontrado = false; // Bandera de búsqueda
                    
                    for (int i = 0; i < cantidadMedicamentos; i++) { // Recorre el arreglo
                        // Compara ignorando mayúsculas y minúsculas (equalsIgnoreCase)
                        if (inventario[i].nombre.equalsIgnoreCase(nombreVenta)) { 
                            encontrado = true;
                            System.out.print("¿Cuántas unidades se vendieron?: ");
                            int cantidadVendida = scanner.nextInt();
                            
                            // Valida que no se vendan más de las que hay
                            if (cantidadVendida <= inventario[i].stockActual) {
                                inventario[i].stockActual -= cantidadVendida; // Resta la venta al stock
                                System.out.println("Venta registrada. Nuevo stock: " + inventario[i].stockActual);
                            } else {
                                System.out.println("Error: No hay suficiente stock para esa venta.");
                            }
                            break; // Rompe el bucle porque ya encontró el medicamento
                        }
                    }
                    if (!encontrado) System.out.println("Medicamento no encontrado en el sistema.");
                    break;

                // e. Reporte general
                case 5:
                    System.out.println("\n--- REPORTE GENERAL ---");
                    for (int i = 0; i < cantidadMedicamentos; i++) { // Imprime la lista completa
                        System.out.println(inventario[i].nombre + " | Stock: " + inventario[i].stockActual + " | Precio: $" + inventario[i].precioUnitario);
                    }
                    break;

                // Salir del programa
                case 6:
                    System.out.println("\nCerrando sistema de farmacia...");
                    break;

                // Validación por si eligen un número que no existe en el menú
                default:
                    System.out.println("\nOpción inválida, intente de nuevo.");
            }
            
        } while (opcion != 6); // El menú se repite mientras la opción no sea 6

        scanner.close(); // Cierra el lector de teclado
    }
}