package upm.cli.comandos.comandos;

import upm.cli.comandos.Comando;
import upm.data.modelo.Usuario;

public class crearUsuario implements Comando {
    private static final String VALOR = "crear-usuario";
    private static final String AYUDA_PARAMETROS = "parámetros";
    private static final String AYUDA_COMENTARIO = "Creas un usuario";

    @Override
    public void ejecutar(String[] parametros) {
        //AQUI ES DONDE VA EL CÓDIGO
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
        return "";
    }
}
