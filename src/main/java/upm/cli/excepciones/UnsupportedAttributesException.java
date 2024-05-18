package upm.cli.excepciones;

public class UnsupportedAttributesException extends RuntimeException {
    private static final String DESCRIPTION = "Unsupported Attributes Exception. Los atributos introducidos son erroneos";

    public UnsupportedAttributesException(String detail){
        super(DESCRIPTION + " >>> " + detail);
    }
}
