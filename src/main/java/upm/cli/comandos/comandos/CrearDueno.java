package upm.cli.comandos.comandos;

import upm.cli.Vista;
import upm.cli.comandos.Comando;
import upm.controlador.ControladorUsuario;

public class CrearDueno implements Comando {
    private static final String VALOR = "crear-dueno";
    private static final String AYUDA_PARAMETROS = "(nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro)";
    private static final String AYUDA_COMENTARIO = "Creas un dueno";

    private static final byte NUMERO_PARAMETROS = 6;

    private ControladorUsuario controladorUsuario;

    public CrearDueno(ControladorUsuario controladorUsuario) {
        this.controladorUsuario = controladorUsuario;
    }

    @Override
    public void ejecutar(String[] parametros, Vista vista) {
        if (parametros.length != NUMERO_PARAMETROS) {
            throw new RuntimeException("Numero de parametros incorrectos"); // @TODO cambiar por exception personal
        }
        controladorUsuario.registrarDueno(parametros[0], parametros[1], parametros[2], parametros[3], null, null); // @TODO completar para que funcione con los distintos archivos
    }

    @Override
    public String valor() {
        return VALOR;
    }

    @Override
    public String ayudaParametros() {
        return AYUDA_PARAMETROS;
    }

    @Override
    public String ayudaComentario() {
        return AYUDA_COMENTARIO;
    }
}
