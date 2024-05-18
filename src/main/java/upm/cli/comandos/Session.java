package upm.cli.comandos;

import upm.data.modelo.Usuario;

public class Session {
    private Usuario usuario = null;

    public Session() {
        this.usuario = null;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuarioLogueado(Usuario usuarioLogueado) {
        this.usuario = usuario;
    }
}
