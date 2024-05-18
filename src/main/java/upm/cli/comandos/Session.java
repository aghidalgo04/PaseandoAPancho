package upm.cli.comandos;

import upm.data.modelo.Usuario;

public class Session {
    private Usuario usuario;

    public Session(Usuario usuario) {
        this.usuario = usuario;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
