package upm.modelo;

import java.io.File;
import java.util.List;

public class MascotaExotica extends Mascota {
    private File certificadoLegal;
    private File certificadoSalud;
    private File libreEnfermedadesTransmisibles;

    public MascotaExotica(Long id, String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro, List albums, Foto fotoFavorita,
                          File certificadoLegal, File certificadoSalud, File libreEnfermedadesTransmisibles) {
        super(id,nombre, direccion, descripcion, codigoRIAC, polizaSeguro, albums, fotoFavorita);
        this.certificadoLegal = certificadoLegal;
        this.certificadoSalud = certificadoSalud;
        this.libreEnfermedadesTransmisibles = libreEnfermedadesTransmisibles;
    }

    public File getCertificadoLegal() {
        return certificadoLegal;
    }

    public File getCertificadoSalud() {
        return certificadoSalud;
    }

    public File getLibreEnfermedadesTransmisibles() {
        return libreEnfermedadesTransmisibles;
    }

    public void setCertificadoLegal(File certificadoLegal) {
        this.certificadoLegal = certificadoLegal;
    }

    public void setCertificadoSalud(File certificadoSalud) {
        this.certificadoSalud = certificadoSalud;
    }

    public void setLibreEnfermedadesTransmisibles(File libreEnfermedadesTransmisibles) {
        this.libreEnfermedadesTransmisibles = libreEnfermedadesTransmisibles;
    }

    public MascotaExotica(Long id, String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro, List albums, Foto fotoFavorita) {
        super(id, nombre, direccion, descripcion, codigoRIAC, polizaSeguro, albums, fotoFavorita);
    }

    public MascotaExotica(Long id, String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro, List albums) {
        super(id, nombre, direccion, descripcion, codigoRIAC, polizaSeguro, albums);
    }

    public MascotaExotica(Long id, String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro, Foto fotoFavorita) {
        super(id, nombre, direccion, descripcion, codigoRIAC, polizaSeguro, fotoFavorita);
    }

    public MascotaExotica(Long id, String nombre, String direccion, String descripcion, String codigoRIAC, String polizaSeguro) {
        super(id, nombre, direccion, descripcion, codigoRIAC, polizaSeguro);
    }

    public MascotaExotica(Long id, String nombre, String direccion, String descripcion, String codigoRIAC) {
        super(id, nombre, direccion, descripcion, codigoRIAC);
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public String getDireccion() {
        return super.getDireccion();
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion();
    }

    @Override
    public String getCodigoRIAC() {
        return super.getCodigoRIAC();
    }

    @Override
    public String getPolizaSeguro() {
        return super.getPolizaSeguro();
    }

    @Override
    public Foto getFotoFavorita() {
        return super.getFotoFavorita();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public void setDireccion(String direccion) {
        super.setDireccion(direccion);
    }

    @Override
    public void setDescripcion(String descripcion) {
        super.setDescripcion(descripcion);
    }

    @Override
    public void setCodigoRIAC(String codigoRIAC) {
        super.setCodigoRIAC(codigoRIAC);
    }

    @Override
    public void setPolizaSeguro(String polizaSeguro) {
        super.setPolizaSeguro(polizaSeguro);
    }

    @Override
    public void setFotoFavorita(Foto fotoFavorita) {
        super.setFotoFavorita(fotoFavorita);
    }

    @Override
    public void anadirAlbum(Album album) {
        super.anadirAlbum(album);
    }

    @Override
    public Album buscarAlbumPorId(Long id) {
        return super.buscarAlbumPorId(id);
    }

    @Override
    public void eliminarAlbum(Long id) {
        super.eliminarAlbum(id);
    }
}

