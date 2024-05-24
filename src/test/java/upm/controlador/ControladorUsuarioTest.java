package upm.controlador;

import org.junit.Test;
import servidor.ExternalRIAC;
import servidor.ExternalRRSS;
import upm.InyectorDependencias;
import upm.data.modelo.Dueno;
import upm.data.modelo.enums.Idioma;
import upm.data.modelo.enums.Plataforma;
import upm.data.persitencia.PersistenciaMascota;
import upm.data.persitencia.PersistenciaUsuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ControladorUsuarioTest {
    private final ControladorUsuario controladorUsuario = InyectorDependencias.getInyectorDependencias().getControladorUsuario();
    private final ControladorMascota controladorMascota = InyectorDependencias.getInyectorDependencias().getControladorMascota();
    private final PersistenciaUsuario persistenciaUsuario = InyectorDependencias.getInyectorDependencias().getPersistenciaUsuario();
    private final PersistenciaMascota persistenciaMascota = InyectorDependencias.getInyectorDependencias().getPersistenciaMascota();
    private final Session session = InyectorDependencias.getInyectorDependencias().getSession();

    @Test
    public void testRegistrarDueno(){
        controladorUsuario.registrarDueno("david","Lopez","a@upm.es","si", Idioma.Castellano, Plataforma.Google);
        assertEquals(persistenciaUsuario.findDueno("a8a9aff5f55133002b55c1682730344b").get().getId(),"a8a9aff5f55133002b55c1682730344b");
    }

    @Test
    public void testRegistrarCuidador(){
        controladorUsuario.registrarCuidador("david","Lopez","a@upm.es","si", Idioma.Castellano, Plataforma.Google,null,"soy ese",15,"4564145165",null);
        assertEquals(persistenciaUsuario.findCuidador("a8a9aff5f55133002b55c1682730344b").get().getId(),"a8a9aff5f55133002b55c1682730344b");

    }
    @Test
    public void testLogin(){
        controladorUsuario.registrarCuidador("david","Lopez","a@upm.es","si", Idioma.Castellano, Plataforma.Google,null,"soy ese",15,"4564145165",null);
        controladorUsuario.login();
        assertEquals(session.getUsuario().getId(),"a8a9aff5f55133002b55c1682730344b");
    }

    @Test
    public void testAniadirMascota(){
        controladorUsuario.registrarDueno("david","Lopez","a@upm.es","si", Idioma.Castellano, Plataforma.Google);
        controladorUsuario.login();
        controladorMascota.crearMascota("Ely","sierra","Perro blanco", "0123456789","213u84871",null,null);
        assertNotNull(this.persistenciaMascota.findById(2L));
        //controladorUsuario.anadirMascota(2L);
        //assertEquals(persistenciaUsuario.findDueno("a8a9aff5f55133002b55c1682730344b").get().buscarMascota(2L),persistenciaMascota.findById(2L));
    }

    @Test
    public void testContratarCuidador(){}

}
