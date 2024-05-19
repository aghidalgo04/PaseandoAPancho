package upm.controlador;

import upm.data.modelo.Cuidador;
import upm.data.modelo.Dueno;
import upm.data.modelo.Usuario;

public class Session {
    private Usuario usuario;

    public Session() {
        this.usuario = null;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean estaLogueado() {
        return this.usuario != null;
    }

    public boolean esDueno(){
        return this.usuario instanceof Dueno;
    }

    public boolean esCuidador(){
        return this.usuario instanceof Cuidador;
    }
}
