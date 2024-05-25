package upm.cli.comandos.comandos;

import upm.cli.Vista;
import upm.cli.comandos.Comando;
import upm.cli.excepciones.UnsupportedAttributesException;
import upm.controlador.ControladorMascota;
import upm.controlador.ControladorUsuario;
import upm.controlador.Session;

public class CrearMascota implements Comando {
    private static final String VALOR = "crear-mascota";
    private static final String AYUDA_PARAMETROS = "(nombre, direccion, descripcion, codigoRIAC, polizaSeguro, albums, fotoFavorita)";
    private static final String AYUDA_COMENTARIO = "Creas una mascota";

    private static final byte NUMERO_PARAMETROS = 7;

    private final ControladorUsuario controladorUsuario;
    private final ControladorMascota controladorMascota;

    public CrearMascota(ControladorUsuario controladorUsuario,ControladorMascota controladorMascota) {
        this.controladorMascota = controladorMascota;
        this.controladorUsuario = controladorUsuario;
    }

    @Override
    public void ejecutar(String[] parametros, Vista vista) {
        if (parametros.length != NUMERO_PARAMETROS) {
            throw new UnsupportedAttributesException(this.ayudaParametros());
        }
        this.controladorUsuario.anadirMascota(this.controladorMascota.crearMascota(parametros[0], parametros[1], parametros[2], parametros[3], parametros[4], null, null));// @TODO completar para que funcione con los distintos archivos
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
