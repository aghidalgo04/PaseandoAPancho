package upm.cli.comandos.comandos;

import upm.cli.comandos.Comando;

public class crearMascota implements Comando {
    private static final String VALOR = "crear-mascota";
    private static final String AYUDA_PARAMETROS = "parámetros";
    private static final String AYUDA_COMENTARIO = "Creas una mascota";

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
        return AYUDA_COMENTARIO;
    }
}
