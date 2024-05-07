package upm.cli;

import java.util.Scanner;

public class VistaConsola implements Vista{
    private static final String DELIMITER_COLON_OR_RETURN = "[:,\\r\\n]";

    private final Scanner scanner;

    public VistaConsola(){
        this.scanner = new Scanner(System.in).useDelimiter(DELIMITER_COLON_OR_RETURN);
    }

}
