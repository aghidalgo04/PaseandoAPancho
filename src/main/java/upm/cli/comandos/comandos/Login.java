package upm.cli.comandos.comandos;

import upm.cli.Vista;
import upm.cli.comandos.Comando;
import upm.cli.comandos.Session;
import upm.controlador.ControladorUsuario;

public class Login implements Comando {
    private static final String VALOR = "login";
    private static final String AYUDA_PARAMETROS = "parámetros";
    private static final String AYUDA_COMENTARIO = "Inicia sesión con la plataforma que eliges";
    private ControladorUsuario controladorUsuario;
    private Session sesion;

    public Login(ControladorUsuario controladorUsuario, Session sesion) {
        this.controladorUsuario = controladorUsuario;
        this.sesion = sesion;
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
