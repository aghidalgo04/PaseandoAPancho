package upm.cli.comandos.comandos;

import jdk.vm.ci.meta.Local;
import upm.cli.Vista;
import upm.cli.comandos.Comando;
import upm.controlador.ControladorUsuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class contratarCuidador implements Comando {
    private static final String VALOR = "crear-dueno";
    private static final String AYUDA_PARAMETROS = "(idMascota, idDueno, idCuidador, fechaInicioCuidado, fechaFinCuidado)";
    private static final String AYUDA_COMENTARIO = "Creas un dueno";
    private ControladorUsuario controladorUsuario;
    private final short tamano = 5;

    public contratarCuidador(ControladorUsuario controladorUsuario) {
        this.controladorUsuario = controladorUsuario;
    }
    @Override
    public void ejecutar(String[] parametros, Vista vista) {
        if (parametros.length != tamano) {
            throw new RuntimeException("Numero de parametros incorrectos"); // @TODO cambiar por exception personal
        }
        LocalDateTime fechaInicio, fechaFinal;
        DateTimeFormatter dtf;
        try {
            dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            fechaInicio = LocalDateTime.parse(parametros[3], dtf);
            fechaFinal = LocalDateTime.parse(parametros[4], dtf);
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Error en el formato de la fecha (dia-mes-año)"); // @TODO cambiar por exception personal
        }
        this.controladorUsuario.contratarCuidador(Long.valueOf(parametros[0]), parametros[1], parametros[2], fechaInicio, fechaFinal);
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
