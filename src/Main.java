import Clases.Combos;
import Clases.Producto;
import Clases.Ticket;
import Clases.Usuario;
import Enums.*;
import Exceptions.ExceptionCarritoIsNULL;
import Exceptions.ExceptionMetodoDePagoNotFound;
import Exceptions.ExceptionUsuarioInvalido;
import Exceptions.FaltaStockEx;
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

        //DECLARACIONES DE VARIABLES
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
        int opcionAgregar=0;
        double precio=0;
        String marca="";
        String modelo="";
        int tipoAlmacenamientoo=0;
        int gb=0;
        TipoAlmacenamiento almacenamientoo=TipoAlmacenamiento.ssd;
        int memoria = 0;
        Socket socketCpu = Socket.LGA1700;
        int nucleos = 0;
        int hilos = 0;
        String integrados = "";
        Socket socketMother = Socket.LGA1700;
        TipoMemoria tipoMemoria = TipoMemoria.DDR4;
        Socket socketRefri = Socket.LGA1700;
        TipoRefrigeracion tipoRefri = TipoRefrigeracion.RefrigeracionPorAire;
        int watts = 0;
        Certificacion certificacion = Certificacion.plusbronze;
        boolean rgb = false;
        ArrayList<Integer> dpiList = new ArrayList<>();
        int dpiValue = 0;
        int stock=0;
        int cantidadDpi = 0;
        TipoTeclado tipoTeclado = TipoTeclado.cienporciento;
        TipoMecanismo tipoMecanismo = TipoMecanismo.switchesRed;
        String color = "";
        boolean inalambrico = false;
        String audio = "";
        boolean microfono = false;
        double pulgadas = 0;
        String calidadPantalla = "";
        boolean curvo = false;
        int frecuencia = 0;
        int tiempoRespuesta = 0;
        String tipoSuperficie = "";
        String tamanio = "";
        int eleccion = 0;
        Usuario usuarioActual = descargarUsuario();

        //AGREGADO DE PROPDUCTOS
        sistema.agregarCpu(20,250000, "Intel", "i5-12400F", Socket.LGA1700, 6, 12, "No");
        sistema.agregarCpu(5,450000, "AMD", "Ryzen 7 5800X", Socket.AM4, 8, 16, "No");
        sistema.agregarGpu(3,550000, "NVIDIA", "RTX 3060", 12);
        sistema.agregarGpu(10,850000, "AMD", "RX 6800 XT", 16);
        sistema.agregarMotherBoard(25,180000, "ASUS", "TUF Gaming B660", Socket.LGA1700);
        sistema.agregarMotherBoard(30,220000, "MSI", "B550 Tomahawk", Socket.AM5);
        sistema.agregarAlmacenamiento(2,80000, "Kingston", "A400 500GB", TipoAlmacenamiento.ssd, 500);
        sistema.agregarAlmacenamiento(12,120000, "Western Digital", "Black SN850", TipoAlmacenamiento.ssd, 1000);
        sistema.agregarRam(1,65000, "Corsair", "Vengeance LPX 16GB", TipoMemoria.DDR4, 16);
        sistema.agregarRam(10,95000, "G.Skill", "Trident Z5 32GB", TipoMemoria.DDR5, 32);
        sistema.agregarRefrigeracion(15,45000, "Cooler Master", "Hyper 212", Socket.LGA1700, TipoRefrigeracion.RefrigeracionPorAire);
        sistema.agregarRefrigeracion(35,120000, "Corsair", "H100i", Socket.AM5, TipoRefrigeracion.RefrigeracionLiquida);
        sistema.agregarFuente(50,95000, "EVGA", "650W Bronze", 650, Certificacion.plusbronze);
        sistema.agregarFuente(10,145000, "Corsair", "750W Gold", 750, Certificacion.plusgold);
        sistema.agregarGabinete(4,true, 85000, "NZXT", "H510 Elite");
        sistema.agregarGabinete(5,false, 55000, "Cooler Master", "MasterBox Q300L");
        ArrayList<Integer> dpiMouse1 = new ArrayList<>();
        dpiMouse1.add(800);
        dpiMouse1.add(1600);
        dpiMouse1.add(3200);
        sistema.agregarMouse(3,45000, "Logitech", "G502 Hero", "Negro", true, false, dpiMouse1);
        ArrayList<Integer> dpiMouse2 = new ArrayList<>();
        dpiMouse2.add(400);
        dpiMouse2.add(800);
        dpiMouse2.add(1600);
        dpiMouse2.add(3200);
        sistema.agregarMouse(10,85000, "Razer", "DeathAdder V2", "Negro", true, false, dpiMouse2);
        sistema.agregarTeclado(1,75000, "Corsair", "K70 RGB", "Negro", true, false, TipoTeclado.cienporciento, TipoMecanismo.switchesRed);
        sistema.agregarTeclado(2,95000, "HyperX", "Alloy FPS Pro", "Blanco", true, false, TipoTeclado.ochentaporciento, TipoMecanismo.switchesBlue);
        sistema.agregarAuricular(6,55000, "HyperX", "Cloud II", "Rojo", false, false, "7.1 Surround", true);
        sistema.agregarAuricular(8,125000, "SteelSeries", "Arctis 7", "Negro", true, true, "DTS Headphone:X 2.0", true);
        sistema.agregarMonitor(12,180000, "LG", "27GL650F", "Negro", false, false, 27, "FHD", false, 144, 1);
        sistema.agregarMonitor(15,320000, "Samsung", "Odyssey G5", "Negro", true, false, 27, "QHD", true, 165, 1);
        sistema.agregarMousePad(18,15000, "Logitech", "G840", "Negro", false, false, "Tela", "XL");
        sistema.agregarMousePad(20,25000, "Razer", "Goliathus Extended", "Verde", true, false, "Tela", "XXL");
        sistema.agregarComputadoraEscritorio(2,1000000, "Custom Build", "Gaming Pro", 350000, "Intel", "i7-12700K", Socket.LGA1700, 12, 20, "Si", 750000, "NVIDIA", "RTX 4070", 12, 200000, "ASUS", "ROG STRIX Z690", Socket.LGA1700, 150000, "Samsung", "980 PRO 1TB", TipoAlmacenamiento.ssd, 1000, 120000, "Corsair", "Vengeance RGB 32GB", TipoMemoria.DDR5, 32, 80000, "NZXT", "Kraken X63", Socket.LGA1700, TipoRefrigeracion.RefrigeracionLiquida, 180000, "Corsair", "RM850x", 850, Certificacion.plusgold, true, 120000, "Corsair", "4000D Airflow");
        sistema.agregarNotebook(5,1000000, "Lenovo", "Legion 5 Pro", 300000, "AMD", "Ryzen 7 6800H", Socket.AM4, 8, 16, "Si", 100000, "NVIDIA", "RTX 3070 Ti", 8, 50000, "Kingston", "NV2 1TB", TipoAlmacenamiento.ssd, 1000, 50000, "Samsung", "DDR5 16GB", TipoMemoria.DDR5, 16, 80, "QHD 165Hz", 16.0, 500000, "Lenovo", "Integrated", Socket.AM4);

        Combos<Producto> comboGamer = new Combos<>(3,0, "Custom", "Kit Gamer RGB");
        comboGamer.agregarCombo(sistema.buscarProductoPorId(16));
        comboGamer.agregarCombo(sistema.buscarProductoPorId(18));
        comboGamer.agregarCombo(sistema.buscarProductoPorId(20));
        comboGamer.agregarCombo(sistema.buscarProductoPorId(22));
        comboGamer.agregarCombo(sistema.buscarProductoPorId(24));
        sistema.agregarCombo(comboGamer);

        //SISTEMA
        do {
            if(usuarioActual.getTipoUsuario() == TipoUsuario.noLogueado){ //SISTEMA USUARIO NO LOGUEADO
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
                        System.out.println("Ingrese su nombre de usario: ");
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
            if(usuarioActual.getTipoUsuario() == TipoUsuario.logueado){ //SISTEMA USUSARIO LOGUEADO
                System.out.println("\nBienvenido "+usuarioActual.getUsuario()+" al sistema de compras tecnologicas del grupo! espero tengas una buena estadia...");
                System.out.println("1- Ver Productos");
                System.out.println("2- Añadir Productos Al Carrito");
                System.out.println("3- Ver Carrito");
                System.out.println("4- Agregar Metodo De Pago");
                System.out.println("5- Realizar Compra");
                System.out.println("6- Cerrar Sesion");
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
                        try {
                            revision = sistema.agregarProductoAlCarrito(idAñadirAlCarrito, usuarioActual.getNombre());
                        } catch (FaltaStockEx e) {
                            System.out.println(e.getMessage());
                        }
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
                        try{
                            Ticket ticket = sistema.realizarCompra(usuarioActual.getNombre());

                            usuarioActual = sistema.actualizarUsuario(usuarioActual.getUsuario());

                            guardarTickets(sistema.ticketsToJSON());

                            System.out.println("\n===== TICKET DE COMPRA =====");
                            System.out.println("Ticket ID: "+ ticket.getId());
                            System.out.println("Fecha: " + ticket.getFecha());
                            System.out.println("Cliente: " + ticket.getNombreUsuario());
                            System.out.println("\nProductos:");
                            System.out.println(ticket.mostrarProductos());
                            System.out.println("Precio Total: $" + ticket.getPrecioTotal());
                            System.out.println("============================\n");
                            System.out.println("¡Compra realizada con éxito!");

                        }catch (ExceptionCarritoIsNULL e){
                            System.out.println(e.getMessage());
                        }catch (ExceptionMetodoDePagoNotFound f){
                            System.out.println(f.getMessage());
                        }
                        break;

                    case 6:
                        usuarioActual = new Usuario();
                        break;
                }
            }
            if(usuarioActual.getTipoUsuario() == TipoUsuario.vip){ //SISTEMA DE USUARIO VIP
                System.out.println("\nBienvenido "+usuarioActual.getUsuario()+" al sistema de compras tecnologicas del grupo! espero tengas una buena estadia...");
                System.out.println("1- Ver Productos");
                System.out.println("2- Añadir Productos Al Carrito");
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
                        try {
                            revision = sistema.agregarProductoAlCarrito(idAñadirAlCarrito, usuarioActual.getNombre());
                        } catch (FaltaStockEx e) {
                            System.out.println(e.getMessage());
                        }
                        if(revision){
                            System.out.println("Clases.Producto añadido correctamente");
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
                        try{
                            Ticket ticket = sistema.realizarCompra(usuarioActual.getNombre());

                            usuarioActual = sistema.actualizarUsuario(usuarioActual.getUsuario());

                            guardarTickets(sistema.ticketsToJSON());

                            System.out.println("\n===== TICKET DE COMPRA =====");
                            System.out.println("Ticket ID: "+ ticket.getId());
                            System.out.println("Fecha: " + ticket.getFecha());
                            System.out.println("Cliente: " + ticket.getNombreUsuario());
                            System.out.println("\nProductos:");
                            System.out.println(ticket.mostrarProductos());
                            System.out.println("Precio Total: $" + ticket.getPrecioTotal());
                            System.out.println("============================\n");
                            System.out.println("¡Compra realizada con éxito!");

                        }catch (ExceptionCarritoIsNULL e){
                            System.out.println(e.getMessage());
                        }catch (ExceptionMetodoDePagoNotFound f){
                            System.out.println(f.getMessage());
                        }
                        break;
                    case 6:
                        usuarioActual = new Usuario();
                        break;
                }
            }
            if(usuarioActual.getTipoUsuario() == TipoUsuario.administrador){ //SISTEMA DE USUARIO ADMIN
                System.out.println("\nBienvenido "+usuarioActual.getUsuario()+" al sistema de compras tecnologicas del grupo!");
                System.out.println("1- Ver Productos");
                System.out.println("2- Agreagar productos");
                System.out.println("3- Eliminar productos");
                System.out.println("4- Modificar precio");
                System.out.println("5- Revisar Costos");
                System.out.println("6- Cerrar sesion");
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
                    case 2:
                        System.out.println("Que quieres agregar?");
                        System.out.println("1-Almacenamiento");
                        System.out.println("2-GPU");
                        System.out.println("3-CPU");
                        System.out.println("4-MotherBoard");
                        System.out.println("5-Ram");
                        System.out.println("6-Refrigeracion");
                        System.out.println("7-Fuente");
                        System.out.println("8-Gabinete");
                        System.out.println("9-Mouse");
                        System.out.println("10-Teclado");
                        System.out.println("11-Auricular");
                        System.out.println("12-Monitor");
                        System.out.println("13-MousePad");
                        try {
                            opcionAgregar=scanner.nextInt();
                            while ((opcionAgregar<0)||(opcionAgregar>14)){
                                System.out.println("ingresa un numero valido: ");
                                opcionAgregar=scanner.nextInt();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("ingrese un numero");
                        }

                        switch (opcionAgregar){
                            case 1:
                                System.out.println("ingrese el precio: ");
                                precio=scanner.nextDouble();
                                System.out.println("ingrese la marca: ");
                                marca=scanner.nextLine();
                                System.out.println("ingrese el modelo: ");
                                modelo=scanner.nextLine();
                                System.out.println("Tipo de almacenamiento 1-hdd 2-ssd");
                                tipoAlmacenamientoo=scanner.nextInt();
                                while((tipoAlmacenamientoo<0)||(tipoAlmacenamientoo>2)){
                                    System.out.println("Incorrecto 1-hdd 2-ssd");
                                    tipoAlmacenamientoo=scanner.nextInt();
                                }
                                if(tipoAlmacenamientoo==1){
                                    almacenamientoo=TipoAlmacenamiento.hdd;
                                }else{
                                    almacenamientoo=TipoAlmacenamiento.ssd;
                                }
                                System.out.println("ingrese los gb (mayor a 120, menor a 1.000: ");
                                gb=scanner.nextInt();
                                while((gb<120)||(gb>1000)){
                                    System.out.println("incorrecto, gb (mayor a 120, menor a 1.000: ");
                                    gb=scanner.nextInt();
                                }
                                System.out.println("ingrese el stock");
                                stock=scanner.nextInt();
                                while(stock<=0){
                                    System.out.println("incorrecte, ingrese un numero mayor a 0");
                                    stock=scanner.nextInt();
                                }

                                revision= sistema.agregarAlmacenamiento(stock,precio,marca,modelo,almacenamientoo,gb);
                                if(revision){
                                    System.out.println("agregado correctamente");
                                }else {
                                    System.out.println("error al crear");
                                }
                                break;
                            case 2:
                                scanner.nextLine();
                                System.out.println("Ingrese el precio: ");
                                precio = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println("Ingrese la marca: ");
                                marca = scanner.nextLine();
                                System.out.println("Ingrese el modelo: ");
                                modelo = scanner.nextLine();
                                System.out.println("Ingrese la memoria en GB (entre 4 y 24): ");
                                memoria = scanner.nextInt();
                                while((memoria < 4) || (memoria > 24)){
                                    System.out.println("Incorrecto, ingrese memoria entre 4 y 24 GB: ");
                                    memoria = scanner.nextInt();
                                }
                                System.out.println("ingrese el stock");
                                stock=scanner.nextInt();
                                while(stock<=0){
                                    System.out.println("incorrecte, ingrese un numero mayor a 0");
                                    stock=scanner.nextInt();
                                }
                                revision= sistema.agregarGpu(stock,precio, marca, modelo, memoria);
                                if(revision){
                                    System.out.println("agregado correctamente");
                                }else {
                                    System.out.println("error al crear");
                                }
                                break;

                            case 3:
                                scanner.nextLine();
                                System.out.println("Ingrese el precio: ");
                                precio = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println("Ingrese la marca: ");
                                marca = scanner.nextLine();
                                System.out.println("Ingrese el modelo: ");
                                modelo = scanner.nextLine();
                                System.out.println("Tipo de socket 1-LGA1700 2-AM4 3-AM5");
                                eleccion = scanner.nextInt();
                                while((eleccion < 1) || (eleccion > 3)){
                                    System.out.println("Incorrecto, 1-LGA1700 2-AM4 3-AM5");
                                    eleccion = scanner.nextInt();
                                }
                                if(eleccion == 1){
                                    socketCpu = Socket.LGA1700;
                                }else if(eleccion == 2){
                                    socketCpu = Socket.AM4;
                                }else{
                                    socketCpu = Socket.AM5;
                                }
                                System.out.println("Ingrese cantidad de nucleos (entre 2 y 32): ");
                                nucleos = scanner.nextInt();
                                while((nucleos < 2) || (nucleos > 32)){
                                    System.out.println("Incorrecto, ingrese entre 2 y 32 nucleos: ");
                                    nucleos = scanner.nextInt();
                                }
                                System.out.println("Ingrese cantidad de hilos (entre 2 y 64): ");
                                hilos = scanner.nextInt();
                                while((hilos < 2) || (hilos > 64)){
                                    System.out.println("Incorrecto, ingrese entre 2 y 64 hilos: ");
                                    hilos = scanner.nextInt();
                                }
                                scanner.nextLine();
                                System.out.println("Tiene graficos integrados? (Si/No): ");
                                integrados = scanner.nextLine();
                                while(!integrados.equalsIgnoreCase("Si") && !integrados.equalsIgnoreCase("No")){
                                    System.out.println("Incorrecto, responda Si o No: ");
                                    integrados = scanner.nextLine();
                                }
                                System.out.println("ingrese el stock");
                                stock=scanner.nextInt();
                                while(stock<0){
                                    System.out.println("incorrecte, ingrese un numero mayor a 0");
                                    stock=scanner.nextInt();
                                }
                                revision =sistema.agregarCpu(stock,precio, marca, modelo, socketCpu, nucleos, hilos, integrados);
                                if(revision){
                                    System.out.println("agregado correctamente");
                                }else {
                                    System.out.println("error al crear");
                                }
                                break;

                            case 4:
                                scanner.nextLine();
                                System.out.println("Ingrese el precio: ");
                                precio = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println("Ingrese la marca: ");
                                marca = scanner.nextLine();
                                System.out.println("Ingrese el modelo: ");
                                modelo = scanner.nextLine();
                                System.out.println("Tipo de socket 1-LGA1700 2-AM4 3-AM5");
                                eleccion = scanner.nextInt();
                                while((eleccion < 1) || (eleccion > 3)){
                                    System.out.println("Incorrecto, 1-LGA1700 2-AM4 3-AM5");
                                    eleccion = scanner.nextInt();
                                }
                                if(eleccion == 1){
                                    socketMother = Socket.LGA1700;
                                }else if(eleccion == 2){
                                    socketMother = Socket.AM4;
                                }else{
                                    socketMother = Socket.AM5;
                                }
                                System.out.println("ingrese el stock");
                                stock=scanner.nextInt();
                                while(stock<=0){
                                    System.out.println("incorrecte, ingrese un numero mayor a 0");
                                    stock=scanner.nextInt();
                                }
                                revision = sistema.agregarMotherBoard(stock,precio, marca, modelo, socketMother);
                                if(revision){
                                    System.out.println("agregado correctamente");
                                }else {
                                    System.out.println("error al crear");
                                }
                                break;

                            case 5:
                                scanner.nextLine();
                                System.out.println("Ingrese el precio: ");
                                precio = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println("Ingrese la marca: ");
                                marca = scanner.nextLine();
                                System.out.println("Ingrese el modelo: ");
                                modelo = scanner.nextLine();
                                System.out.println("Tipo de memoria 1-DDR4 2-DDR5");
                                eleccion = scanner.nextInt();
                                while((eleccion < 1) || (eleccion > 2)){
                                    System.out.println("Incorrecto, 1-DDR4 2-DDR5");
                                    eleccion = scanner.nextInt();
                                }
                                if(eleccion == 1){
                                    tipoMemoria = TipoMemoria.DDR4;
                                }else{
                                    tipoMemoria = TipoMemoria.DDR5;
                                }
                                System.out.println("Ingrese los GB (8, 16, 32 o 64): ");
                                gb = scanner.nextInt();
                                while(gb != 8 && gb != 16 && gb != 32 && gb != 64){
                                    System.out.println("Incorrecto, ingrese 8, 16, 32 o 64 GB: ");
                                    gb = scanner.nextInt();
                                }
                                System.out.println("ingrese el stock");
                                stock=scanner.nextInt();
                                while(stock<=0){
                                    System.out.println("incorrecte, ingrese un numero mayor a 0");
                                    stock=scanner.nextInt();
                                }
                                revision= sistema.agregarRam(stock,precio, marca, modelo, tipoMemoria, gb);
                                if(revision){
                                    System.out.println("agregado correctamente");
                                }else {
                                    System.out.println("error al crear");
                                }
                                break;

                            case 6:
                                scanner.nextLine();
                                System.out.println("Ingrese el precio: ");
                                precio = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println("Ingrese la marca: ");
                                marca = scanner.nextLine();
                                System.out.println("Ingrese el modelo: ");
                                modelo = scanner.nextLine();
                                System.out.println("Tipo de socket 1-LGA1700 2-AM4 3-AM5");
                                eleccion = scanner.nextInt();
                                while((eleccion < 1) || (eleccion > 3)){
                                    System.out.println("Incorrecto, 1-LGA1700 2-AM4 3-AM5");
                                    eleccion = scanner.nextInt();
                                }
                                if(eleccion == 1){
                                    socketRefri = Socket.LGA1700;
                                }else if(eleccion == 2){
                                    socketRefri = Socket.AM4;
                                }else{
                                    socketRefri = Socket.AM5;
                                }
                                System.out.println("Tipo de refrigeracion 1-Por Aire 2-Liquida");
                                eleccion = scanner.nextInt();
                                while((eleccion < 1) || (eleccion > 2)){
                                    System.out.println("Incorrecto, 1-Por Aire 2-Liquida");
                                    eleccion = scanner.nextInt();
                                }
                                if(eleccion == 1){
                                    tipoRefri = TipoRefrigeracion.RefrigeracionPorAire;
                                }else{
                                    tipoRefri = TipoRefrigeracion.RefrigeracionLiquida;
                                }
                                System.out.println("ingrese el stock");
                                stock=scanner.nextInt();
                                while(stock<=0){
                                    System.out.println("incorrecte, ingrese un numero mayor a 0");
                                    stock=scanner.nextInt();
                                }
                                revision= sistema.agregarRefrigeracion(stock,precio, marca, modelo, socketRefri, tipoRefri);
                                if(revision){
                                    System.out.println("agregado correctamente");
                                }else {
                                    System.out.println("error al crear");
                                }
                                break;

                            case 7:
                                scanner.nextLine();
                                System.out.println("Ingrese el precio: ");
                                precio = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println("Ingrese la marca: ");
                                marca = scanner.nextLine();
                                System.out.println("Ingrese el modelo: ");
                                modelo = scanner.nextLine();
                                System.out.println("Ingrese los Watts (entre 400 y 1200): ");
                                watts = scanner.nextInt();
                                while((watts < 400) || (watts > 1200)){
                                    System.out.println("Incorrecto, ingrese entre 400 y 1200 Watts: ");
                                    watts = scanner.nextInt();
                                }
                                System.out.println("Enums.Certificacion 1-Plus Bronze 2-Plus Gold 3-Plus Platinum");
                                eleccion = scanner.nextInt();
                                while((eleccion < 1) || (eleccion > 3)){
                                    System.out.println("Incorrecto, 1-Plus Bronze 2-Plus Gold 3-Plus Platinum");
                                    eleccion = scanner.nextInt();
                                }
                                if(eleccion == 1){
                                    certificacion = Certificacion.plusbronze;
                                }else if(eleccion == 2){
                                    certificacion = Certificacion.plusgold;
                                }else{
                                    certificacion = Certificacion.plusplatinum;
                                }
                                System.out.println("ingrese el stock");
                                stock=scanner.nextInt();
                                while(stock<=0){
                                    System.out.println("incorrecte, ingrese un numero mayor a 0");
                                    stock=scanner.nextInt();
                                }
                                revision =sistema.agregarFuente(stock,precio, marca, modelo, watts, certificacion);
                                if(revision){
                                    System.out.println("agregado correctamente");
                                }else {
                                    System.out.println("error al crear");
                                }

                                break;

                            case 8:
                                scanner.nextLine();
                                System.out.println("Tiene RGB? 1-Si 2-No");
                                eleccion = scanner.nextInt();
                                while((eleccion < 1) || (eleccion > 2)){
                                    System.out.println("Incorrecto, 1-Si 2-No");
                                    eleccion = scanner.nextInt();
                                }
                                rgb = (eleccion == 1);
                                System.out.println("Ingrese el precio: ");
                                precio = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println("Ingrese la marca: ");
                                marca = scanner.nextLine();
                                System.out.println("Ingrese el modelo: ");
                                modelo = scanner.nextLine();
                                System.out.println("ingrese el stock");
                                stock=scanner.nextInt();
                                while(stock<=0){
                                    System.out.println("incorrecte, ingrese un numero mayor a 0");
                                    stock=scanner.nextInt();
                                }
                                revision =sistema.agregarGabinete(stock,rgb, precio, marca, modelo);
                                if(revision){
                                    System.out.println("agregado correctamente");
                                }else {
                                    System.out.println("error al crear");
                                }

                                break;

                            case 9:
                                scanner.nextLine();
                                System.out.println("Ingrese el precio: ");
                                precio = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println("Ingrese la marca: ");
                                marca = scanner.nextLine();
                                System.out.println("Ingrese el modelo: ");
                                modelo = scanner.nextLine();
                                System.out.println("Ingrese el color: ");
                                color = scanner.nextLine();
                                System.out.println("Tiene RGB? 1-Si 2-No");
                                eleccion = scanner.nextInt();
                                while((eleccion < 1) || (eleccion > 2)){
                                    System.out.println("Incorrecto, 1-Si 2-No");
                                    eleccion = scanner.nextInt();
                                }
                                rgb = (eleccion == 1);
                                System.out.println("Es inalambrico? 1-Si 2-No");
                                eleccion = scanner.nextInt();
                                while((eleccion < 1) || (eleccion > 2)){
                                    System.out.println("Incorrecto, 1-Si 2-No");
                                    eleccion = scanner.nextInt();
                                }
                                inalambrico = (eleccion == 1);
                                dpiList = new ArrayList<>();
                                System.out.println("Cuantos niveles de DPI tiene? (entre 1 y 6): ");
                                cantidadDpi = scanner.nextInt();
                                while((cantidadDpi < 1) || (cantidadDpi > 6)){
                                    System.out.println("Incorrecto, ingrese entre 1 y 6 niveles: ");
                                    cantidadDpi = scanner.nextInt();
                                }
                                for(int i = 0; i < cantidadDpi; i++){
                                    System.out.println("Ingrese DPI nivel " + (i+1) + ": ");
                                    dpiValue = scanner.nextInt();
                                    while(dpiValue < 100 || dpiValue > 30000){
                                        System.out.println("Incorrecto, ingrese un DPI entre 100 y 30000: ");
                                        dpiValue = scanner.nextInt();
                                    }
                                    dpiList.add(dpiValue);
                                }
                                System.out.println("ingrese el stock");
                                stock=scanner.nextInt();
                                while(stock<=0){
                                    System.out.println("incorrecte, ingrese un numero mayor a 0");
                                    stock=scanner.nextInt();
                                }
                                revision = sistema.agregarMouse(stock,precio, marca, modelo, color, rgb, inalambrico, dpiList);
                                if(revision){
                                    System.out.println("agregado correctamente");
                                }else {
                                    System.out.println("error al crear");
                                }
                                break;

                            case 10:
                                scanner.nextLine();
                                System.out.println("Ingrese el precio: ");
                                precio = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println("Ingrese la marca: ");
                                marca = scanner.nextLine();
                                System.out.println("Ingrese el modelo: ");
                                modelo = scanner.nextLine();
                                System.out.println("Ingrese el color: ");
                                color = scanner.nextLine();
                                System.out.println("Tiene RGB? 1-Si 2-No");
                                eleccion = scanner.nextInt();
                                while((eleccion < 1) || (eleccion > 2)){
                                    System.out.println("Incorrecto, 1-Si 2-No");
                                    eleccion = scanner.nextInt();
                                }
                                rgb = (eleccion == 1);
                                System.out.println("Es inalambrico? 1-Si 2-No");
                                eleccion = scanner.nextInt();
                                while((eleccion < 1) || (eleccion > 2)){
                                    System.out.println("Incorrecto, 1-Si 2-No");
                                    eleccion = scanner.nextInt();
                                }
                                inalambrico = (eleccion == 1);
                                System.out.println("Tipo de teclado 1-100% 2-80% 3-60%");
                                eleccion = scanner.nextInt();
                                while((eleccion < 1) || (eleccion > 3)){
                                    System.out.println("Incorrecto, 1-100% 2-80% 3-60%");
                                    eleccion = scanner.nextInt();
                                }
                                if(eleccion == 1){
                                    tipoTeclado = TipoTeclado.cienporciento;
                                }else if(eleccion == 2){
                                    tipoTeclado = TipoTeclado.ochentaporciento;
                                }else{
                                    tipoTeclado = TipoTeclado.sesentaporciento;
                                }
                                System.out.println("Tipo de mecanismo 1-Switches Red 2-Switches Blue 3-Switches Brown");
                                eleccion = scanner.nextInt();
                                while((eleccion < 1) || (eleccion > 3)){
                                    System.out.println("Incorrecto, 1-Red 2-Blue 3-Brown");
                                    eleccion = scanner.nextInt();
                                }
                                if(eleccion == 1){
                                    tipoMecanismo = TipoMecanismo.switchesRed;
                                }else if(eleccion == 2){
                                    tipoMecanismo = TipoMecanismo.switchesBlue;
                                }else{
                                    tipoMecanismo = TipoMecanismo.switchesBrown;
                                }
                                System.out.println("ingrese el stock");
                                stock=scanner.nextInt();
                                while(stock<=0){
                                    System.out.println("incorrecte, ingrese un numero mayor a 0");
                                    stock=scanner.nextInt();
                                }
                                revision =sistema.agregarTeclado(stock,precio, marca, modelo, color, rgb, inalambrico, tipoTeclado, tipoMecanismo);
                                if(revision){
                                    System.out.println("agregado correctamente");
                                }else {
                                    System.out.println("error al crear");
                                }
                                break;

                            case 11:
                                scanner.nextLine();
                                System.out.println("Ingrese el precio: ");
                                precio = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println("Ingrese la marca: ");
                                marca = scanner.nextLine();
                                System.out.println("Ingrese el modelo: ");
                                modelo = scanner.nextLine();
                                System.out.println("Ingrese el color: ");
                                color = scanner.nextLine();
                                System.out.println("Tiene RGB? 1-Si 2-No");
                                eleccion = scanner.nextInt();
                                while((eleccion < 1) || (eleccion > 2)){
                                    System.out.println("Incorrecto, 1-Si 2-No");
                                    eleccion = scanner.nextInt();
                                }
                                rgb = (eleccion == 1);
                                System.out.println("Es inalambrico? 1-Si 2-No");
                                eleccion = scanner.nextInt();
                                while((eleccion < 1) || (eleccion > 2)){
                                    System.out.println("Incorrecto, 1-Si 2-No");
                                    eleccion = scanner.nextInt();
                                }
                                inalambrico = (eleccion == 1);
                                scanner.nextLine();
                                System.out.println("Ingrese tipo de audio (ej: 7.1 Surround): ");
                                audio = scanner.nextLine();
                                System.out.println("Tiene microfono? 1-Si 2-No");
                                eleccion = scanner.nextInt();
                                while((eleccion < 1) || (eleccion > 2)){
                                    System.out.println("Incorrecto, 1-Si 2-No");
                                    eleccion = scanner.nextInt();
                                }
                                microfono = (eleccion == 1);
                                System.out.println("ingrese el stock");
                                stock=scanner.nextInt();
                                while(stock<=0){
                                    System.out.println("incorrecte, ingrese un numero mayor a 0");
                                    stock=scanner.nextInt();
                                }
                                revision= sistema.agregarAuricular(stock,precio, marca, modelo, color, rgb, inalambrico, audio, microfono);
                                if(revision){
                                    System.out.println("agregado correctamente");
                                }else {
                                    System.out.println("error al crear");
                                }
                                break;

                            case 12:
                                scanner.nextLine();
                                System.out.println("Ingrese el precio: ");
                                precio = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println("Ingrese la marca: ");
                                marca = scanner.nextLine();
                                System.out.println("Ingrese el modelo: ");
                                modelo = scanner.nextLine();
                                System.out.println("Ingrese el color: ");
                                color = scanner.nextLine();
                                System.out.println("Tiene RGB? 1-Si 2-No");
                                eleccion = scanner.nextInt();
                                while((eleccion < 1) || (eleccion > 2)){
                                    System.out.println("Incorrecto, 1-Si 2-No");
                                    eleccion = scanner.nextInt();
                                }
                                rgb = (eleccion == 1);
                                System.out.println("Es inalambrico? 1-Si 2-No");
                                eleccion = scanner.nextInt();
                                while((eleccion < 1) || (eleccion > 2)){
                                    System.out.println("Incorrecto, 1-Si 2-No");
                                    eleccion = scanner.nextInt();
                                }
                                inalambrico = (eleccion == 1);
                                System.out.println("Ingrese las pulgadas (entre 21 y 49): ");
                                pulgadas = scanner.nextDouble();
                                while((pulgadas < 21) || (pulgadas > 49)){
                                    System.out.println("Incorrecto, ingrese entre 21 y 49 pulgadas: ");
                                    pulgadas = scanner.nextDouble();
                                }
                                scanner.nextLine();
                                System.out.println("Ingrese calidad de pantalla (ej: FHD, QHD, 4K): ");
                                calidadPantalla = scanner.nextLine();
                                System.out.println("Es curvo? 1-Si 2-No");
                                eleccion = scanner.nextInt();
                                while((eleccion < 1) || (eleccion > 2)){
                                    System.out.println("Incorrecto, 1-Si 2-No");
                                    eleccion = scanner.nextInt();
                                }
                                curvo = (eleccion == 1);
                                System.out.println("Ingrese frecuencia en Hz (60, 75, 120, 144, 165, 240): ");
                                frecuencia = scanner.nextInt();
                                while(frecuencia != 60 && frecuencia != 75 && frecuencia != 120 &&
                                        frecuencia != 144 && frecuencia != 165 && frecuencia != 240){
                                    System.out.println("Incorrecto, ingrese 60, 75, 120, 144, 165 o 240 Hz: ");
                                    frecuencia = scanner.nextInt();
                                }
                                System.out.println("Ingrese tiempo de respuesta en ms (1, 2, 3, 4, 5): ");
                                tiempoRespuesta = scanner.nextInt();
                                while((tiempoRespuesta < 1) || (tiempoRespuesta > 5)){
                                    System.out.println("Incorrecto, ingrese entre 1 y 5 ms: ");
                                    tiempoRespuesta = scanner.nextInt();
                                }
                                System.out.println("ingrese el stock");
                                stock=scanner.nextInt();
                                while(stock<=0){
                                    System.out.println("incorrecte, ingrese un numero mayor a 0");
                                    stock=scanner.nextInt();
                                }
                                revision =sistema.agregarMonitor(stock,precio, marca, modelo, color, rgb, inalambrico,
                                        pulgadas, calidadPantalla, curvo, frecuencia, tiempoRespuesta);
                                if(revision){
                                    System.out.println("agregado correctamente");
                                }else {
                                    System.out.println("error al crear");
                                }
                                break;

                            case 13:
                                scanner.nextLine();
                                System.out.println("Ingrese el precio: ");
                                precio = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println("Ingrese la marca: ");
                                marca = scanner.nextLine();
                                System.out.println("Ingrese el modelo: ");
                                modelo = scanner.nextLine();
                                System.out.println("Ingrese el color: ");
                                color = scanner.nextLine();
                                System.out.println("Tiene RGB? 1-Si 2-No");
                                eleccion = scanner.nextInt();
                                while((eleccion < 1) || (eleccion > 2)){
                                    System.out.println("Incorrecto, 1-Si 2-No");
                                    eleccion = scanner.nextInt();
                                }
                                rgb = (eleccion == 1);
                                System.out.println("Es inalambrico? 1-Si 2-No");
                                eleccion = scanner.nextInt();
                                while((eleccion < 1) || (eleccion > 2)){
                                    System.out.println("Incorrecto, 1-Si 2-No");
                                    eleccion = scanner.nextInt();
                                }
                                inalambrico = (eleccion == 1);
                                scanner.nextLine();
                                System.out.println("Ingrese tipo de superficie (ej: Tela, Plastico, Metal): ");
                                tipoSuperficie = scanner.nextLine();
                                System.out.println("Ingrese tamaño (ej: S, M, L, XL, XXL): ");
                                tamanio = scanner.nextLine();
                                System.out.println("ingrese el stock");
                                stock=scanner.nextInt();
                                while(stock<=0){
                                    System.out.println("incorrecte, ingrese un numero mayor a 0");
                                    stock=scanner.nextInt();
                                }
                                revision= sistema.agregarMousePad(stock,precio, marca, modelo, color, rgb, inalambrico,
                                        tipoSuperficie, tamanio);
                                if(revision){
                                    System.out.println("agregado correctamente");
                                }else {
                                    System.out.println("error al crear");
                                }
                                break;

                        }
                    case 3:
                        System.out.println("ingrese el id a eliminar: ");
                        idProducto=scanner.nextInt();
                        revision = sistema.eliminarProducto(idProducto);
                        if(revision){
                            System.out.println("Clases.Producto eliminado correctamente");
                        }else{
                            System.out.println("Error al eliminar producto");
                        }
                        break;
                    case 4:
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

                    case 5:
                        System.out.println("1-Combos, 2-ComputadorasDeEscritorio");
                        try{
                            eleccion = scanner.nextInt();
                            while(eleccion<1 || eleccion>2){
                                System.out.println("Opcion invalida, por favor ingrese una nuevamente: ");
                                eleccion = scanner.nextInt();
                            }
                        }catch (InputMismatchException e){
                            System.out.println("Error, ingresaste una opcion invalida");
                        }

                        if(eleccion == 1){
                            System.out.println(sistema.obtenerTotalCombo());
                        }else if(eleccion == 2){
                            System.out.println(sistema.obtenerTotalComputadoraEscritorio());
                        }
                        break;
                    case 6:
                        usuarioActual = new Usuario();
                        break;
                }
            }

        }while(opcion != 0);

        //SISTEMA PARA GUARDAR USUARIO Y ADEMAS GUARDAR INFORMACION RESTANTE DE LA ENVOLVENETE
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

        System.out.println("Gracias por su estadia, que tengas un buen dia!");
        guardarInfo(sistema.toJSON());
        guardarTickets(sistema.ticketsToJSON());
    }

    //METODOS PARA DESCARGAR INFO AL JSON Y DESCARGAR
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
    public static void guardarTickets(JSONArray tickets){
        JSONUtiles.uploadJsonTickets(tickets);

    }
}