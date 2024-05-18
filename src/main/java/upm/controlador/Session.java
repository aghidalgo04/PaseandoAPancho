package upm.controlador;

import upm.data.modelo.Usuario;

public class Session {
    private Usuario usuario;

    public Session() {
        this.usuario = null;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuarioLogueado(Usuario usuarioLogueado) {
        this.usuario = usuarioLogueado;
    }
}
