package upm.controlador.excepciones;

public class SecurityAuthorizationException extends RuntimeException{
    private static final String DESCRIPTION = "Security Authorization Exception. No estás registrado";

    public SecurityAuthorizationException(String detail){
        super(DESCRIPTION + " >>> " + detail);
    }
}
