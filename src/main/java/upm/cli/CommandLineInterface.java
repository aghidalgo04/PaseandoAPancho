package upm.cli;

import upm.cli.comandos.Comando;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandLineInterface {
    private final Vista vista;
    private Map<String, Comando> comandos;

    public CommandLineInterface(Vista vista) {
        this.vista = vista;
        this.comandos = new HashMap<>();
    }

    public void addComando(Comando comando) {
        this.comandos.put(comando.valor(), comando);
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
        String[] input = vista.leerComando();

        if (VALOR_HELP.equals(input[0])) {
            this.ayuda();
        } else if (VALOR_EXIT.equals(input[0])) {
            exit = true;
        } else {
            if (this.comandos.containsKey(input[0])) {
                this.comandos.get(input[0]).ejecutar(Arrays.copyOfRange(input, 1, input.length));
            } else {
                throw new UnsupportedOperationException("Comando '" + input[0] + "' no existe.");
            }
        }

        return exit;
    }
}
