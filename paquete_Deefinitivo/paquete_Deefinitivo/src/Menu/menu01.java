package Menu;

import Cliente.Cliente01;
import Cliente.DireccionEntrega;
import Logica01.logicaC;
import Paquete.Estado;
import Paquete.Paquete;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class menu01 {

    private static Scanner scanner = new Scanner(System.in);
    private static Cliente01 cliente = new Cliente01();
    private static logicaC logicaCliente = new logicaC();
    private static Paquete paquete = new Paquete();
    private static Estado estado = new Estado();
    private static Date fecha = new Date();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n1. Crear paquete");
            System.out.println("2. Crear cliente");
            System.out.println("3. Agregar dirección a cliente");
            System.out.println("4. Mostrar información de paquete");
            System.out.println("5. Modificar paquete");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    if (logicaCliente.validaCliente(cliente) && !logicaCliente.validaDireccion(cliente)) {
                        crearPaquete(cliente);
                    } else {
                        System.out.println("El cliente está creado pero no tiene direcciones registradas");
                    }
                    break;
                case 2:
                    if (logicaCliente.validaCliente(cliente)) {
                        System.out.println("Cliente ya creado");
                    } else {
                        crearCliente(cliente);
                        break;
                    }
                    break;
                case 3:
                    verificarDireccion(ingresarDireccion(), cliente);
                    break;
                case 4:
                    imprimirPaquete(cliente);
                    break;
                case 5:
                    modificarEstado(cliente);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    private static void crearPaquete(Cliente01 cli) {

        System.out.println("Ingrese el id del paquete:");
        int id = scanner.nextInt();
        paquete.setIdPaq(id);
        scanner.nextLine();
        System.out.println("Ingrese codigo del paquete:");
        String cod = scanner.nextLine();
        paquete.setCodigo(cod);

        System.out.println("Ingrese descripcion del paquete:");
        String descripcion = scanner.nextLine();
        paquete.setDescripcion(descripcion);

        System.out.println("Ingrese el peso del paquete:");
        double peso = scanner.nextDouble();
        paquete.setPeso(peso);

        System.out.println("Ingrese el largo del paquete:");
        double largo = scanner.nextDouble();
        paquete.setLargo(largo);

        System.out.println("Ingrese el ancho del paquete:");
        double ancho = scanner.nextDouble();
        paquete.setAncho(ancho);

        cli.setPaquetes(paquete);
    }

    public static void crearCliente(Cliente01 cli) {
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        cli.setNombres(nombre);

        System.out.print("Ingrese su apellido: ");
        String apellido = scanner.nextLine();
        cli.setApellidos(apellido);

        System.out.print("Ingrese su cedula: ");
        String cedula = scanner.nextLine();
        cli.setCedula(cedula);

        if (logicaC.ValidaCedula(cli)) {
            System.out.println("Cedula valida");
        } else {
            System.out.println("Escriba una cédula válida:");
            cli.setCedula(null);
        }

        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();
        cli.setEmail(email);

        if (logicaC.validaMail(cli)) {
            System.out.println("Email valido");
        } else {
            System.out.println("Escriba una email válido:");
            cli.setEmail(null);
        }
        System.out.println(cli.toString());
    }

    public static DireccionEntrega ingresarDireccion() {
        DireccionEntrega direc = new DireccionEntrega();

        System.out.print("Ingrese la calle 1: ");
        String calle1 = scanner.nextLine();
        direc.setCalle1(calle1);

        System.out.print("Ingrese la calle 2: ");
        String calle2 = scanner.nextLine();
        direc.setCalle2(calle2);

        System.out.print("Ingrese la referencia: ");
        String referencia = scanner.nextLine();
        direc.setReferencia(referencia);

        if (logicaC.validaDirecciones(direc)) {
            System.out.println(direc.toString());
            return direc;
        } else {
            System.out.println("Escriba una direccion válida:");
            return ingresarDireccion();
        }
    }

    public static void modificarEstado(Cliente01 cliente) {

        System.out.println("Ingrese 1-Despachado o 2-Entregado");
        int op = scanner.nextInt();

        if (cliente.getPaquetes() != null) {
            Date estadoActual = cliente.getPaquetes().getEstados().get(1).getFecha();
            Date estadoActual2 = cliente.getPaquetes().getEstados().get(2).getFecha();

            switch (op) {
                case 1:
                    if (estadoActual == null) {
                        cliente.getPaquetes().getEstados().get(1).setFecha(fecha);
                    } else {
                        System.out.println("Paquete Despachado");
                    }
                    break;
                case 2:
                    if (estadoActual2 == null) {
                        cliente.getPaquetes().getEstados().get(2).setFecha(fecha);
                    } else {
                        System.out.println("Paquete Enviado");
                    }
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } else {
            System.out.println("Error: No hay paquetes asignados al cliente.");
        }
    }

    private static void imprimirPaquete(Cliente01 cliP) {
        if (cliP.getPaquetes() == null) {
            System.out.println("El cliente no tiene ningún paquete registrado.");
        } else {

            System.out.println(cliP.getPaquetes());
            System.out.println("Cliente: " + cliP.getNombres() + " " + cliP.getApellidos());
        }
    }

    private static void verificarDireccion(DireccionEntrega direct, Cliente01 client) {
        boolean direccionRepetida = false;

        for (DireccionEntrega dir : client.getDirecciones()) {
            if (dir.getCalle1().equals(direct.getCalle1()) && dir.getCalle2().equals(direct.getCalle2())) {
                direccionRepetida = true;
                break;
            }
        }

        if (direccionRepetida) {
            System.out.println("La dirección ya existe. Por favor, ingrese una dirección nueva.");
        } else {
            direct.setActual(true);
            client.getDirecciones().forEach(dir -> dir.setActual(false));
            client.agregarDireccion(direct);
            System.out.println("Dirección agregada correctamente.");
        }
    }

    public static void agregarPaquete(Cliente01 cliente) {

        if (cliente.getPaquetes() == null) {
            crearPaquete(cliente);
        } else {
            System.out.println("Error: El paquete ya existe.");
        }
    }

    public static void imprimirDirecciones(Cliente01 cliente) {
        System.out.println("Direcciones del cliente:");
        List<DireccionEntrega> direcciones = cliente.getDirecciones();
        if (direcciones.isEmpty()) {
            System.out.println("El cliente no tiene direcciones registradas.");
        } else {
            for (int i = 0; i < direcciones.size(); i++) {
                DireccionEntrega direccion = direcciones.get(i);
                System.out.println("Dirección " + (i + 1) + ":");
                System.out.println("Calle 1: " + direccion.getCalle1());
                System.out.println("Calle 2: " + direccion.getCalle2());
                System.out.println("Referencia: " + direccion.getReferencia());
                System.out.println("Actual: " + direccion.isActual());
                System.out.println();
            }
        }
    }
}
