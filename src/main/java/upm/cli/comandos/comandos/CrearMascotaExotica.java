package upm.cli.comandos.comandos;

import upm.cli.Vista;
import upm.cli.comandos.Comando;
import upm.cli.excepciones.UnsupportedAttributesException;
import upm.controlador.ControladorMascota;
import upm.controlador.ControladorUsuario;
import upm.data.modelo.excepciones.InvalidAttributeException;

import java.io.File;

public class CrearMascotaExotica implements Comando {
    private static final String VALOR = "aniadir-mascota-exotica";
    private static final String AYUDA_PARAMETROS = "<nombre>; <direccion>; <descripcion>; <codigoRIAC>; <certificadoLegal>; <certificadoSalud>; <libreEnfermedadesTransmisibles>; <polizaSeguro>; <albums>; <fotoFavorita>";
    private static final String AYUDA_COMENTARIO = "Aniades una mascota exótica";

    private static final byte NUMERO_PARAMETROS = 10;

    private final ControladorMascota controladorMascota;
    private final ControladorUsuario controladorUsuario;

    public CrearMascotaExotica(ControladorUsuario controladorUsuario,ControladorMascota controladorMascota) {
        this.controladorMascota = controladorMascota;
        this.controladorUsuario = controladorUsuario;
    }

    @Override
    public void ejecutar(String[] parametros, Vista vista) {
        if (parametros.length != NUMERO_PARAMETROS) {
            throw new UnsupportedAttributesException(this.ayudaParametros());
        }
        if((!parametros[4].contains(".")) || (!parametros[5].contains(".")) || !parametros[6].contains(".")){
            throw new InvalidAttributeException("No has introducido bien todos los certificados");
        }
        this.controladorUsuario.anadirMascota(this.controladorMascota.crearMascotaExotica(parametros[0], parametros[1], parametros[2], parametros[3], new File(parametros[4]), new File(parametros[5]), new File(parametros[6]), parametros[7], null, null));
        vista.mostarMensaje("Mascota exotica creada con exito");
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
