package upm.controlador;

import org.junit.Test;
import upm.InyectorDependencias;
import upm.data.modelo.enums.Idioma;
import upm.data.modelo.enums.Plataforma;
import upm.data.persitencia.PersistenciaCuidador;
import upm.data.persitencia.PersistenciaMascota;
import upm.data.persitencia.PersistenciaDueno;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ControladorUsuarioTest {
    private final ControladorUsuario controladorUsuario = InyectorDependencias.getInyectorDependencias().getControladorUsuario();
    private final ControladorMascota controladorMascota = InyectorDependencias.getInyectorDependencias().getControladorMascota();
    private final PersistenciaDueno persistenciaDueno = InyectorDependencias.getInyectorDependencias().getPersistenciaDueno();
    private final PersistenciaCuidador persistenciaCuidador = InyectorDependencias.getInyectorDependencias().getPersistenciaCuidador();
    private final PersistenciaMascota persistenciaMascota = InyectorDependencias.getInyectorDependencias().getPersistenciaMascota();
    private final Session session = InyectorDependencias.getInyectorDependencias().getSession();

    @Test
    public void testRegistrarDueno(){
        controladorUsuario.registrarDueno("david","Lopez","a@upm.es","si", Idioma.Castellano, Plataforma.Google);
        assertEquals(persistenciaDueno.findById("a8a9aff5f55133002b55c1682730344b").get().getId(),"a8a9aff5f55133002b55c1682730344b");
    }

    @Test
    public void testRegistrarCuidador(){
        controladorUsuario.registrarCuidador("david","Lopez","a@upm.es","si", Idioma.Castellano, Plataforma.Google,null,"soy ese",15,"4564145165",null);
        assertEquals(persistenciaCuidador.findById("a8a9aff5f55133002b55c1682730344b").get().getId(),"a8a9aff5f55133002b55c1682730344b");

    }
    @Test
    public void testLogin(){
        controladorUsuario.registrarCuidador("david","Lopez","a@upm.es","si", Idioma.Castellano, Plataforma.Google,null,"soy ese",15,"4564145165",null);
        controladorUsuario.login(Plataforma.Google);
        assertEquals(session.getUsuario().getId(),"a8a9aff5f55133002b55c1682730344b");
    }

    @Test
    public void testAniadirMascota(){
        controladorUsuario.registrarDueno("david","Lopez","a@upm.es","si", Idioma.Castellano, Plataforma.Google);
        controladorUsuario.login(Plataforma.Google);
        controladorMascota.crearMascota("Ely","sierra","Perro blanco", "0123456789","213u84871",null,null);
        assertNotNull(this.persistenciaMascota.findById(2L));
        //controladorUsuario.anadirMascota(2L);
        //assertEquals(persistenciaUsuario.findDueno("a8a9aff5f55133002b55c1682730344b").get().buscarMascota(2L),persistenciaMascota.findById(2L));
    }

    @Test
    public void testContratarCuidador(){}

}
