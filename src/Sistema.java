import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Sistema {

    Scanner sc = new Scanner(System.in);

    private final String ARCHIVO_CLIENTES = "clientes.txt";
    private final String ARCHIVO_CANINOS = "caninos.txt";
    
    public void menu() {

        int opcion;

        do {

            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar canino");
            System.out.println("3. Consultar clientes");
            System.out.println("4. Consultar caninos");
            System.out.println("5. Buscar cliente por cedula");
            System.out.println("6. Buscar caninos por cedula del dueño");
System.out.println("7. Salir");

            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    registrarCliente();
                    break;

                case 2:
                    registrarCanino();
                    break;

                case 3:
                    consultarClientes();
                    break;

                case 4:
                    consultarCaninos();
                    break;

                case 5:
                    buscarClientePorCedula();
                    break;
                    
                case 6:
                    buscarCaninosPorDuenio();
                    break;
                    
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 7);
    }

    public void registrarCliente() {

        try {

            System.out.println("\n===== REGISTRAR CLIENTE =====");

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Cedula: ");
            String cedula = sc.nextLine();

            System.out.print("Telefono: ");
            String telefono = sc.nextLine();

            System.out.print("Direccion: ");
            String direccion = sc.nextLine();

            System.out.print("Correo: ");
            String correo = sc.nextLine();

            FileWriter fw = new FileWriter(ARCHIVO_CLIENTES, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(nombre + "," + cedula + "," + telefono + "," + direccion + "," + correo);

            bw.newLine();

            bw.close();

            System.out.println("Cliente registrado correctamente.");
        
        } catch (IOException e) {

            System.out.println("Error al guardar cliente.");
        }
    }

    public void registrarCanino() {

        try {

            System.out.println("\n===== REGISTRAR CANINO =====");

            System.out.print("Cedula del dueño: ");
            String cedulaBuscar = sc.nextLine();

            boolean clienteExiste = false;
            String nombreDuenio = "";

            BufferedReader brClientes =
                    new BufferedReader(
                            new FileReader(ARCHIVO_CLIENTES));

            String linea;

            while ((linea = brClientes.readLine()) != null) {

                String[] datos = linea.split(",");

                if (datos[1].equals(cedulaBuscar)) {

                    clienteExiste = true;
                    nombreDuenio = datos[0];
                    break;
                }
            }

            brClientes.close();

            if (!clienteExiste) {

                System.out.println("El cliente no existe.");
                return;
            }

            System.out.print("Nombre del canino: ");
            String nombre = sc.nextLine();

            System.out.print("Raza: ");
            String raza = sc.nextLine();

            System.out.print("Edad: ");
            int edad = sc.nextInt();

            System.out.print("Peso: ");
            double peso = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enfermedad: ");
            String enfermedad = sc.nextLine();

            FileWriter fw =
                    new FileWriter(ARCHIVO_CANINOS, true);

            BufferedWriter bw =
                    new BufferedWriter(fw);

            bw.write(nombre + "," +
                    raza + "," +
                    edad + "," +
                    peso + "," +
                    enfermedad + "," +
                    nombreDuenio);

            bw.newLine();

            bw.close();

            System.out.println("Canino registrado correctamente.");

        } catch (IOException e) {

            System.out.println("Error al registrar canino.");
        }
    }

    public void consultarClientes() {

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader(ARCHIVO_CLIENTES));

            String linea;

            System.out.println("\n===== LISTA DE CLIENTES =====");

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                Cliente cliente = new Cliente(
                        datos[0],
                        datos[1],
                        datos[2],
                        datos[3],
                        datos[4]
                );

                System.out.println(cliente);
            }

            br.close();

        } catch (IOException e) {

            System.out.println("No hay clientes registrados.");
        }
    }

    public void consultarCaninos() {

        try {

            BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_CANINOS));

            String linea;

            System.out.println("\n===== LISTA DE CANINOS =====");

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                Canino canino = new Canino(
                    datos[0],
                    datos[1],
                    Integer.parseInt(datos[2]),
                    Double.parseDouble(datos[3]),
                    datos[4],
                    datos[5]
                );

                System.out.println(canino);
            }

            br.close();

        } catch (IOException e) {

            System.out.println("No hay caninos registrados.");
        }
    }

    public void buscarClientePorCedula() {

        try {
            System.out.print("\nIngrese la cedula del cliente: ");
            String cedulaBuscar = sc.nextLine();

            BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_CLIENTES));

            String linea;
            boolean encontrado = false;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                if (datos[1].equals(cedulaBuscar)) {

                    Cliente cliente = new Cliente(
                        datos[0],
                        datos[1],
                        datos[2],
                        datos[3],
                        datos[4]
                    );

                    System.out.println("\n===== CLIENTE ENCONTRADO =====");
                    System.out.println(cliente);

                    encontrado = true;
                    break;
                }
            }

            br.close();

            if (!encontrado) {
            System.out.println("No existe un cliente con esa cedula.");
        }
    
    } catch (IOException e) {

        System.out.println("Error al buscar cliente: " + e.getMessage());
    }
  }
 
    public void buscarCaninosPorDuenio() {

    try {

        System.out.print("\nIngrese la cedula del dueño: ");
        String cedulaBuscar = sc.nextLine();

        String nombreDuenio = "";
        boolean duenioExiste = false;

        BufferedReader brClientes = new BufferedReader(
                new FileReader(ARCHIVO_CLIENTES));

        String linea;

        while ((linea = brClientes.readLine()) != null) {

            String[] datos = linea.split(";");

            if (datos[1].equals(cedulaBuscar)) {

                nombreDuenio = datos[0];
                duenioExiste = true;
                break;
            }
        }

        brClientes.close();

        if (!duenioExiste) {

            System.out.println("No existe un cliente con esa cedula.");
            return;
        }

        BufferedReader brCaninos = new BufferedReader(
                new FileReader(ARCHIVO_CANINOS));

        boolean encontrados = false;

        System.out.println("\n===== CANINOS DEL CLIENTE =====");
        System.out.println(nombreDuenio);

        while ((linea = brCaninos.readLine()) != null) {

            String[] datos = linea.split(";");

            if (datos[5].equals(nombreDuenio)) {

                Canino canino = new Canino(
                        datos[0],
                        datos[1],
                        Integer.parseInt(datos[2]),
                        Double.parseDouble(datos[3]),
                        datos[4],
                        datos[5]
                );

                System.out.println(canino);
                encontrados = true;
            }
        }

        brCaninos.close();

        if (!encontrados) {

            System.out.println("Este cliente no tiene caninos registrados.");
        }

    } catch (IOException e) {

        System.out.println("Error al buscar caninos: " + e.getMessage());
    }
  }

}