package upm.data.persitencia.adaptadores;

import upm.data.modelo.Cuidador;

import java.io.File;
import java.util.List;

public class AdaptadorCuidador extends AdaptadorUsuario{
    private File foto;
    private String descripcion;
    private Integer precio;
    private String IBAN;
    private List<File> documentacion;
    private Integer panchoPuntos;
    private List<Long> mascotasFavoritasId;
    private List<Long> contratosId;
    private List<Long> premiosId;

    public AdaptadorCuidador(Cuidador cuidador) {
        super(cuidador);
        this.foto = cuidador.getFoto();
        this.descripcion = cuidador.getDescripcion();
        this.precio = cuidador.getPrecio();
        this.IBAN = cuidador.getIBAN();
        this.documentacion = cuidador.getDocumentacion();
        this.panchoPuntos = cuidador.getPanchoPuntos();
        this.mascotasFavoritasId = cuidador.getIdMascotasFavoritas();
        this.contratosId = cuidador.getIdContratos();
        this.premiosId = cuidador.getIdPremios();
    }

    public Cuidador getCuidador() {
        return new Cuidador(super.getId(), super.getNombre(), super.getApellidos(), super.getCorreoElectronico(), super.getDireccion(), super.getIdioma(), super.getPlataformaRegistro(), this.foto, this.descripcion, this.precio, this.IBAN, this.documentacion);
    }
}
