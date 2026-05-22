public class Canino {

    private String nombre;
    private String raza;
    private int edad;
    private double peso;
    private String enfermedad;
    private String duenio;

    public Canino(
        String nombre,
        String raza,
        int edad,
        double peso,
        String enfermedad,
        String duenio) {

            this.nombre = nombre;
            this.raza = raza;
            this.edad = edad;
            this.peso = peso;
            this.enfermedad = enfermedad;
            this.duenio = duenio;
    }

    @Override
    public String toString() {

        return "Canino: " + nombre +
               " | Raza: " + raza +
               " | Edad: " + edad +
               " | Peso: " + peso +
               " | Enfermedad: " + enfermedad +
               " | Dueño: " + duenio;
    }
}