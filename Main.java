import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String telefono;
        List<Proveedores> proveedores= new ArrayList<>();
        List<EncabezadoPedido> encabezadoPedidos= new ArrayList<>();
        ArrayList<Productos> productos= new ArrayList<>();
        Proveedores proveedores1= new Proveedores("",(""),
                Collections.singletonList(""));
        EncabezadoPedido encabezadoPedido =new EncabezadoPedido();
        int op=0;
        do {
            System.out.println("----------Farmacia-----------");
            System.out.println("1. Ingresar Proveedor");
            System.out.println("2. Agregar un producto al proveedor");
            System.out.println("3. Modificar Proveedor");
            System.out.println("4. Visualizar Proveedor");
            System.out.println("5. Ingresar Producto Stock");
            System.out.println("6. Modificar Producto Stock");
            System.out.println("7. Visualizar Producto Stock");
            System.out.println("8. Consultar Producto por Abastecer");
            System.out.println("9. Realizar Pedido");
            System.out.println("10. Modificar Pedido");
            System.out.println("11. Visualizar Pedido");
            System.out.println("12. Estado del Pedido");
            System.out.println("13. Consultar Pedidos por Producto");
            System.out.println("14. Consultar Pedidos por Proveedor");

            System.out.println("Ingrese una opcion: ");
            op= sc.nextInt();

            switch (op){
                case 1:{
                    ingresarProveedor((ArrayList<Proveedores>) proveedores);
                }break;
                case 2:{
                    ingresarProveedor((ArrayList<Proveedores>) proveedores);
                }break;
                case 3:{
                    System.out.println("Ingrese un telefono para modificar");
                    telefono= sc.next();
                    Proveedores proveedorEncontrado= buscarProveedor(proveedores, telefono);
                    if (proveedorEncontrado != null){
                        System.out.println("Ingresar nuevo nombre del proveedor");
                        String pNombreProveedor= sc.next();
                        System.out.println("Ingrese nuevo telefono del proveedor");
                        String pTelefono= sc.next();
                        System.out.println("Ingrese nuevo producto");
                        String pProducto= sc.next();
                        proveedorEncontrado.modificarProveedor(pNombreProveedor,(pTelefono),
                                Collections.singletonList(pProducto));
                    }else{
                        System.out.println("Proveedor no encontrado");
                    }
                }break;
                case 4:{
                    visualizarProveedor((ArrayList<Proveedores>) proveedores);
                }break;
                case 5:{
                    ingresarProductoStock(productos);
                }break;
                case 6:{
                    System.out.println("Ingrese el codigo del producto para modificar");
                    String idProducto= sc.next();
                    Productos productoEncontrado= buscarProducto(productos, idProducto);
                    if (productoEncontrado != null){
                        System.out.println("Ingrese nuevo codigo del producto");
                        idProducto= sc.next();
                        System.out.println("Ingrese el nuevo nombre del producto: ");
                        String pNombre= sc.next();
                        System.out.println("Ingrese nueva descripcion: ");
                        String pDescripcion= sc.next();
                        System.out.println("Ingrese nueva cantidad: ");
                        int pCantidad= sc.nextInt();
                        System.out.println("Ingrese nueva cantidad minima: ");
                        int pCantidadMinima= sc.nextInt();
                        System.out.println("Ingrese nuevo precio: ");
                        double pPrecio= sc.nextDouble();
                        productoEncontrado.modificarProducto(idProducto,pNombre,pDescripcion,pCantidad,
                                pCantidadMinima,pPrecio);
                    }else{
                        System.out.println("Producto no encontrado");
                    }
                }break;
                case 7:{
                    visualizarProductos(productos);
                }break;
                case 8:{
                    verificarYAbastecerProductos(productos);
                }break;
                case 9:{
                    realizarPedido((ArrayList<EncabezadoPedido>) encabezadoPedidos);
                }break;
                case 10:{

                }break;
                case 11:{
                    visualizarPedido((ArrayList<EncabezadoPedido>) encabezadoPedidos);
                }break;
                case 12:{
                    actualizarEstadoPedido(encabezadoPedidos);
                }break;
                case 13:{

                }break;


                case 14:{
                    visualizarProveedor((ArrayList<Proveedores>) proveedores);
                    System.out.println("Ingrese el teléfono del proveedor para consultar sus pedidos:");
                    telefono = sc.next();
                    Proveedores proveedorSeleccionado = buscarProveedor(proveedores, telefono);
                    if (proveedorSeleccionado != null) {
                        EncabezadoPedido.consultarTotalPedidosProveedor(encabezadoPedido, proveedorSeleccionado);
                    } else {
                        System.out.println("Proveedor no encontrado");
                    }
                } break;

            }
        }while(op!=24);
    }

    public static void ingresarProveedor(ArrayList<Proveedores> lista){
        String nombreProveedor;
        String telefono;
        List<String> productos;
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese el nombre del proveedor");
        nombreProveedor= sc.next();
        System.out.println("Ingrese el telefono del proveedor");
        telefono= sc.next();
        System.out.println("Ingrese el producto de su proveedor");
        productos= Collections.singletonList(sc.next());
        lista.add(new Proveedores(nombreProveedor,telefono,productos));
    }
    public static void ingresarProductoStock(ArrayList<Productos> lista){
        String nombreProducto, detalleProducto, idProducto;
        int cantidad, cantidadMinima;
        double precio;
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese el codigo del producto");
        idProducto=sc.next();
        System.out.println("Ingrese el nombre del producto");
        nombreProducto= sc.next();
        System.out.println("Ingrese el detalle del producto");
        detalleProducto= sc.next();
        System.out.println("Ingrese la cantidad del producto");
        cantidad= sc.nextInt();
        System.out.println("Ingrese la cantidad minima");
        cantidadMinima=sc.nextInt();
        System.out.println("Ingrese el precio del producto");
        precio= sc.nextDouble();
        lista.add(new Productos(idProducto,nombreProducto,detalleProducto,cantidad,cantidadMinima,precio));
    }
    public static Proveedores buscarProveedor(List<Proveedores> proveedores, String telefono){
        for(Proveedores proveedor: proveedores){
            if(proveedor.getTelefonoProveedor().contains(telefono)){
                return proveedor;
            }
        }
        return null;
    }
    public static Productos buscarProducto(List<Productos> productos, String idProducto){
        for(Productos producto: productos){
            if(producto.getIdProducto().contains(idProducto)){
                return producto;
            }
        }
        return null;
    }
    public static EncabezadoPedido buscarPedidoPorCodigo(List<EncabezadoPedido> listaPedidos, int codigoPedido) {
        for (EncabezadoPedido pedido : listaPedidos) {
            if (pedido.getCodigoPedido() == codigoPedido) {
                return pedido;
            }
        }
        return null;
    }
    public static void visualizarProveedor(ArrayList<Proveedores> lista){
        Iterator<Proveedores> it= lista.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
    public static void visualizarPedido(ArrayList<EncabezadoPedido> lista){
        Iterator<EncabezadoPedido> it= lista.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
}
}
    public static void visualizarProductos(ArrayList<Productos> lista){
        Iterator<Productos> it= lista.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
    public static void verificarYAbastecerProductos(List<Productos> listaProductos) {
        for (Productos producto : listaProductos) {
            if (producto.necesitaAbastecimiento()) {
                System.out.println("El producto " + producto.getNombreProducto() + " necesita ser abastecido.");
                // Puedes realizar las acciones necesarias para abastecer el producto aquí.
            }
        }
    }
    public static void realizarPedido(ArrayList<EncabezadoPedido> lista){
        String nombreProducto, nombreProveedor, telefono, codigoProducto, estadoPedido;
        int cantidad, dia, mes, anio;
        double precio;
        Scanner sc= new Scanner(System.in);
        System.out.println("-----Fecha------");
        System.out.println("\nIngrese el dia que realiza el pedido: ");
        dia= sc.nextInt();
        System.out.println("\nIngrese el mes que realiza el pedido: ");
        mes= sc.nextInt();
        System.out.println("\nIngrese el anio que realiza el pedido: \n");
        anio= sc.nextInt();
        System.out.println("-----Informacion Proveedor----");
        System.out.println("\nIngrese el nombre del proveedor: ");
        nombreProveedor= sc.next();
        System.out.println("\nIngrese el telefono del proveedor: \n");
        telefono= sc.next();
        System.out.println("\nIngrese el estado del pedido: (enviado o entregado)");
        estadoPedido= sc.next();
        System.out.println("-----Producto Proveedor-----");
        System.out.println("\nIngrese el codigo del producto: ");
        codigoProducto= sc.next();
        System.out.println("\nIngrese el nombre del producto: ");
        nombreProducto= sc.next();
        System.out.println("\nIngrese la cantidad de productos: ");
        cantidad= sc.nextInt();
        lista.add(new EncabezadoPedido(dia,mes,anio,nombreProveedor,telefono,estadoPedido,codigoProducto,nombreProducto,cantidad));
}
    public static void actualizarEstadoPedido(List<EncabezadoPedido> listaPedidos) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el código del pedido para actualizar su estado: ");
        int codigoPedido = sc.nextInt();

        EncabezadoPedido pedidoEncontrado = buscarPedidoPorCodigo(listaPedidos, codigoPedido);

        if (pedidoEncontrado != null) {
            // Mostrar información actual del pedido
            System.out.println("Estado actual del pedido #" + codigoPedido + ": " +
                    (pedidoEncontrado.estadoPedido() ? "Enviado" : "No enviado"));

            // Actualizar el estado del pedido
            pedidoEncontrado.actualizarEstadoEnviado(true);

            // Mostrar el nuevo estado del pedido
            System.out.println("Estado actualizado del pedido #" + codigoPedido + ": Enviado");
        } else {
            System.out.println("Pedido no encontrado");
        }
    }

}