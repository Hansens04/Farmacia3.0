import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EncabezadoPedido {
    private Proveedores proveedores;
    private Fecha fechapedido;
    private boolean estadoPedido;
    private int contadorPedido;

    private List<DetallePedido> detalleP;
    public EncabezadoPedido(int dia, int mes, int anio, String nombreProveedor,
                            String telefono, String estadoPedido, String codigoProducto,
                            String nombreProducto, int cantidad) {
        this.fechapedido = new Fecha(dia, mes, anio);
        this.proveedores = new Proveedores(nombreProveedor, telefono, Arrays.asList(codigoProducto));
        this.estadoPedido = estadoPedido.equals("enviado"); // Opcional: Puedes ajustar según tus necesidades.
        this.detalleP = Arrays.asList(new DetallePedido(codigoProducto,nombreProducto,cantidad));}
    public EncabezadoPedido() {
        fechapedido = new Fecha(0, 0, 0);
        proveedores = new Proveedores("null", "0000", Collections.singletonList("null"));
        estadoPedido = false;
        detalleP = new ArrayList<>(Collections.singletonList(new DetallePedido("null", "null", 0)));
    }

    public Proveedores getProveedores() {
        return proveedores;
    }
    private int crearIdPedido(){
        return contadorPedido++;
    }
    public int getCodigoPedido(){
        return contadorPedido;
    }
    public boolean estadoPedido(){
        return estadoPedido;
    }
    public void actualizarEstadoEnviado(boolean estadoPedido){
        this.estadoPedido=estadoPedido;
    }
    public Fecha fecha(){
        return fechapedido;
    }
    public void modificarEncabezado(Proveedores pProveedor, Fecha pFecha){
        this.proveedores= pProveedor;
        this.fechapedido=pFecha;
    }
    public List<DetallePedido> getDetalleP(){
        return detalleP;
    }

    public void consultarTotalPedidos() {
        System.out.println("Consulta total de pedidos:");
        for (DetallePedido detalle : detalleP) {
            System.out.println("Pedido #" + getCodigoPedido() +
                    " - Proveedor: " + proveedores.getNombreProveedor() +
                    " - Fecha: " + fechapedido.toString() +
                    " - Estado: " + (estadoPedido ? "Enviado" : "No enviado"));
        }
    }
    public static void consultarTotalPedidosProveedor(EncabezadoPedido encabezadoPedido, Proveedores proveedor) {
        System.out.println("Consulta total de pedidos para el proveedor " + proveedor.getNombreProveedor() + ":");

        for (DetallePedido detalle : encabezadoPedido.getDetalleP()) {
            if (encabezadoPedido.getProveedores().equals(proveedor)) {
                System.out.println("Pedido #" + encabezadoPedido.getCodigoPedido() +
                        " - Producto: " + detalle.darProducto().getNombreProducto() +
                        " - Total: " + detalle.calcularTotal());
                // Agrega más información según sea necesario
            }
        }
    }
    public void modificarEncabezado(int dia, int mes, int anio, String nombreProveedor,
                                    String telefono, String estadoPedido, String codigoProducto){
        this.fechapedido = new Fecha(dia, mes, anio);
        this.proveedores = new Proveedores(nombreProveedor, telefono, Arrays.asList(codigoProducto));
        this.estadoPedido = estadoPedido.equals("enviado");
    }


}