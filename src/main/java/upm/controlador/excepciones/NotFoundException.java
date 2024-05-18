package upm.controlador.excepciones;

public class NotFoundException extends RuntimeException {
    private static final String DESCRIPTION = "Not Found Exception. El objeto no existe";

    public NotFoundException(String detail) {
        super(DESCRIPTION + " >>> " + detail);
    }
}
