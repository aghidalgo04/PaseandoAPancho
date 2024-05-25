package upm.cli;

public interface Vista {
    /**
     * @return [0] ~ comando , [i>=1] - parametros (si hay)
     */
    String[] leerComando();

    void mostrarEnterComando();

    void mostarMensaje(String mensaje);

    void mostrarComando(String valor, String parametros, String comentario);

    void mostrarError(String error);

    void mostrarUsuario(String id, String nombre, String apellidos, String correoElectronico);

    void mostrarMascota(Long id, String nombre, String direccion, String descripcion);
}
