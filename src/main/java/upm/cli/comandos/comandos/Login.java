package upm.cli.comandos.comandos;

import upm.cli.Vista;
import upm.cli.comandos.Comando;
import upm.controlador.ControladorUsuario;

public class Login implements Comando {
    private static final String VALOR = "login";
    private static final String AYUDA_PARAMETROS = "parámetros"; // @Todo Completar con los parámetros que necesita para iniciar sesión con la plataforma que elija
    private static final String AYUDA_COMENTARIO = "Inicia sesión con la plataforma que eliges";
    private ControladorUsuario controladorUsuario;

    public Login(ControladorUsuario controladorUsuario) {
        this.controladorUsuario = controladorUsuario;
    }

    @Override
    public void ejecutar(String[] parametros, Vista vista) {
        controladorUsuario.login();
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
