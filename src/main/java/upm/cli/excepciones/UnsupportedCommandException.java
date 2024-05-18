package upm.cli.excepciones;

public class UnsupportedCommandException extends RuntimeException {
    private static final String DESCRIPTION = "Unsupported Command Exception. El comando introducido no existe";

    public UnsupportedCommandException(String detail) {
        super(DESCRIPTION + " >>> " + detail);
    }
}
