package upm.cli.comandos.comandos;

import upm.cli.Vista;
import upm.cli.comandos.Comando;
import upm.controlador.ControladorMascota;
import upm.data.modelo.Mascota;

import java.util.List;

public class ListarMascotas implements Comando {
    private static final String VALOR = "listar-mascotas";
    private static final String AYUDA_PARAMETROS = "";
    private static final String AYUDA_COMENTARIO = "Muestras todas las mascotas de dueno o que cuida el cuidador depende de rol";

    private final ControladorMascota controladorMascota;

    public ListarMascotas(ControladorMascota controladorMascota) {
        this.controladorMascota = controladorMascota;
    }

    @Override
    public void ejecutar(String[] parametros, Vista vista) {
        List<Mascota> mascotas = this.controladorMascota.listarMascotas();
        for (Mascota mascota : mascotas) {
            vista.mostrarMascota(mascota.getId(), mascota.getNombre(), mascota.getDireccion(), mascota.getDescripcion());
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
