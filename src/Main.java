import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int intentos = 3;
        boolean acceso = false;

        while (intentos > 0) {

            System.out.println("===== INICIO DE SESION =====");

            System.out.print("Usuario: ");
            String usuario = sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            if (usuario.equals("admin") && password.equals("1234")) {

                acceso = true;
                break;

            } else {

                intentos--;

                if (intentos > 0) {

                    System.out.println("Datos incorrectos.");
                    System.out.println("Intentos restantes: " + intentos);
                }
            }
        }

        if (!acceso) {

            System.out.println("Intentos agotados.");
            System.out.println("Cerrando sistema...");
            return;
        }

        Sistema sistema = new Sistema();
        sistema.menu();
    }
}