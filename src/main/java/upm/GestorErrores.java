package upm;

import upm.cli.CommandLineInterface;
import upm.cli.Vista;

public class GestorErrores {
    private final CommandLineInterface commandLineInterface;
    private final Vista vista;

    public GestorErrores(CommandLineInterface commandLineInterface, Vista vista) {
        this.commandLineInterface = commandLineInterface;
        this.vista = vista;
    }

    public void run() {
        this.vista.mostarBienvenida();
        boolean exit = false;
        while (!exit) {
            try {
                exit = this.commandLineInterface.runComandos();
            } catch (Exception e) {
                this.vista.mostrarError(e.getMessage());
            }
        }
    }
}