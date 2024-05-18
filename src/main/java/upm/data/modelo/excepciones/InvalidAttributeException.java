package upm.data.modelo.excepciones;

public class InvalidAttributeException extends RuntimeException{
    private static final String DESCRIPTION = "Invalid Attribute Exception. Atributo fuera de rango";

    public InvalidAttributeException(String detail) {
        super(DESCRIPTION + " >>> " + detail);
    }
}