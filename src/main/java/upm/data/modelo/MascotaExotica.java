package upm.data.modelo;

import java.io.File;
import java.util.List;

public class MascotaExotica extends Mascota {
    private File certificadoLegal;
    private File certificadoSalud;
    private File libreEnfermedadesTransmisibles;

    public MascotaExotica(Long id, String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro, List<Album> albums, Foto fotoFavorita, File certificadoLegal, File certificadoSalud, File libreEnfermedadesTransmisibles) {
        super(id, nombre, direccion, descripcion, codigoRIAC, polizaSeguro, albums, fotoFavorita);
        this.certificadoLegal = certificadoLegal;
        this.certificadoSalud = certificadoSalud;
        this.libreEnfermedadesTransmisibles = libreEnfermedadesTransmisibles;
    }

    public File getCertificadoLegal() {
        return this.certificadoLegal;
    }

    public void setCertificadoLegal(File certificadoLegal) {
        this.certificadoLegal = certificadoLegal;
    }

    public File getCertificadoSalud() {
        return this.certificadoSalud;
    }

    public void setCertificadoSalud(File certificadoSalud) {
        this.certificadoSalud = certificadoSalud;
    }

    public File getLibreEnfermedadesTransmisibles() {
        return this.libreEnfermedadesTransmisibles;
    }

    public void setLibreEnfermedadesTransmisibles(File libreEnfermedadesTransmisibles) {
        this.libreEnfermedadesTransmisibles = libreEnfermedadesTransmisibles;
    }
}

