package upm.cli.comandos.comandos;

import upm.cli.Vista;
import upm.cli.comandos.Comando;
import upm.cli.comandos.Session;
import upm.controlador.ControladorMascota;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public class crearMascota implements Comando {
    private static final String VALOR = "crear-mascota";
    private static final String AYUDA_PARAMETROS = "(nombre, direccion, descripcion, codigoRIAC, polizaSeguro, albums, fotoFavorita)";
    private static final String AYUDA_COMENTARIO = "Creas una mascota";
    private final ControladorMascota controladorMascota;
    private Session session;
    private final short tamano = 7;

    public crearMascota(ControladorMascota controladorMascota, Session session) {
        this.controladorMascota = controladorMascota;
        this.session = session;
    }

    @Override
    public void ejecutar(String[] parametros, Vista vista) {
        if(parametros.length != this.tamano){
            throw new RuntimeException("Numero de parametros incorrectos"); // @TODO cambiar por exception personal
        }
        this.controladorMascota.crearMascota(parametros[0],parametros[1],parametros[2],parametros[3],parametros[4],null,null); // @TODO completar para que funcione con los distintos archivos
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
