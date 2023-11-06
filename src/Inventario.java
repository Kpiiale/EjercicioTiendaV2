public class Inventario {

    private Producto[] p;

   public Inventario() {
        this.p = new Producto[4];
        //Tipo 0= Papeleria, 1 = Supermercado, 2 = Drogueria
        p[0] = new Producto("Lápiz", 0, 10, 5, 0.50);
        p[1] = new Producto("Leche", 1, 15, 5, 0.80);
        p[2] = new Producto("Shampoo", 2, 15, 5, 2.25);
        p[3] = new Producto("Pan", 1, 40, 10, 0.15);

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
