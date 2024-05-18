package upm.cli;

import upm.cli.comandos.Comando;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandLineInterface {
    private static final String EXIT_NAME = "exit";
    private static final String EXIT_HELP = "termina la ejecución.";
    private static final String HELP_NAME = "ayuda";
    private static final String HELP_HELP = "muestra la ayuda.";
    private final Vista vista;
    private Map<String, Comando> comandos;

    public CommandLineInterface(Vista vista) {
        this.vista = vista;
        this.comandos = new HashMap<>();
    }

    public void addComando(Comando comando) {
        this.comandos.put(comando.valor(), comando);
    }

    public void help() {
        this.vista.mostrarComando(EXIT_NAME + EXIT_HELP);
        this.vista.mostrarComando(HELP_NAME + HELP_HELP);
        for (Comando comando : this.comandos.values()) {
            this.vista.mostrarComando(comando.valor() + comando.ayudaParametros() + comando.ayudaComentario());
        }
    }

    public boolean runComandos() {
        boolean exit = false;
        while (!exit) {
            exit = this.runComando();
        }
        return true;
    }

    private boolean runComando() {
        boolean exit = false;
        String[] input = this.vista.leerComando();

        if (HELP_NAME.equals(input[0])) {
            this.help();
        } else if (EXIT_NAME.equals(input[0])) {
            exit = true;
        } else {
            if (this.comandos.containsKey(input[0])) {
                this.comandos.get(input[0]).ejecutar(Arrays.copyOfRange(input, 1, input.length), this.vista);
            } else {
                throw new UnsupportedOperationException("Comando '" + input[0] + "' no existe.");
            }
        }

        return exit;
    }
}
