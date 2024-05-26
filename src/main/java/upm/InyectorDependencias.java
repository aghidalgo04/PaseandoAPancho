package upm;

import upm.cli.CommandLineInterface;
import upm.cli.Vista;
import upm.cli.VistaConsola;
import upm.cli.comandos.comandos.*;
import upm.controlador.ControladorMascota;
import upm.controlador.ControladorUsuario;
import upm.controlador.Session;
import upm.data.persitencia.*;
import upm.data.persitencia.file.*;

public class InyectorDependencias {
    private static final InyectorDependencias inyectorDependencias = new InyectorDependencias();

    private final PersistenciaDueno persistenciaDueno;
    private final PersistenciaCuidador persistenciaCuidador;
    private final PersistenciaMascota persistenciaMascota;
    private final PersistenciaMascotaExotica persistenciaMascotaExotica;
    private final PersistenciaContratoCuidado persistenciaContratoCuidado;

    private final Session session;

    private final ControladorUsuario controladorUsuario;
    private final ControladorMascota controladorMascota;

    private final Vista vista;
    private final CommandLineInterface commandLineInterface;

    private final GestorErrores gestorErrores;

    private InyectorDependencias() {
        this.persistenciaDueno = new PersistenciaDuenoFile("duenos");
        this.persistenciaCuidador = new PersistenciaCuidadorFile("cuidadores");
        this.persistenciaMascota = new PersistenciaMascotaFile("mascotas");
        this.persistenciaMascotaExotica = new PersistenciaMascotaExoticaFile("mascotasExoticas");
        this.persistenciaContratoCuidado = new PersistenciaContratoCuidadoFile("contratosCuidado");

        this.session = new Session();

        this.controladorUsuario = new ControladorUsuario(this.persistenciaDueno, this.persistenciaCuidador, this.persistenciaMascota, this.persistenciaMascotaExotica,this.persistenciaContratoCuidado, this.session);
        this.controladorMascota = new ControladorMascota(this.persistenciaMascota, this.persistenciaMascotaExotica, this.session);

        this.vista = new VistaConsola();
        this.commandLineInterface = new CommandLineInterface(this.vista);
        this.inyectarComandos();

        this.gestorErrores = new GestorErrores(this.commandLineInterface, this.vista);
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

    public PersistenciaDueno getPersistenciaDueno() {
        return this.persistenciaDueno;
    }

    public PersistenciaCuidador getPersistenciaCuidador() {
        return this.persistenciaCuidador;
    }

    public PersistenciaMascota getPersistenciaMascota() {
        return this.persistenciaMascota;
    }

    public PersistenciaMascotaExotica getPersistenciaMascotaExotica() {return this.persistenciaMascotaExotica;}

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
