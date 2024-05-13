package upm.cli;

import java.util.List;
import java.util.Scanner;

public class     VistaConsola implements Vista {
    private static final String DELIMITER_COLON_OR_RETURN = "[:,\\r\\n]";

    private final Scanner scanner;

    public VistaConsola() {
        this.scanner = new Scanner(System.in).useDelimiter(DELIMITER_COLON_OR_RETURN);
    }

    @Override
    public String[] leerComando() {
        String comando = this.scanner.next().trim().toLowerCase();
        String[] argumentos = leerArgumentos();
        if (argumentos != null) {
            String[] input = new String[1 + argumentos.length];
            input[0] = comando;
            System.arraycopy(argumentos, 0, input, 1, argumentos.length);
            return input;
        } else {
            return new String[]{comando};
        }
    }

    private String[] leerArgumentos() {
        String input = this.scanner.nextLine().trim();
        if (!input.isEmpty()) {
            return filterArgumentosSpace(input.replaceFirst(":", "").split(";"));
        } else {
            return null;
        }
    }

    private String[] filterArgumentosSpace(String[] valores) {
        for (int i = 0; i < valores.length; i++) {
            valores[i] = valores[i].trim();
        }
        return valores;
    }

    @Override
    public void mostrarComando(String comando) {

    }

    @Override
    public void mostrarComandosDisponibles(List<String[]> comandos) {

    }

    @Override
    public void mostrarError(String error) {

    }

    @Override
    public void mostrarUsuario(Long id, String nombre, String apellidos, String correoElectronico) {

    }

    @Override
    public void mostrarMascota(Long id, String nombre, String direccion, String descripcion) {

    }
}
