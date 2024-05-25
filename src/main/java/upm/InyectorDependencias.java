package upm;

import upm.cli.CommandLineInterface;
import upm.cli.Vista;
import upm.cli.VistaConsola;
import upm.cli.comandos.comandos.*;
import upm.controlador.ControladorMascota;
import upm.controlador.ControladorUsuario;
import upm.controlador.Session;
import upm.data.persitencia.PersistenciaContratoCuidado;
import upm.data.persitencia.PersistenciaMascota;
import upm.data.persitencia.PersistenciaUsuario;
import upm.data.persitencia.Poblador;
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

    private final Poblador poblador; // DEV

    private InyectorDependencias() {
        this.persistenciaUsuario = new PersistenciaUsuarioMap("dueno", "cuidador");
        this.persistenciaMascota = new PersistenciaMascotaMap("mascota");
        this.persistenciaContratoCuidado = new PersistenciaContratoCuidadoMap("contratoCuidados");

        this.session = new Session();

        this.controladorUsuario = new ControladorUsuario(this.persistenciaUsuario, this.persistenciaMascota, this.persistenciaContratoCuidado, this.session);
        this.controladorMascota = new ControladorMascota(this.persistenciaMascota, this.session);

        this.vista = new VistaConsola();
        this.commandLineInterface = new CommandLineInterface(this.vista);
        this.inyectarComandos();

        this.gestorErrores = new GestorErrores(this.commandLineInterface, this.vista);

        // DEV
        this.poblador = new Poblador(this.persistenciaUsuario);
        this.poblador.seed();
    }

    private void inyectarComandos() {
        this.commandLineInterface.addComando(new Login(this.controladorUsuario));
        this.commandLineInterface.addComando(new ListarMascotas(this.controladorMascota));
        this.commandLineInterface.addComando(new CrearMascotaExotica(this.controladorUsuario, this.controladorMascota));
        this.commandLineInterface.addComando(new CrearMascota(this.controladorUsuario, this.controladorMascota));
        this.commandLineInterface.addComando(new CrearDueno(this.controladorUsuario));
        this.commandLineInterface.addComando(new CrearCuidador(this.controladorUsuario));
        this.commandLineInterface.addComando(new ContratarCuidador(this.controladorUsuario));
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
        return this.session;
    }

    public GestorErrores getGestorErrores() {
        return this.gestorErrores;
    }
}
