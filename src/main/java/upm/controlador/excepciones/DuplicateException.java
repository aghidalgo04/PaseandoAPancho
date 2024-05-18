package upm.controlador.excepciones;

public class DuplicateException extends RuntimeException {
    private static final String DESCRIPTION = "Duplicate Exception. El atributo debe ser unico";

    public DuplicateException(String detail) {
        super(DESCRIPTION + " >>> " + detail);
    }
}
