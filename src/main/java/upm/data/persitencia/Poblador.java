package upm.data.persitencia;

import upm.data.modelo.Cuidador;
import upm.data.modelo.Dueno;
import upm.data.modelo.enums.Idioma;
import upm.data.modelo.enums.Plataforma;

import java.io.File;
import java.time.LocalDateTime;

public class Poblador {
    public final PersistenciaUsuario persistenciaUsuario;
    public final PersistenciaMascota persistenciaMascota;
    public final PersistenciaContratoCuidado persistenciaContratoCuidado;

    public Poblador(PersistenciaUsuario persistenciaUsuario, PersistenciaMascota persistenciaMascota, PersistenciaContratoCuidado persistenciaContratoCuidado) {
        this.persistenciaUsuario = persistenciaUsuario;
        this.persistenciaMascota = persistenciaMascota;
        this.persistenciaContratoCuidado = persistenciaContratoCuidado;
    }

    public void seed() {
        Cuidador[] cuidadores = {
                new Cuidador("1", "Pedro Ángel", "Guzmán", "pedro.guzman@upm.es", "Calle Principal, 123", Idioma.Castellano, Plataforma.Google, new File("foto.jpg"), "Guapo y Vicioso", 50, "ES1234"),
                new Cuidador("2", "Stefan", "Ochipok", "stefan.ochipok@upm.es", "calle Principal 2", Idioma.Ingles, Plataforma.Microsoft, new File("foto2.jpg"), "Alto y rubio", 60, "GB123"),
                new Cuidador("3", "Cabeza", "de Vallecas", "cabezavallecas@upm.es", "Calle Principal, 456", Idioma.Catalan, Plataforma.Twitter, new File("foto3.jpg"), "Delincuente peligroso", 40, "ES1234")
        };
        for (Cuidador cuidador : cuidadores) {
            this.persistenciaUsuario.createCuidador(cuidador);
        }

        Dueno[] duenos = {
                new Dueno("4", "Pedro Ángel", "Guzmán", "pedro.guzman@upm.es", "Calle Principal, 123", Idioma.Castellano, Plataforma.Google),
                new Dueno("5", "Stefan", "Ochipok", "stefan.ochipok@upm.es","Calle principal 2", Idioma.Ingles, Plataforma.Microsoft),
                new Dueno("6", "Cabeza", "de Vallecas", "cabezavallecas@upm.es", "Calle Principal, 456", Idioma.Catalan, Plataforma.Twitter)
        };

        for (Dueno dueno : duenos) {
            this.persistenciaUsuario.createDueno(dueno);
        }



    public RepositorioUsuario getRepositorioUsuario() {
        return this.repositorioUsuario;
    }

    public RepositorioActividad getRepositorioActividad() {
        return this.repositorioActividad;
    }

    public RepositorioPlan getRepositorioPlan() {
        return this.repositorioPlan;
    }
}
}
