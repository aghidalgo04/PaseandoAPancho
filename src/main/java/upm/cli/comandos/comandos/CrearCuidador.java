package upm.cli.comandos.comandos;

import upm.cli.Vista;
import upm.cli.comandos.Comando;
import upm.controlador.ControladorUsuario;

public class CrearCuidador implements Comando {
    private static final String VALOR = "crear-cuidador";
    private static final String AYUDA_PARAMETROS = "(nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro, foto, descripcion, precio, IBAN, documentacion)";
    private static final String AYUDA_COMENTARIO = "Creas un cuidador";

    private static final byte NUMERO_PARAMETROS_MIN = 10;
    private static final byte NUMERO_PARAMETROS_MAX = 11;

    private ControladorUsuario controladorUsuario;

    public CrearCuidador(ControladorUsuario controladorUsuario) {
        this.controladorUsuario = controladorUsuario;
    }

    @Override
    public void ejecutar(String[] parametros, Vista vista) {
        if (parametros.length != NUMERO_PARAMETROS_MIN && parametros.length != NUMERO_PARAMETROS_MAX) {
            throw new RuntimeException("Numero de parametros incorrectos"); // @TODO cambiar por exception personal
        }

        if (parametros.length == NUMERO_PARAMETROS_MIN) {
            controladorUsuario.registrarCuidador(parametros[0], parametros[1], parametros[2], parametros[3], null, null, null, parametros[4], 0, parametros[5], null); // @TODO completar para que funcione con los distintos archivos
        } else {
            controladorUsuario.registrarCuidador(parametros[0], parametros[1], parametros[2], parametros[3], null, null, null, parametros[4], 0, parametros[5], null); // @TODO completar para que funcione con los distintos archivos
        }
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

