import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        SistemaDeGestion sistema = descargarInfo();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        boolean revision = false;
        String usuarioLogIn = "";
        String contraseñaLogIn = "";
        String usuarioRegister = "";
        String contraseñaRegister = "";
        String nombreRegister = "";
        String gmailRegister = "";
        char seguirLogueado = 'n';
        int idProducto=0;
        String nombreTarjeta = "";
        int eleccionMetodoDePago = 0;
        TipoMetodoDePago tipoMetodoDePagoTarjeta = TipoMetodoDePago.Visa;
        String numeroTarjeta;
        int año;
        int mes;
        int dia;
        int cvv;
        double precioNuevo=0;
        int idAñadirAlCarrito = 0;

        Usuario usuarioActual = descargarUsuario();
        // Instanciar productos en el sistema
// CPUs
        sistema.agregarCpu(250000, "Intel", "i5-12400F", Socket.LGA1700, 6, 12, "No");
        sistema.agregarCpu(450000, "AMD", "Ryzen 7 5800X", Socket.AM4, 8, 16, "No");

// GPUs
        sistema.agregarGpu(550000, "NVIDIA", "RTX 3060", 12);
        sistema.agregarGpu(850000, "AMD", "RX 6800 XT", 16);

// MotherBoards
        sistema.agregarMotherBoard(180000, "ASUS", "TUF Gaming B660", Socket.LGA1700);
        sistema.agregarMotherBoard(220000, "MSI", "B550 Tomahawk", Socket.AM5);

// Almacenamiento
        sistema.agregarAlmacenamiento(80000, "Kingston", "A400 500GB", TipoAlmacenamiento.ssd, 500);
        sistema.agregarAlmacenamiento(120000, "Western Digital", "Black SN850", TipoAlmacenamiento.ssd, 1000);

// RAM
        sistema.agregarRam(65000, "Corsair", "Vengeance LPX 16GB", TipoMemoria.DDR4, 16);
        sistema.agregarRam(95000, "G.Skill", "Trident Z5 32GB", TipoMemoria.DDR5, 32);

// Refrigeración
        sistema.agregarRefrigeracion(45000, "Cooler Master", "Hyper 212", Socket.LGA1700, TipoRefrigeracion.RefrigeracionPorAire);
        sistema.agregarRefrigeracion(120000, "Corsair", "H100i", Socket.AM5, TipoRefrigeracion.RefrigeracionLiquida);

// Fuentes
        sistema.agregarFuente(95000, "EVGA", "650W Bronze", 650, Certificacion.plusbronze);
        sistema.agregarFuente(145000, "Corsair", "750W Gold", 750, Certificacion.plusgold);

// Gabinetes
        sistema.agregarGabinete(true, 85000, "NZXT", "H510 Elite");
        sistema.agregarGabinete(false, 55000, "Cooler Master", "MasterBox Q300L");

// Mouse
        ArrayList<Integer> dpiMouse1 = new ArrayList<>();
        dpiMouse1.add(800);
        dpiMouse1.add(1600);
        dpiMouse1.add(3200);
        sistema.agregarMouse(45000, "Logitech", "G502 Hero", "Negro", true, false, dpiMouse1);

        ArrayList<Integer> dpiMouse2 = new ArrayList<>();
        dpiMouse2.add(400);
        dpiMouse2.add(800);
        dpiMouse2.add(1600);
        dpiMouse2.add(3200);
        sistema.agregarMouse(85000, "Razer", "DeathAdder V2", "Negro", true, false, dpiMouse2);

// Teclados
        sistema.agregarTeclado(75000, "Corsair", "K70 RGB", "Negro", true, false, TipoTeclado.cienporciento, TipoMecanismo.switchesRed);
        sistema.agregarTeclado(95000, "HyperX", "Alloy FPS Pro", "Blanco", true, false, TipoTeclado.ochentaporciento, TipoMecanismo.switchesBlue);

// Auriculares
        sistema.agregarAuricular(55000, "HyperX", "Cloud II", "Rojo", false, false, "7.1 Surround", true);
        sistema.agregarAuricular(125000, "SteelSeries", "Arctis 7", "Negro", true, true, "DTS Headphone:X 2.0", true);

// Monitores
        sistema.agregarMonitor(180000, "LG", "27GL650F", "Negro", false, false, 27, "FHD", false, 144, 1);
        sistema.agregarMonitor(320000, "Samsung", "Odyssey G5", "Negro", true, false, 27, "QHD", true, 165, 1);

