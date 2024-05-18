package upm.cli.comandos;

import upm.cli.Vista;

public interface Comando {
    void ejecutar(String[] parametros, Vista vista);

    String valor();

    String ayudaParametros();

    String ayudaComentario();
}
