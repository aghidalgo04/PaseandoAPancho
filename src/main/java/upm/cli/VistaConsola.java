package upm.cli;

import java.util.Scanner;

// @TODO clase no acabada
public class VistaConsola implements Vista {
    private static final String DELIMITER_COLON_OR_RETURN = "[:,\\r\\n]";
    public static final String RESETEAR = "\u001B[0m";
    public static final String NEGRO = "\u001B[30m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String MORADO = "\u001B[35m";
    public static final String CIAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";
    public static final String FONDO_NEGRO = "\u001B[40m";
    public static final String FONDO_ROJO = "\u001B[41m";
    public static final String FONDO_VERDE = "\u001B[42m";
    public static final String FONDO_AMARILLO = "\u001B[43m";
    public static final String FONDO_AZUL = "\u001B[44m";
    public static final String FONDO_MORADO = "\u001B[45m";
    public static final String FONDO_CIAN = "\u001B[46m";
    public static final String FONDO_BLANCO = "\u001B[47m";
    public static final String COPIAR_DERECHA = "\u00A9";
    public static final String CHECK = "\u2705";
    public static final String CROSS = "\u274C";
    public static final String ANIMAL = "\uD83D\uDC36";
    public static final String USUARIO = "\uD83D\uDC64";
    public static final String IMPORTANT = "\u2757";
    public static final String ARROW = "\u27A4";
    public static final String ARROW2 = "\u279E";
    public static final String RETURN = "\r";

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
    public void mostarMensaje(String mensaje) {

    }

    @Override
    public void mostrarComando(String valor, String parametros, String comentario) {
        System.out.println(VistaConsola.MORADO + "  " + VistaConsola.CHECK + " " + VistaConsola.RESETEAR);
    }

    @Override
    public void mostrarError(String error) {
        System.out.println(VistaConsola.ROJO + "  " + error + " " + VistaConsola.CROSS + VistaConsola.RESETEAR);
    }

    @Override
    public void mostrarUsuario(String id, String nombre, String apellidos, String correoElectronico) {
        System.out.println(VistaConsola.AZUL + "  " + VistaConsola.USUARIO + " id:" + id + " nombre: " + nombre + apellidos + " correo: " + correoElectronico + VistaConsola.RESETEAR);
    }

    @Override
    public void mostrarMascota(Long id, String nombre, String direccion, String descripcion) {
        System.out.println(VistaConsola.AMARILLO + "  " + VistaConsola.ANIMAL + " id:" + id + " nombre: " + nombre + " dirección: " + direccion + " descripción: " + descripcion + VistaConsola.RESETEAR);
    }
}
