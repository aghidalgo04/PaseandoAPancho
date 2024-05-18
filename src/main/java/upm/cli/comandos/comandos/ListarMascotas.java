package upm.cli.comandos.comandos;

import upm.cli.Vista;
import upm.cli.comandos.Comando;
import upm.controlador.ControladorMascota;

public class ListarMascotas implements Comando {
    private static final String VALOR = "listar-mascotas";
    private static final String AYUDA_PARAMETROS = "()";
    private static final String AYUDA_COMENTARIO = "Muestras todas las mascotas disponibles";

    private final ControladorMascota controladorMascota;

    public ListarMascotas(ControladorMascota controladorMascota) {
        this.controladorMascota = controladorMascota;
    }

    @Override
    public void ejecutar(String[] parametros, Vista vista) {
        this.controladorMascota.listarMascotas();
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
