package upm.cli.comandos.comandos;

import upm.cli.comandos.Comando;

public class Login implements Comando {
    private static final String VALOR = "login";
    private static final String AYUDA_PARAMETROS = "parámetros";
    private static final String AYUDA_COMENTARIO = "Inicia sesión con la plataforma que eliges";

    @Override
    public void ejecutar(String[] parametros) {

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
