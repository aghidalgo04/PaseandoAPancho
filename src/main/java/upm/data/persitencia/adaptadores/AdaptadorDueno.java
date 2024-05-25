package upm.data.persitencia.adaptadores;

import upm.data.modelo.Cuidador;
import upm.data.modelo.Dueno;
import upm.data.modelo.Mascota;
import upm.data.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorDueno extends AdaptadorUsuario{

    private final List<String> cuidadoresFavoritosId;
    private final List<Long> mascotasId;

    public AdaptadorDueno(Dueno dueno) {
        super(dueno);
        this.cuidadoresFavoritosId = dueno.getIdCuidadoresFavoritos();
        this.mascotasId = dueno.getIdMascotas();
    }

    public Dueno getDueno(){
        return new Dueno(super.getId(), super.getNombre(), super.getApellidos(), super.getCorreoElectronico(), super.getDireccion(), super.getIdioma(), super.getPlataformaRegistro());
    }
}
