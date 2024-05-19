package upm.cli.comandos.comandos;

import upm.cli.Vista;
import upm.cli.comandos.Comando;
import upm.controlador.ControladorMascota;

public class CrearMascota implements Comando {
    private static final String VALOR = "crear-mascota";
    private static final String AYUDA_PARAMETROS = "(nombre, direccion, descripcion, codigoRIAC, polizaSeguro, albums, fotoFavorita)";
    private static final String AYUDA_COMENTARIO = "Creas una mascota";

    private static final byte NUMERO_PARAMETROS = 7;

    private final ControladorMascota controladorMascota;

    public CrearMascota(ControladorMascota controladorMascota) {
        this.controladorMascota = controladorMascota;
    }

    @Override
    public void ejecutar(String[] parametros, Vista vista) {
        if (parametros.length != NUMERO_PARAMETROS) {
            throw new RuntimeException("Numero de parametros incorrectos"); // @TODO cambiar por exception personal
        }
        this.controladorMascota.crearMascota(parametros[0], parametros[1], parametros[2], parametros[3], parametros[4], null, null); // @TODO completar para que funcione con los distintos archivos
        vista.mostarMensaje("Mascota creada con exito");
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
