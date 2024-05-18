package upm.controlador.excepciones;

public class SecurityProhibitionException extends RuntimeException {
    private static final String DESCRIPTION = "Security Prohibition Exception. No estás autorizado";

    public SecurityProhibitionException(String detail) {
        super(DESCRIPTION + " >>> " + detail);
    }
}
