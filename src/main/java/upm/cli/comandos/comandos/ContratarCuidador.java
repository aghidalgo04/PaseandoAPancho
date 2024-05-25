package upm.cli.comandos.comandos;

import upm.cli.Vista;
import upm.cli.comandos.Comando;
import upm.cli.excepciones.UnsupportedAttributesException;
import upm.controlador.ControladorUsuario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContratarCuidador implements Comando {
    private static final String VALOR = "contratar-cuidador";
    private static final String AYUDA_PARAMETROS = "<idMascota>, <idCuidador>, <fechaInicioCuidado>, <fechaFinCuidado>";
    private static final String AYUDA_COMENTARIO = "Contratar cuidador para mascota de dueno";

    private static final byte NUMERO_PARAMETROS = 5;

    private ControladorUsuario controladorUsuario;

    public ContratarCuidador(ControladorUsuario controladorUsuario) {
        this.controladorUsuario = controladorUsuario;
    }
    @Override
    public void ejecutar(String[] parametros, Vista vista) {
        if (parametros.length != NUMERO_PARAMETROS) {
            throw new UnsupportedAttributesException(this.ayudaParametros());
        }
        DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.controladorUsuario.contratarCuidador(Long.valueOf(parametros[0]), parametros[1], LocalDateTime.parse(parametros[3], dateTimeFormatter), LocalDateTime.parse(parametros[4], dateTimeFormatter));
        vista.mostarMensaje("Contrato creado pero no pagado");
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
