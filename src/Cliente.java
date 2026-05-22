public class Cliente {

    private String nombre;
    private String cedula;
    private String telefono;
    private String direccion;
    private String correo;

    public Cliente(String nombre,
                   String cedula,
                   String telefono,
                   String direccion,
                   String correo) {

        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    @Override
    public String toString() {

        return "Nombre: " + nombre +
                " | Cedula: " + cedula +
                " | Telefono: " + telefono +
                " | Direccion: " + direccion +
                " | Correo: " + correo;
    }
}