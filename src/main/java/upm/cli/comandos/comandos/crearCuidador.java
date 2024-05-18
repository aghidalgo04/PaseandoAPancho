package upm.cli.comandos.comandos;

import upm.cli.Vista;
import upm.cli.comandos.Comando;
import upm.controlador.ControladorUsuario;

public class crearCuidador implements Comando {
    private static final String VALOR = "crear-dueno";
    private static final String AYUDA_PARAMETROS = "(nombre, apellidos, correoElectronico, direccion, idioma, plataformaRegistro, foto, descripcion, precio, IBAN, documentacion)";
    private static final String AYUDA_COMENTARIO = "Creas un cuidador";
    private ControladorUsuario controladorUsuario;
    private final short tamano = 10;
    private final short tamano1 = 11;

    public crearCuidador(ControladorUsuario controladorUsuario) {
        this.controladorUsuario = controladorUsuario;
    }
    @Override
    public void ejecutar(String[] parametros, Vista vista) {
        if (parametros.length != tamano && parametros.length != tamano1) {
            throw new RuntimeException("Numero de parametros incorrectos"); // @TODO cambiar por exception personal
        } if (parametros.length == tamano) {
            controladorUsuario.regsitrarUsuarioComoCuidador(parametros[0], parametros[1], parametros[2], parametros[3], null, null, null, parametros[4], 0, parametros[5]); // @TODO completar para que funcione con los distintos archivos
        } else if (parametros.length == tamano1) {
            controladorUsuario.regsitrarUsuarioComoCuidadorConDocs(parametros[0], parametros[1], parametros[2], parametros[3], null, null, null, parametros[4], 0, parametros[5], null); // @TODO completar para que funcione con los distintos archivos
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

