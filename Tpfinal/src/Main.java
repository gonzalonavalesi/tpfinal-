import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

        Usuario usuarioActual = descargarUsuario();

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
                        System.out.println("Ingrese su nombre de usario: ");
                        usuarioRegister = scanner.nextLine();
                        System.out.println("Ingrese su contraseña: ");
                        contraseñaRegister = scanner.nextLine();
                        System.out.println("Ingrese su nombre: ");
                        nombreRegister = scanner.nextLine();
                        System.out.println("Ingrese su gmail: ");
                        gmailRegister = scanner.nextLine();
                        if(gmailRegister.contains("@")){
                            revision = sistema.agregarUsuario(usuarioRegister, contraseñaRegister, nombreRegister, gmailRegister);
                            usuarioActual = sistema.actualizarUsuario(usuarioRegister);
                        }else{
                            System.out.println("El gmail no contiene @");
                        }

                        if(revision){
                            System.out.println("Usuario agregado correctamente, Bienvenido "+usuarioActual.getUsuario());
                        }else{
                            System.out.println("Error al intentar agregar un usuario");
                        }
                        break;

                    case 3:
                        System.out.println("PRODUCTOS: ");
                        break;
                }
            }
            if(usuarioActual.getTipoUsuario() == TipoUsuario.logueado){
                System.out.println("\nBienvenido "+usuarioActual.getUsuario()+" al sistema de compras tecnologicas del grupo! espero tengas una buena estadia...");
                System.out.println("1- Ver Productos");
                System.out.println("2- Ver Carrito");
                System.out.println("3- Agregar Metodo de Pago");
                System.out.println("4- Realizar Compra");
                System.out.println("5- Cerrar sesion");
                System.out.println("0- Cerrar Programa");
                System.out.println("OPCION: ");
                try{
                    opcion = scanner.nextInt();
                    while(opcion < 0 || opcion >5){
                        System.out.println("Opcion invalida, ingrese nuevamente una opcion:");
                        opcion = scanner.nextInt();
                    }
                }catch (InputMismatchException e){
                    System.out.println("Ingrese un numero dentro del rango por favor!");
                    scanner.nextLine();
                    opcion = -1;
                }

                /// switch con las respectivas funciones
            }
            if(usuarioActual.getTipoUsuario() == TipoUsuario.vip){
                System.out.println("\nBienvenido "+usuarioActual.getUsuario()+" al sistema de compras tecnologicas del grupo! espero tengas una buena estadia...");
                System.out.println("1- Ver Productos");
                System.out.println("2- Ver Carrito");
                System.out.println("3- Agregar Metodo de Pago");
                System.out.println("4- Realizar Compra");
                System.out.println("5- Cerrar sesion");
                System.out.println("0- Cerrar Programa");
                System.out.println("OPCION: ");
                try{
                    opcion = scanner.nextInt();
                    while(opcion < 0 || opcion >5){
                        System.out.println("Opcion invalida, ingrese nuevamente una opcion:");
                        opcion = scanner.nextInt();
                    }
                }catch (InputMismatchException e){
                    System.out.println("Ingrese un numero dentro del rango por favor!");
                    scanner.nextLine();
                    opcion = -1;
                }

                /// switch con las respectivas funciones
            }
            if(usuarioActual.getTipoUsuario() == TipoUsuario.administrador){
                System.out.println("\nBienvenido "+usuarioActual.getUsuario()+" al sistema de compras tecnologicas del grupo!");
                System.out.println("1- Ver Productos");
                System.out.println("2- Ver Carrito");
                System.out.println("3- Agregar Metodo de Pago");
                System.out.println("4- Realizar Compra");
                System.out.println("5- agreagar productos");
                System.out.println("6- eliminar productos");
                System.out.println("7- modificar productos");
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
                case 8:
                    usuarioActual = new Usuario();
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