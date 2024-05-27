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
        controladorUsuario.registrarDueno("David","Lopez","a@upm.es","si", Idioma.Castellano, Plataforma.Facebook);
        assertEquals(persistenciaDueno.findById("a96a6a8b49d8d02e9d87d46b3be73232").get().getId(),"a96a6a8b49d8d02e9d87d46b3be73232");
        controladorUsuario.registrarDueno("Pedro","Guzman","a@upm.es","si", Idioma.Ingles, Plataforma.Google);
        assertEquals(persistenciaDueno.findById("776954193178dd00819748ddec0251de").get().getId(),"776954193178dd00819748ddec0251de");
        controladorUsuario.registrarDueno("Alex","Hidalgo","a@upm.es","si", Idioma.Catalan, Plataforma.Microsoft);
        assertEquals(persistenciaDueno.findById("b6b2c0ff0e2ce3b9f2a4b8822718ff44").get().getId(),"b6b2c0ff0e2ce3b9f2a4b8822718ff44");
        controladorUsuario.registrarDueno("Stefan","Ochshypok","a@upm.es","si", Idioma.Valenciano, Plataforma.Twitter);
        assertEquals(persistenciaDueno.findById("ab0206dc7b5b7607c21a256345f28cfd").get().getId(),"ab0206dc7b5b7607c21a256345f28cfd");
        controladorUsuario.registrarDueno("Alvaro","Pintado","a@upm.es","si", Idioma.Euskera, Plataforma.Facebook);
        assertEquals(persistenciaDueno.findById("0d14a6ce73b1f87f02535a23ef7dffdc").get().getId(),"0d14a6ce73b1f87f02535a23ef7dffdc");
        controladorUsuario.registrarDueno("Dani","McNeilis","a@upm.es","si", Idioma.Gallego, Plataforma.Facebook);
        assertEquals(persistenciaDueno.findById("61b57c5a099eaf4296b7a671dc637c9e").get().getId(),"61b57c5a099eaf4296b7a671dc637c9e");
    }

    @Test
    public void testRegistrarCuidador(){
        controladorUsuario.registrarCuidador("david","Lopez","a@upm.es","si", Idioma.Castellano, Plataforma.Facebook,null,"soy ese",15,"4564145165",null);
        assertEquals(persistenciaCuidador.findById("a8a9aff5f55133002b55c1682730344b").get().getId(),"a8a9aff5f55133002b55c1682730344b");
        controladorUsuario.registrarCuidador("pedro","Guzman","a@upm.es","si", Idioma.Ingles, Plataforma.Google,null,"soy ese",15,"4564145165",null);
        assertEquals(persistenciaCuidador.findById("b661edb9ab17323b8692ed3bce8aa421").get().getId(),"b661edb9ab17323b8692ed3bce8aa421");
        controladorUsuario.registrarCuidador("alex","Hidalgo","a@upm.es","si", Idioma.Catalan, Plataforma.Microsoft,null,"soy ese",15,"4564145165",null);
        assertEquals(persistenciaCuidador.findById("c879e1bd61b2ac3323db7226f0e896ca").get().getId(),"c879e1bd61b2ac3323db7226f0e896ca");
        controladorUsuario.registrarCuidador("stefan","Ochshypok","a@upm.es","si", Idioma.Valenciano, Plataforma.Twitter,null,"soy ese",15,"4564145165",null);
        assertEquals(persistenciaCuidador.findById("36a8d9d9685ad33a28d5ef2b86ae38f0").get().getId(),"36a8d9d9685ad33a28d5ef2b86ae38f0");
        controladorUsuario.registrarCuidador("alvaro","Pintado","a@upm.es","si", Idioma.Euskera, Plataforma.Facebook,null,"soy ese",15,"4564145165",null);
        assertEquals(persistenciaCuidador.findById("0d859f06778101081ce86f285f4f17c8").get().getId(),"0d859f06778101081ce86f285f4f17c8");
        controladorUsuario.registrarCuidador("dani","McNeilis","a@upm.es","si", Idioma.Gallego, Plataforma.Facebook,null,"soy ese",15,"4564145165",null);
        assertEquals(persistenciaCuidador.findById("c26d5b61c2f7287f0d785079b6bff5c3").get().getId(),"c26d5b61c2f7287f0d785079b6bff5c3");

    }
    @Test
    public void testLogin(){
        controladorUsuario.registrarDueno("A","B","a@upm.es","si", Idioma.Castellano, Plataforma.Facebook);
        controladorUsuario.login(Plataforma.Facebook);
        assertEquals(session.getUsuario().getId(),"3e7602399afc6d1205fb69b73b3d100c");
        controladorUsuario.registrarDueno("B","C","a@upm.es","si", Idioma.Castellano, Plataforma.Google);
        controladorUsuario.login(Plataforma.Google);
        assertEquals(session.getUsuario().getId(),"786c5fe1e193816f63eea4af3314e8f3");
        controladorUsuario.registrarDueno("C","D","a@upm.es","si", Idioma.Castellano, Plataforma.Microsoft);
        controladorUsuario.login(Plataforma.Microsoft);
        assertEquals(session.getUsuario().getId(),"8fd8b3b403761b7fce626b8994a91311");
        controladorUsuario.registrarDueno("D","E","a@upm.es","si", Idioma.Castellano, Plataforma.Twitter);
        controladorUsuario.login(Plataforma.Twitter);
        assertEquals(session.getUsuario().getId(),"b1a37a3ea4c7d23cc480109a14f1864b");
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
