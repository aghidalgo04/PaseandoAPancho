package upm.cli.comandos.comandos;

import upm.cli.comandos.Comando;

public class listarMascotas implements Comando {
    private static final String VALOR = "listar-mascotas";
    private static final String AYUDA_PARAMETROS = "parámetros";
    private static final String AYUDA_COMENTARIO = "Muestras todas las mascotas disponibles";

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
