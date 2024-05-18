package upm;

import upm.cli.CommandLineInterface;
import upm.cli.Vista;
import upm.cli.VistaConsola;
import upm.cli.comandos.Session;
import upm.controlador.ControladorMascota;
import upm.controlador.ControladorUsuario;
import upm.data.persitencia.PersistenciaContratoCuidado;
import upm.data.persitencia.PersistenciaMascota;
import upm.data.persitencia.PersistenciaUsuario;
import upm.data.persitencia.map.PersistenciaContratoCuidadoMap;
import upm.data.persitencia.map.PersistenciaMascotaMap;
import upm.data.persitencia.map.PersistenciaUsuarioMap;

public class InyectorDependencias {
    private static final InyectorDependencias inyectorDependencias = new InyectorDependencias();

    private final PersistenciaUsuario persistenciaUsuario;
    private final PersistenciaMascota persistenciaMascota;
    private final PersistenciaContratoCuidado persistenciaContratoCuidado;

    private final Session session;

    private final ControladorUsuario controladorUsuario;
    private final ControladorMascota controladorMascota;

    private final Vista vista;
    private final CommandLineInterface commandLineInterface;

    private final GestorErrores gestorErrores;

    private InyectorDependencias() {
        this.persistenciaUsuario = new PersistenciaUsuarioMap();
        this.persistenciaMascota = new PersistenciaMascotaMap();
        this.persistenciaContratoCuidado = new PersistenciaContratoCuidadoMap("contratoCuidados");

        this.session = new Session();

        this.controladorUsuario = new ControladorUsuario(this.persistenciaUsuario, this.persistenciaMascota, this.persistenciaContratoCuidado, this.session);
        this.controladorMascota = new ControladorMascota(this.persistenciaMascota);

        this.vista = new VistaConsola();
        this.commandLineInterface = new CommandLineInterface(this.vista);

        this.gestorErrores = new GestorErrores(this.commandLineInterface, this.vista);
    }

    public static InyectorDependencias getInyectorDependencias() {
        return inyectorDependencias;
    }

    public void run() {
        this.gestorErrores.run();
    }

    public PersistenciaUsuario getPersistenciaUsuario() {
        return this.persistenciaUsuario;
    }

    public PersistenciaMascota getPersistenciaMascota() {
        return this.persistenciaMascota;
    }

    public PersistenciaContratoCuidado getPersistenciaContratoCuidado() {
        return this.persistenciaContratoCuidado;
    }

    public ControladorUsuario getControladorUsuario() {
        return this.controladorUsuario;
    }

    public ControladorMascota getControladorMascota() {
        return this.controladorMascota;
    }

    public CommandLineInterface getCommandLineInterface() {
        return this.commandLineInterface;
    }

    public Vista getVista() {
        return this.vista;
    }

    public Session getSession() {
        return session;
    }

    public GestorErrores getGestorErrores() {
        return this.gestorErrores;
    }
}