// MousePads
        sistema.agregarMousePad(15000, "Logitech", "G840", "Negro", false, false, "Tela", "XL");
        sistema.agregarMousePad(25000, "Razer", "Goliathus Extended", "Verde", true, false, "Tela", "XXL");


        do {
            if(usuarioActual.getTipoUsuario() == TipoUsuario.noLogueado){
                System.out.println("\nBienvenido al sistema de compras tecnologicas del grupo! espero tengas una buena estadia...");
                System.out.println("Por el momento no te encuentreas logueado, que desea hacer?");
                System.out.println("1- Loguearse");
                System.out.println("2- Registrarse");
                System.out.println("3- Ver Productos");
                System.out.println("0- Cerrar Programa");
                System.out.println("OPCION: ");
                try{
                    opcion = scanner.nextInt();
                    while(opcion < 0 || opcion >4){
                        System.out.println("Opcion invalida, ingrese nuevamente una opcion:");
                        opcion = scanner.nextInt();
                    }
                }catch (InputMismatchException e){
                    System.out.println("Ingrese un numero dentro del rango por favor!");
                    scanner.nextLine();
                    opcion = -1;
                }
                switch (opcion){
                    case 1:
                        scanner.nextLine();
                        System.out.println("Ingrese su usuario: ");
                        usuarioLogIn = scanner.nextLine();
                        System.out.println("Ingrese la contraseña: ");
                        contraseñaLogIn = scanner.nextLine();
                        try{
                            usuarioActual = sistema.hacerLogin(usuarioLogIn, contraseñaLogIn);
                        }catch (ExceptionUsuarioInvalido e){
                            System.out.println(e.getMessage());
                        }

                        if(usuarioActual.getTipoUsuario() != TipoUsuario.noLogueado){
                            System.out.println("Bienvenido "+usuarioActual.getUsuario());
                        }

                        break;

                    case 2:
                        scanner.nextLine();
                        System.out.println("Ingrese su nombre de usuario: ");
                        usuarioRegister = scanner.nextLine();
                        System.out.println("Ingrese su contraseña: ");
                        contraseñaRegister = scanner.nextLine();
                        System.out.println("Ingrese su nombre: ");
                        nombreRegister = scanner.nextLine();
                        System.out.println("Ingrese su gmail: ");
                        gmailRegister = scanner.nextLine();
                        if(gmailRegister.contains("@") && gmailRegister.contains(".com")){
                            revision = sistema.agregarUsuario(usuarioRegister, contraseñaRegister, nombreRegister, gmailRegister);
                            usuarioActual = sistema.actualizarUsuario(usuarioRegister);
                        }else{
                            System.out.println("El gmail no contiene @ o .com");
                        }

                        if(revision){
                            System.out.println("Usuario agregado correctamente, Bienvenido "+usuarioActual.getUsuario());
                        }else{
                            System.out.println("Error al intentar agregar un usuario");
                        }
                        break;

                    case 3:
                        System.out.println("PRODUCTOS: ");
                        System.out.println(sistema.verProductos());
                        break;
                }
            }
            if(usuarioActual.getTipoUsuario() == TipoUsuario.logueado){
                System.out.println("\nBienvenido "+usuarioActual.getUsuario()+" al sistema de compras tecnologicas del grupo! espero tengas una buena estadia...");
                System.out.println("1- Ver Productos");
                System.out.println("2- Añadir productos al carrito");
                System.out.println("3- Ver Carrito");
                System.out.println("4- Agregar Metodo de Pago");
                System.out.println("5- Realizar Compra");
                System.out.println("6- Cerrar sesion");
                System.out.println("0- Cerrar Programa");
                System.out.println("OPCION: ");
                try{
                    opcion = scanner.nextInt();
                    while(opcion < 0 || opcion >6){
                        System.out.println("Opcion invalida, ingrese nuevamente una opcion:");
                        opcion = scanner.nextInt();
                    }
                }catch (InputMismatchException e){
                    System.out.println("Ingrese un numero dentro del rango por favor!");
                    scanner.nextLine();
                    opcion = -1;
                }

                /// switch con las respectivas funciones
                switch (opcion){
                    case 1:
                        System.out.println("PRODUCTOS: ");
                        System.out.println(sistema.verProductos());
                        break;

                    case 2:
                        System.out.println("PRODUCTOS: ");
                        System.out.println(sistema.verProductos());
                        scanner.nextLine();
                        System.out.println("Ingrese el id del producto a agregar: ");
                        idAñadirAlCarrito = scanner.nextInt();
                        revision = sistema.agregarProductoAlCarrito(idAñadirAlCarrito, usuarioActual.getNombre());
                        if(revision){
                            System.out.println("Producto añadido correctamente");
                        }else{
                            System.out.println("Error al añadir producto");
                        }
                        break;
                    case 3:
                        System.out.println(sistema.mostrarCarrito(usuarioActual.getNombre()));
                        break;
                    case 4:
                        scanner.nextLine();
                        System.out.println("1-Visa, 2-Mastercard: ");
                        eleccionMetodoDePago = scanner.nextInt();
                        while(eleccionMetodoDePago>2 || eleccionMetodoDePago<1){
                            System.out.println("Ingrese un metodo de pago valido: ");
                            eleccionMetodoDePago = scanner.nextInt();
                        }
                        if(eleccionMetodoDePago == 1){
                            tipoMetodoDePagoTarjeta = TipoMetodoDePago.Visa;
                        }
                        if(eleccionMetodoDePago == 2){
                            tipoMetodoDePagoTarjeta = TipoMetodoDePago.Mastercard;
                        }
                        scanner.nextLine();
                        System.out.println("Ingrese el numero de la tarjeta: ");
                        numeroTarjeta = scanner.nextLine();
                        while(numeroTarjeta.length() != 16){
                            System.out.println("Ingrese un formato valido: ");
                            numeroTarjeta = scanner.nextLine();
                        }
                        System.out.println("Año caducidad: ");
                        año = scanner.nextInt();
                            while(año<2025){
                                System.out.println("Ingrese un formato valido: ");
                                año = scanner.nextInt();
                            }
                        System.out.println("Mes caducidad: ");
                        mes = scanner.nextInt();
                        while(mes > 12 || mes <1){
                            System.out.println("Ingrese un formato valido: ");
                            mes = scanner.nextInt();
                        }
                        System.out.println("Dia caducidad: ");
                        dia = scanner.nextInt();
                        while(dia<1 || dia>31){
                            System.out.println("Ingrese un formato valido: ");
                            dia = scanner.nextInt();
                        }
                        System.out.println("Ingrese el cvv: ");
                        cvv = scanner.nextInt();
                        String cvvString = String.valueOf(cvv);
                        while(cvvString.length() != 3){
                            System.out.println("Ingrese un formato de cvv correcto: ");
                            cvv = scanner.nextInt();
                            cvvString = String.valueOf(cvv);
                        }
                        String nombre = usuarioActual.getNombre();
                        revision = sistema.agregarMetodoDePago(nombre, tipoMetodoDePagoTarjeta, numeroTarjeta, año, mes, dia, cvv);
                        if(revision){
                            System.out.println("Tarjeta añadida corectamente!");
                        }else{
                            System.out.println("Error al intentar agregar la tarjeta");
                        }
                        break;
                    case 5:
                        sistema.mostrarCarrito(usuarioActual.getUsuario());
                        System.out.println("Confirma la compra? S/N");
                        String rta = scanner.nextLine();
                        if(rta.equalsIgnoreCase("S")){
                            sistema.getTicket();
                            usuarioActual.vaciarCarrito();
                            break;
                        }else{
                            break;
                        }
                    case 6:
                        usuarioActual = new Usuario();
                        break;
                }
            }
            if(usuarioActual.getTipoUsuario() == TipoUsuario.vip){
                System.out.println("\nBienvenido "+usuarioActual.getUsuario()+" al sistema de compras tecnologicas del grupo! espero tengas una buena estadia...");
                System.out.println("1- Ver Productos");
                System.out.println("2- Añadir productos al carrito");
                System.out.println("3- Ver Carrito");
                System.out.println("4- Agregar Metodo de Pago");
                System.out.println("5- Realizar Compra");
                System.out.println("6- Cerrar sesion");
                System.out.println("0- Cerrar Programa");
                System.out.println("OPCION: ");
                try{
                    opcion = scanner.nextInt();
                    while(opcion < 0 || opcion >6){
                        System.out.println("Opcion invalida, ingrese nuevamente una opcion:");
                        opcion = scanner.nextInt();
                    }
                }catch (InputMismatchException e){
                    System.out.println("Ingrese un numero dentro del rango por favor!");
                    scanner.nextLine();
                    opcion = -1;
                }

                /// switch con las respectivas funciones
                switch (opcion){
                    case 1:
                        System.out.println("PRODUCTOS: ");
                        System.out.println(sistema.verProductos());
                        break;
                    case 5:
                        sistema.mostrarCarrito(usuarioActual.getNombre());
                        String rta;
                        System.out.println("Confirma la compra? S/N");
                        rta = scanner.nextLine();
                        if(rta.equalsIgnoreCase("S")){
                            sistema.getTicket();
                            usuarioActual.vaciarCarrito();
                            break;
                        }else{
                            break;
                        }
                    case 6:
                        usuarioActual = new Usuario();
                        break;
                }
            }
            if(usuarioActual.getTipoUsuario() == TipoUsuario.administrador){
                System.out.println("\nBienvenido "+usuarioActual.getUsuario()+" al sistema de compras tecnologicas del grupo!");
                System.out.println("1- Ver Productos");
                System.out.println("2- Ver Carrito");
                System.out.println("3- Agregar Metodo de Pago");
                System.out.println("4- Realizar Compra");
                System.out.println("5- Agreagar productos");
                System.out.println("6- Eliminar productos");
                System.out.println("7- Modificar precio");
                System.out.println("8- Cerrar sesion");
                System.out.println("0- Cerrar Programa");
                System.out.println("OPCION: ");
                try{
                    opcion = scanner.nextInt();
                    while(opcion < 0 || opcion >8){
                        System.out.println("Opcion invalida, ingrese nuevamente una opcion:");
                        opcion = scanner.nextInt();
                    }
                }catch (InputMismatchException e){
                    System.out.println("Ingrese un numero dentro del rango por favor!");
                    scanner.nextLine();
                    opcion = -1;
                }

                /// switch con las respectivas funciones
            switch (opcion){
                case 1:
                    System.out.println("PRODUCTOS: ");
                    System.out.println(sistema.verProductos());
                    break;
                case 5:
                    sistema.mostrarCarrito(usuarioActual.getNombre());
                    String rta;
                    System.out.println("Confirma la compra? S/N");
                    rta = scanner.nextLine();
                    if(rta.equalsIgnoreCase("S")){
                        sistema.getTicket();
                        usuarioActual.vaciarCarrito();
                        break;
                    }else{
                        break;
                    }
                case 6:
                    System.out.println("ingrese el id a eliminar: ");
                    idProducto=scanner.nextInt();
                    revision = sistema.eliminarProducto(idProducto);
                    if(revision){
                        System.out.println("Producto eliminado correctamente");
                    }else{
                        System.out.println("Error al eliminar producto");
                    }
                    break;
                case 7:
                    idProducto=-1;
                    try {
                        System.out.println("ingrese el id a modificar: ");
                        idProducto=scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("completar el campo con numero");
                    }

                    try {
                        System.out.println("ingrese el precio nuevo");
                        precioNuevo=scanner.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("completar el campo con numero");
                    }
                    revision = sistema.modificarPrecio(precioNuevo,idProducto);
                    if(revision){
                        System.out.println("precio modificado correctamente");
                    }else{
                        System.out.println("producto no encontrado");
                    }
                case 8:
                    usuarioActual = new Usuario();
                    break;
            }
            }

        }while(opcion != 0);

        scanner.nextLine();
        if(usuarioActual.getTipoUsuario() != TipoUsuario.noLogueado){
            System.out.println("Desea mantener la sesion iniciada al volver a nuestro programa? (s/n): ");
            seguirLogueado = scanner.nextLine().charAt(0);
            if(seguirLogueado == 's'){
                guardarUsuario(usuarioActual.toJSON());
            }
        }else{
            guardarUsuario(usuarioActual.toJSON());
        }

        sistema.agregarUsuarioManualmente("Juan2020", "s34u5h3iu4h5ui3h6u3yh56h3yh5u", "Juan", "juanBussines@gmail.com", TipoUsuario.administrador);
        sistema.agregarUsuarioManualmente("ayeeGamer", "hg6gu3y5g6yu35g63uy5464iu64", "Aye", "aye777@gmail.com", TipoUsuario.vip);


        System.out.println("Gracias por su estadia, que tengas un buen dia!");
        guardarInfo(sistema.toJSON());
    }

    public static void guardarInfo(JSONArray info){
        JSONUtiles.uploadJson(info);
    }

    public static void guardarUsuario(JSONObject usuario){
        JSONUtiles.uploadJson(usuario);
    }

    public static SistemaDeGestion descargarInfo(){
        SistemaDeGestion sistema;
        try{
            JSONArray lista = new JSONArray(JSONUtiles.downloadJSON());
            sistema = new SistemaDeGestion(lista);
        }catch(JSONException e){
            sistema = new SistemaDeGestion();
            System.out.println("Error, intenta nuevamente");
        }

        return sistema;
    }

    public static Usuario descargarUsuario(){
        Usuario usuario;
        try{
            JSONObject obj = new JSONObject(JSONUtiles.downloadJSONUsuario());
            usuario = new Usuario (obj);
        }catch(JSONException e){
            usuario = new Usuario();
        }

        return usuario;
    }
}