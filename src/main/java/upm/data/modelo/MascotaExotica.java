package upm.data.modelo;

import java.io.File;

public class MascotaExotica extends Mascota {
    private File certificadoLegal;
    private File certificadoSalud;
    private File libreEnfermedadesTransmisibles;

    public MascotaExotica() {
        super();
    }

    private MascotaExotica(Builder builder) {
        super(builder);
        this.certificadoLegal = builder.certificadoLegal;
        this.certificadoSalud = builder.certificadoSalud;
        this.libreEnfermedadesTransmisibles = builder.libreEnfermedadesTransmisibles;
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

    public static class Builder extends Mascota.Builder {
        private File certificadoLegal;
        private File certificadoSalud;
        private File libreEnfermedadesTransmisibles;

        public Builder() {

        }

        public Builder certificadoLegal(File certificadoLegal) {
            this.certificadoLegal = certificadoLegal;
            return this;
        }

        public Builder certificadoSalud(File certificadoSalud) {
            this.certificadoSalud = certificadoSalud;
            return this;
        }

        public Builder libreEnfermedadesTransmisibles(File libreEnfermedadesTransmisibles) {
            this.libreEnfermedadesTransmisibles = libreEnfermedadesTransmisibles;
            return this;
        }

        @Override
        public MascotaExotica build() {
            return new MascotaExotica(this);
        }
    }
}

