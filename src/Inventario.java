public class Inventario {

    private Producto[] p;

    public Inventario() {
        this.p = new Producto[4];

        p[0] = new Producto("Lápiz", 0, 10, 5, 1.00);
        p[1] = new Producto("Manzana", 1, 20, 5, 0.25);
        p[2] = new Producto("Aspirina", 2, 10, 3, 2.25);
        p[3] = new Producto("Pera", 1, 20, 5, 0.25);

    }

    public void reabastecerProducto(int id, int cantidad) {
        p[id].setCantidadActual(p[id].getCantidadActual()+cantidad);
    }

    public Producto[] getP() {
        return p;
    }

    public void modificarProducto(int producto, String nombre, int tipo, int cantidadActual, int cantidadMin, double precioBase){
        p[producto].setNombre(nombre);
        p[producto].setTipo(tipo);
        p[producto].setCantidadActual(cantidadActual);
        p[producto].setCantidadMin(cantidadMin);
        p[producto].setPrecioBase(precioBase);
    }
}