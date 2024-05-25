package upm.cli.comandos.comandos;

import upm.cli.Vista;
import upm.cli.comandos.Comando;
import upm.cli.excepciones.UnsupportedAttributesException;
import upm.controlador.ControladorUsuario;
import upm.data.modelo.enums.Plataforma;

public class Login implements Comando {
    private static final String VALOR = "login";
    private static final String AYUDA_PARAMETROS = "(plataforma [Facebook, Google, Microsoft, Twitter])"; // @Todo Completar con los parámetros que necesita para iniciar sesión con la plataforma que elija
    private static final String AYUDA_COMENTARIO = "Inicia sesión con la plataforma que eliges";

    private static final byte NUMERO_PARAMETROS = 1;

    private final ControladorUsuario controladorUsuario;

    public Login(ControladorUsuario controladorUsuario) {
        this.controladorUsuario = controladorUsuario;
    }

    @Override
    public void ejecutar(String[] parametros, Vista vista) {
        if (parametros.length != NUMERO_PARAMETROS) {
            throw new UnsupportedAttributesException("Numero de parametros incorrectos");
        }
        this.controladorUsuario.login(Plataforma.valueOf(parametros[0]));
        vista.mostarMensaje("Login exitoso");
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
