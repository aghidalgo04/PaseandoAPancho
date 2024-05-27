package upm.cli.comandos.comandos;

import upm.cli.Vista;
import upm.cli.comandos.Comando;
import upm.cli.excepciones.UnsupportedAttributesException;
import upm.controlador.ControladorUsuario;
import upm.data.modelo.enums.Idioma;
import upm.data.modelo.enums.Plataforma;

public class CrearDueno implements Comando {
    private static final String VALOR = "crear-dueno";
    private static final String AYUDA_PARAMETROS = "<nombre>; <apellidos>; <correoElectronico>; <direccion>; <idioma: [Castellano, Ingles, Catalan, Valenciano, Euskera, Gallego]>; <plataformaRegistro: [Facebook, Google, Microsoft, Twitter]>";
    private static final String AYUDA_COMENTARIO = "Creas un dueno";

    private static final byte NUMERO_PARAMETROS = 6;

    private ControladorUsuario controladorUsuario;

    public CrearDueno(ControladorUsuario controladorUsuario) {
        this.controladorUsuario = controladorUsuario;
    }

    @Override
    public void ejecutar(String[] parametros, Vista vista) {
        if (parametros.length != NUMERO_PARAMETROS) {
            throw new UnsupportedAttributesException(this.ayudaParametros());
        }
        for (int i = 0; i < 4; i++) {
            if (parametros[i].equals("") || parametros[i] == null || parametros[i].equals(" ")) {
                throw new UnsupportedAttributesException("El nombre, apellidos, correo o dirección no puede ser nulo o vacío");
            }
        }
        this.controladorUsuario.registrarDueno(parametros[0], parametros[1], parametros[2], parametros[3], Idioma.valueOf(parametros[4]), Plataforma.valueOf(parametros[5]));
        vista.mostarMensaje("Cuenta creada con exito");
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
