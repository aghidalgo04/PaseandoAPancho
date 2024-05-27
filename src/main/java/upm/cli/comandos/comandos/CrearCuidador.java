package upm.cli.comandos.comandos;

import upm.cli.Vista;
import upm.cli.comandos.Comando;
import upm.cli.excepciones.UnsupportedAttributesException;
import upm.controlador.ControladorUsuario;
import upm.data.modelo.enums.Idioma;
import upm.data.modelo.enums.Plataforma;

import java.io.File;

public class CrearCuidador implements Comando {
    private static final String VALOR = "crear-cuidador";
    private static final String AYUDA_PARAMETROS = "<nombre>; <apellidos>; <correoElectronico>; <direccion>; <idioma: [Castellano, Ingles, Catalan, Valenciano, Euskera, Gallego]>; <plataformaRegistro: [Facebook, Google, Microsoft, Twitter]>; <foto>; <descripcion>; <precio>; <IBAN>; <documentacion>";
    private static final String AYUDA_COMENTARIO = "Creas un cuidador";

    private static final byte NUMERO_PARAMETROS_MIN = 10;
    private static final byte NUMERO_PARAMETROS_MAX = 11;

    private ControladorUsuario controladorUsuario;

    public CrearCuidador(ControladorUsuario controladorUsuario) {
        this.controladorUsuario = controladorUsuario;
    }

    @Override
    public void ejecutar(String[] parametros, Vista vista) {
        if (parametros.length != NUMERO_PARAMETROS_MIN && parametros.length != NUMERO_PARAMETROS_MAX) {
            throw new UnsupportedAttributesException(this.ayudaParametros());
        }
        for (int i = 0; i < 4; i++) {
            if (parametros[i].equals("") || parametros[i] == null || parametros[i].equals(" ")) {
                throw new UnsupportedAttributesException("El nombre, apellidos, correo o dirección no puede ser nulo o vacío");
            }
        }
        if (parametros[6].equals("") || parametros[6] == null || parametros[6].equals(" ")) {
            throw new UnsupportedAttributesException("Necesitas una foto");
        }
        if (parametros[7].equals("") || parametros[7] == null || parametros[7].equals(" ")) {
            throw new UnsupportedAttributesException("La descripción no puede ser nula o vacía");
        }
        if (Integer.parseInt(parametros[8]) < 0) {
            throw new UnsupportedAttributesException("El precio no puede ser negativo");
        }
        if (parametros[9].length() != 10) {
            throw new UnsupportedAttributesException("El IBAN tiene que tener 10 caracteres");
        }
        if (parametros.length == NUMERO_PARAMETROS_MIN) {
            this.controladorUsuario.registrarCuidador(parametros[0], parametros[1], parametros[2], parametros[3], Idioma.valueOf(parametros[4]), Plataforma.valueOf(parametros[5]), new File(parametros[6]), parametros[7], Integer.parseInt(parametros[8]), parametros[9], null);
        } else {
            this.controladorUsuario.registrarCuidador(parametros[0], parametros[1], parametros[2], parametros[3], Idioma.valueOf(parametros[4]), Plataforma.valueOf(parametros[5]), new File(parametros[6]), parametros[7], Integer.parseInt(parametros[8]), parametros[9], null);
        }
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

