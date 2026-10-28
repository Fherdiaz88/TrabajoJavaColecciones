//Ejercicio 10: Un restaurante registra los pedidos realizados por sus clientes. 
//Por cada pedido se debe ingresar el nombre del cliente, plato solicitado, 
// cantidad y precio unitario.

//Elabore un programa que permita:
//a. Registrar pedidos en una lista
//b. Calcular el total a pagar por cada pedido
//c. Aplicar un descuento del 10% si el pedido supera los 50 USD
//d. Calcular el ingreso total del restaurante
//e. Mostrar el pedido de mayor valor.

import java.util.ArrayList; // Importamos ArrayList para crear listas
import java.util.Locale; // Importamos Scanner para leer datos desde el teclado
import java.util.Scanner; // Permite establecer configuraciones regionales (como se escriben los números según el país o la región)

// Creamos la clase principal
public class Ejercicio10 {
   
    public static void main(String[] args) {  // Aquí comienza el programa porque iniciamos el método principal
        // Creamos el objeto para leer los datos
        Scanner entrada = new Scanner(System.in);
        // Configura el objeto Scanner para que utilice el formato de Estados Unidos al leer los datos (10.50)
        entrada.useLocale(Locale.US);
        // Creamos una lista para guardar los clientes
        ArrayList<String> clientes = new ArrayList<>();
        // Creamos una lista para guardar los platos
        ArrayList<String> platos = new ArrayList<>();
        // Creamos una lista para guardar las cantidades
        ArrayList<Integer> cantidades = new ArrayList<>();
        // Creamos una lista para guardar los precios
        ArrayList<Double> precios = new ArrayList<>();
        // Creamos una lista para guardar los subtotales
        ArrayList<Double> subtotales = new ArrayList<>();
        // Creamos una lista para guardar los descuentos
        ArrayList<Double> descuentos = new ArrayList<>();
        // Creamos una lista para guardar los totales
        ArrayList<Double> totales = new ArrayList<>();

        // Declaramos la cantidad de pedidos
        int numeroPedidos;
        // Preguntamos cuántos pedidos se van a registrar
        System.out.print("Ingrese el numero de pedidos: ");
        // Guardamos el número ingresado
        numeroPedidos = entrada.nextInt();
        // Limpiamos el salto de línea pendiente
        entrada.nextLine();

        // Repetimos el registro según la cantidad de pedidos
        for (int i = 0; i < numeroPedidos; i++) {
            // Solicitamos el nombre del cliente
            System.out.print("Ingrese el nombre del cliente: ");
            // Guardamos el nombre
            clientes.add(entrada.nextLine());
            // Solicitamos el nombre del plato
            System.out.print("Ingrese el nombre del plato solicitado: ");
            // Guardamos el plato
            platos.add(entrada.nextLine());
            // Solicitamos la cantidad de platos
            System.out.print("Ingrese la cantidad de platos solicitados: ");
            // Guardamos la cantidad
            cantidades.add(entrada.nextInt());
            // Solicitamos el precio unitario
            System.out.print("Ingrese el precio unitario del plato: ");
            // Guardamos el precio
            precios.add(entrada.nextDouble());
            // Limpiamos el salto de línea pendiente
            entrada.nextLine();
        }

        // Declaramos la variable para sumar los ingresos
        double ingresoTotal = 0;
        // Declaramos la posición del pedido más costoso
        int posicionMayor = 0;

        // Recorremos todos los pedidos registrados
        for (int i = 0; i < numeroPedidos; i++) {
            // Calculamos el subtotal del pedido actual
            double subtotal = cantidades.get(i) * precios.get(i);
            // Inicializamos el descuento en cero
            double descuento = 0;
            // Comprobamos si el subtotal supera los 50 dolares
            if (subtotal > 50) {
                // Calculamos el descuento del 10 %
                descuento = subtotal * 0.10;
            }
            // Calculamos el total después del descuento
            double total = subtotal - descuento;
            // Guardamos el subtotal en la lista
            subtotales.add(subtotal);
            // Guardamos el descuento en la lista
            descuentos.add(descuento);
            // Guardamos el total en la lista
            totales.add(total);
            // Sumamos el total a los ingresos del restaurante
            ingresoTotal = ingresoTotal + total;
            // Comprobamos si el pedido actual supera al de mayor valor
            if (total > totales.get(posicionMayor)) {
            // Guardamos la posición del pedido más costoso
                posicionMayor = i;
            }
        }

        // Mostramos el título de los resultados
        System.out.println("\n DESGLOSE DE LOS PEDIDOS REALIZADOS ");
        // Recorremos los pedidos para mostrar sus resultados

        for (int i = 0; i < numeroPedidos; i++) {
            // Mostramos el nombre del cliente
            System.out.println("\nNombre del cliente: " + clientes.get(i));
            // Mostramos el plato solicitado
            System.out.println("Plato solicitado: " + platos.get(i));
            // Mostramos el subtotal
            System.out.println("Subtotal: $" + subtotales.get(i));
            // Mostramos el descuento
            System.out.println("Descuento: $"+ descuentos.get(i));
            // Mostramos el total a pagar
            System.out.println("Total a pagar: $"+ totales.get(i));
        }

        // Mostramos los ingresos del restaurante
        System.out.println("\nIngreso total: $"+ ingresoTotal);
        // Mostramos el pedido de mayor valor
        System.out.println("\nEL PEDIDO DE MAYOR VALOR ES DE:");
        // Mostramos el cliente que realizó el pedido
        System.out.println("Nombre del cliente: " + clientes.get(posicionMayor));
        // Mostramos el plato solicitado
        System.out.println("Plato solictado: " + platos.get(posicionMayor));
        // Mostramos el costo final del pedido
        System.out.println("Total: $"+ totales.get(posicionMayor));
        // Cerramos el Scanner
        entrada.close();
    } // Finalizamos el método principal
}// Finalizamos la clase