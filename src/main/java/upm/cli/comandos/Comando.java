package upm.cli.comandos;

public interface Comando {
    void ejecutar(String[] parametros);

    String valor();

    String ayudaParametros();

    String ayudaComentario();
}
