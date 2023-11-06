import java.util.Scanner;

public class MainTienda {
    public static void main(String[] args) {
        int op, producto, cantidad;
        Scanner sc = new Scanner(System.in);
        Inventario inventario = new Inventario();
        Venta venta = new Venta();

       do {
            System.out.println("Seleccione una opcion: ");
            System.out.println("1. Visualizacion de productos");
            System.out.println("2. Vender un producto");
            System.out.println("3. Abastecer la tienda con un producto");
            System.out.println("4. Cambiar un producto");
            System.out.println("5. Estadísticas de venta");
            System.out.println("6. Salir");

            op = Integer.parseInt(sc.next());

            switch (op) {
                case 1:
                    for (int i = 0; i < inventario.getP().length; i++) {
                        System.out.println("Producto " + (i + 1) + ": " + inventario.getP()[i].getNombre());
                         System.out.println("Tipo: " + inventario.getP()[i].getTipo());
                        System.out.println("Cantidad actual: " + inventario.getP()[i].getCantidadActual());
                        System.out.println("Cantidad mínima: " + inventario.getP()[i].getCantidadMin());
                        System.out.println("Precio base: " + inventario.getP()[i].getPrecioBase());
                        System.out.println("Precio venta final: " + inventario.getP()[i].precioFinal());
                        System.out.println("-------------------------------------------------");
                    }
                    break;

                case 2:
                    System.out.println("Seleccione el producto que desea vender (Ingresar el numero correspondiente a cada producto):");
                    for (int i = 0; i < inventario.getP().length; i++) {
                        System.out.println("Producto " + (i + 1) + ": " + inventario.getP()[i].getNombre());
                    }
                    producto = Integer.parseInt(sc.next()) - 1;
                    System.out.println("Cantidad vendida: ");
                    cantidad = Integer.parseInt(sc.next());

                    venta.realizarVenta(producto, cantidad, inventario.getP()[producto].precioFinal());
                    break;

                case 3:
                    System.out.println("Ingrese el producto a reabastecer (Ingresar el numero correspondiente a cada producto): ");
                    for (int i = 0; i < inventario.getP().length; i++) {
                        System.out.println("Producto " + (i + 1) + ": " + inventario.getP()[i].getNombre());
                    }
                    producto = Integer.parseInt(sc.next()) - 1;
                    System.out.println("Ingrese la cantidad: ");
                    cantidad = Integer.parseInt(sc.next());

                    inventario.reabastecerProducto(producto, cantidad);
                    break;

                case 4:
                    String nombre;
                    int tipo, cantidadActual, cantidadMin;
                    double precioBase;

                    System.out.println("Ingrese el producto que desea modificar (Ingresar el numero correspondiente a cada producto) ");
                    for (int i = 0; i < inventario.getP().length; i++) {
                        System.out.println("Producto " + (i + 1) + " " + inventario.getP()[i].getNombre());
                    }
                    producto = Integer.parseInt(sc.next()) - 1;
                    System.out.println("Ingrese el nuevo nombre del producto");
                    nombre = sc.nextLine();
                    System.out.println("Ingrese el nuevo tipo del producto segun la siguiente lista:");
                    System.out.println("\n0= Papeleria \n 1 = Supermercado \n 2 = Drogueria");
                    tipo = Integer.parseInt(sc.next());
                    System.out.println("Ingrese la nueva cantidad en inventario");
                    cantidadActual = Integer.parseInt(sc.next());
                    System.out.println("Ingrese la nueva cantidad mínima de producto para solicitar inventario");
                    cantidadMin = Integer.parseInt(sc.next());
                    System.out.println("Ingrese el nuevo precio (recuerde usar . en lugar de ,)");
                    precioBase = Double.parseDouble(sc.next());

                    inventario.modificarProducto(producto, nombre, tipo, cantidadActual, cantidadMin, precioBase);
                    break;

                case 5:
                    int op1 = 0;

                    do{

                        System.out.println("Porfavor elija una opcion");
                        System.out.println("1. El producto más vendido");
                        System.out.println("2. El producto menos vendido");
                        System.out.println("3. Cantidad total de dinero recaudado por ventas");
                        System.out.println("4. Cantidad dinero recaudado por ventas de un producto");
                        System.out.println("5. Volver");

                        op1 = Integer.parseInt(sc.next());

                        switch (op1){
                            case 1:
                                producto = venta.productoMasVendido();
                                System.out.println("El producto más vendido es: " + inventario.getP()[producto] + " con " + venta.ventasProducto(producto) + " unidades vendidas");
                                break;
                            case 2:
                                producto = venta.productoMenosVendido();
                                System.out.println("El producto menos vendido es: " + inventario.getP()[producto] + " con " + venta.ventasProducto(producto) + " unidades vendidas");
                                break;
                            case 3:
                                venta.ventasTotales();
                                break;
                            case 4:
                                System.out.println("Ingrese el producto(1-4): ");
                                producto = Integer.parseInt(sc.next());
                                System.out.println("El dinero recaudado por el producto " + inventario.getP()[producto].getNombre() + " es: " + venta.dineroVentasProducto(producto));
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Ingrese una opción valida");
                                break;
                        }
                    }while (op1 != 5);
                    break;

                case 6:
                    System.out.println("Fin del programa");
                    break;

                default:
                    System.out.println("Ingrese una opción válida");
                    break;
            }
        } while (op != 6);
    }
}
