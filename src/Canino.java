public class Canino {

    private String idCanino;
    private String nombre;
    private String raza;
    private int edad;
    private double peso;
    private String enfermedad;
    private String tipoServicio;
    private String cedulaDuenio;

    public Canino(
        String idCanino,
        String nombre,
        String raza,
        int edad,
        double peso,
        String enfermedad,
        String tipoServicio,
        String cedulaDuenio) {

            this.idCanino = idCanino;
            this.nombre = nombre;
            this.raza = raza;
            this.edad = edad;
            this.peso = peso;
            this.enfermedad = enfermedad;
            this.tipoServicio = tipoServicio;
            this.cedulaDuenio = cedulaDuenio;
    }

    @Override
    public String toString() {

        return "ID: " + idCanino +
               " | Canino: " + nombre +
               " | Raza: " + raza +
               " | Edad: " + edad + " años" +
               " | Peso: " + peso + " kg" +
               " | Enfermedad: " + enfermedad +
               " | Tipo de Servicio: " + tipoServicio +
               " | Cédula del Dueño: " + cedulaDuenio;
    }
} 