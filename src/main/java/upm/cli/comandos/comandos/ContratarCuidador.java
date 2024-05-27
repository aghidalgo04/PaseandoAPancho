package upm.cli.comandos.comandos;

import upm.cli.Vista;
import upm.cli.comandos.Comando;
import upm.cli.excepciones.UnsupportedAttributesException;
import upm.controlador.ControladorUsuario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContratarCuidador implements Comando {
    private static final String VALOR = "contratar-cuidador";
    private static final String AYUDA_PARAMETROS = "<idMascota>; <idCuidador>; <fechaInicioCuidado: [dd-MM-yyyy HH.mm]>; <fechaFinCuidado: [dd-MM-yyyy HH.mm]>";
    private static final String AYUDA_COMENTARIO = "Contratar cuidador para mascota de dueno";

    private static final byte NUMERO_PARAMETROS = 4;

    private ControladorUsuario controladorUsuario;

    public ContratarCuidador(ControladorUsuario controladorUsuario) {
        this.controladorUsuario = controladorUsuario;
    }

    @Override
    public void ejecutar(String[] parametros, Vista vista) {
        if (parametros.length != NUMERO_PARAMETROS) {
            throw new UnsupportedAttributesException(this.ayudaParametros());
        }
        if (Integer.parseInt(parametros[0]) < 1) {
            throw new UnsupportedAttributesException("El idMascota no puede cero o negativo");
        }
        if (parametros[1].equals("") || parametros[1] == null || parametros[1].equals(" ")) {
            throw new UnsupportedAttributesException("El idCuidador no puede ser nulo o vacío");
        }
        DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern("dd-MM-yyyy HH.mm");
        if (LocalDateTime.parse(parametros[2], dateTimeFormatter).isAfter(LocalDateTime.parse(parametros[3], dateTimeFormatter))) {
            throw new UnsupportedAttributesException("La fechaInicioCuidado debe ser anterior a la fechaFinCuidado");
        }
        this.controladorUsuario.contratarCuidador(Long.valueOf(parametros[0]), parametros[1], parametros[2], parametros[3]);
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
