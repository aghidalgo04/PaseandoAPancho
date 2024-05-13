package upm.cli;

import java.util.List;

public interface Vista {
    /**
     * @return [0] ~ comando , [i>=1] - parametros (si hay)
     */
    String[] leerComando();

    void mostrarComando(String comando);

    void mostrarComandosDisponibles(List<String[]> comandos);

    void mostrarError(String error);

    void mostrarUsuario(String id, String nombre, String apellidos, String correoElectronico);

    void mostrarMascota(Long id, String nombre, String direccion, String descripcion);
}
