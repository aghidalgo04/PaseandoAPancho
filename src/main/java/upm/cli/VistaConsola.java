package upm.cli;

import java.util.Scanner;

public class VistaConsola implements Vista {
    private static final String COMMAND = "pap";
    private static final String DELIMITER_COLON_OR_RETURN = "[:,\\r\\n]";
    // colores
    private static final String RESETEAR = "\u001B[0m";
    private static final String ROJO = "\u001B[31m";
    private static final String VERDE = "\u001B[32m";
    private static final String AMARILLO = "\u001B[33m";
    private static final String AZUL = "\u001B[34m";
    private static final String MORADO = "\u001B[35m";
    private static final String CIAN = "\u001B[36m";
    // emoji
    private static final String COPIAR_DERECHA_AUTOR = "\u00A9";
    private static final String CROSS = "\u274C";
    private static final String ANIMAL = "\uD83D\uDC36";
    private static final String USUARIO = "\uD83D\uDC64";
    private static final String ARROW = "\u27A4";
    public static final String ARROW2 = "\u279E";

    private final Scanner scanner;

    public VistaConsola() {
        this.scanner = new Scanner(System.in).useDelimiter(DELIMITER_COLON_OR_RETURN);
    }

    @Override
    public void mostarBienvenida() {
        System.out.println(VistaConsola.AMARILLO + "Bienvenido a Paseando a Pancho" + VistaConsola.COPIAR_DERECHA_AUTOR + ", llama `ayuda` para consultar comandos." + VistaConsola.RESETEAR);
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
    public void mostrarEnterComando() {
        System.out.print(VistaConsola.COMMAND + " " + VistaConsola.ARROW + " ");
    }

    @Override
    public void mostarMensaje(String mensaje) {
        System.out.println("    " +  VistaConsola.MORADO + mensaje + VistaConsola.RESETEAR);
    }

    @Override
    public void mostrarComando(String valor, String parametros, String comentario) {
        System.out.println("    " + VistaConsola.VERDE + VistaConsola.ARROW2 + " " + VistaConsola.CIAN + valor + ": " + VistaConsola.AMARILLO + parametros + VistaConsola.VERDE + " --- " + comentario + VistaConsola.RESETEAR);
    }

    @Override
    public void mostrarError(String error) {
        System.out.println("    " +  VistaConsola.ROJO + VistaConsola.CROSS + "  " + error + VistaConsola.RESETEAR);
    }

    @Override
    public void mostrarUsuario(String id, String nombre, String apellidos, String correoElectronico) {
        System.out.println("    " +  VistaConsola.AZUL + "  " + VistaConsola.USUARIO + " id:" + id + " nombre: " + nombre + apellidos + " correo: " + correoElectronico + VistaConsola.RESETEAR);
    }

    @Override
    public void mostrarMascota(Long id, String nombre, String direccion, String descripcion) {
        System.out.println("    " +  VistaConsola.AMARILLO + "  " + VistaConsola.ANIMAL + " id:" + id + " nombre: " + nombre + " dirección: " + direccion + " descripción: " + descripcion + VistaConsola.RESETEAR);
    }
}
