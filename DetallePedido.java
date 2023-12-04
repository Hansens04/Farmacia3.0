public class DetallePedido {
    private Productos productos;
    private EncabezadoPedido encabezadoPedido;
    private double total;
    public DetallePedido(Productos productos, EncabezadoPedido encabezadoPedido){
        this.productos= productos;
        this.encabezadoPedido=encabezadoPedido;
    }

    public DetallePedido(String codigoProducto, String nombreProducto, int cantidad) {
    }

    public Productos darProducto(){
        return productos;
    }
    public double calcularTotal(){
        total=0.0;
        total= darProducto().getPrecio()* darProducto().getStock();
        return total;
}


}