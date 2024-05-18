package upm.cli.comandos.comandos;

import upm.cli.Vista;
import upm.cli.comandos.Comando;
import upm.controlador.ControladorMascota;

public class crearMascotaExotica implements Comando {
    private static final String VALOR = "crear-dueno";
    private static final String AYUDA_PARAMETROS = "parámetros";
    private static final String AYUDA_COMENTARIO = "Creas un dueno";
    private ControladorMascota controladorMascota;
    private final short tamano = 10;

    public crearMascotaExotica(ControladorMascota controladorMascota) {
        this.controladorMascota = controladorMascota;
    }
    @Override
    public void ejecutar(String[] parametros, Vista vista) {
        if(parametros.length != this.tamano){
            throw new RuntimeException("Numero de parametros incorrectos");
        }
        controladorMascota.crearMascotaExotica(parametros[0], parametros[1], parametros[2], parametros[4], parametros[5], null, null, null, null, null);
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
