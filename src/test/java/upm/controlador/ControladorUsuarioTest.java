package upm.controlador;

import org.junit.Test;
import upm.InyectorDependencias;
import upm.data.modelo.enums.Idioma;
import upm.data.modelo.enums.Plataforma;
import upm.data.persitencia.PersistenciaContratoCuidado;
import upm.data.persitencia.PersistenciaCuidador;
import upm.data.persitencia.PersistenciaMascota;
import upm.data.persitencia.PersistenciaDueno;

import static org.junit.Assert.*;

public class ControladorUsuarioTest {
    private final ControladorUsuario controladorUsuario = InyectorDependencias.getInyectorDependencias().getControladorUsuario();
    private final ControladorMascota controladorMascota = InyectorDependencias.getInyectorDependencias().getControladorMascota();
    private final PersistenciaDueno persistenciaDueno = InyectorDependencias.getInyectorDependencias().getPersistenciaDueno();
    private final PersistenciaCuidador persistenciaCuidador = InyectorDependencias.getInyectorDependencias().getPersistenciaCuidador();
    private final PersistenciaContratoCuidado persistenciaContratoCuidado = InyectorDependencias.getInyectorDependencias().getPersistenciaContratoCuidado();
    private final PersistenciaMascota persistenciaMascota = InyectorDependencias.getInyectorDependencias().getPersistenciaMascota();
    private final Session session = InyectorDependencias.getInyectorDependencias().getSession();

    @Test
    public void testRegistrarDueno(){
        controladorUsuario.registrarDueno("david","Lopez","a@upm.es","si", Idioma.Castellano, Plataforma.Google);
        assertEquals(persistenciaDueno.findById("a8a9aff5f55133002b55c1682730344b").get().getId(),"a8a9aff5f55133002b55c1682730344b");
    }

    @Test
    public void testRegistrarCuidador(){
        controladorUsuario.registrarCuidador("alvaro","pintado","a@upm.es","si", Idioma.Castellano, Plataforma.Google,null,"soy ese",15,"4564145165",null);
        assertEquals(persistenciaCuidador.findById("0d859f06778101081ce86f285f4f17c8").get().getId(),"0d859f06778101081ce86f285f4f17c8");

    }
    @Test
    public void testLogin(){
        controladorUsuario.registrarCuidador("david","Lopez","a@upm.es","si", Idioma.Castellano, Plataforma.Google,null,"soy ese",15,"4564145165",null);
        controladorUsuario.login(Plataforma.Google);
        assertEquals(session.getUsuario().getId(),"a8a9aff5f55133002b55c1682730344b");
    }

    @Test
    public void testAniadirMascota(){
        controladorUsuario.login(Plataforma.Google);
        Long id = controladorMascota.crearMascota("Ely","sierra","Perro blanco", "0123456789","213u84871",null,null);
        controladorUsuario.anadirMascota(id);
        assertEquals(persistenciaDueno.findById("a8a9aff5f55133002b55c1682730344b").get().buscarMascota(id),persistenciaMascota.findById(id).get());
    }

    @Test
    public void testContratarCuidador(){
        controladorUsuario.login(Plataforma.Google);
        Long id = controladorMascota.crearMascota("Ely","sierra","Perro blanco", "0123456789","213u84871",null,null);
        controladorUsuario.anadirMascota(id);
        controladorUsuario.contratarCuidador(id,"0d859f06778101081ce86f285f4f17c8","01-01-2025 16.20","03-01-2025 17.30");
        Integer id1 = persistenciaContratoCuidado.findAll().size();
        assertTrue(persistenciaCuidador.findById("0d859f06778101081ce86f285f4f17c8").get().getContratos().contains(persistenciaContratoCuidado.findById(id1.longValue()).get()));
    }

}
