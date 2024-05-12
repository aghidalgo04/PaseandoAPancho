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
                new Cuidador("2", "Stefan", "Ochipok", "stefan.ochipok@upm.es", "calle preciados 2", Idioma.Ingles, Plataforma.Microsoft, new File("foto2.jpg"), "Alto y rubio", 60, "GB123"),
                new Cuidador("3", "Cabeza", "de Vallecas", "cabezavallecas@upm.es", "Calle Principal, 456", Idioma.Catalan, Plataforma.Twitter, new File("foto3.jpg"), "Delincuente peligroso", 40, "ES1234")
        };
        for (Cuidador cuidador : cuidadores) {
            this.persistenciaUsuario.createCuidador(cuidador);
        }

        Dueno[] duenos = {
                new Dueno("4","Pedro Ángel","Guzmán","pedro.guzman@upm.es","Calle Principal, 123", Idioma.Castellano, Plataforma.Google),
                new Dueno("5","Stefan","Ochipok","stefan.ochipok@upm.es",
                "123 Main Street",
                Idioma.Ingles,
                Plataforma.Microsoft
        ),
                new Dueno("6",
                "Cabeza",
                "de Vallecas",
                "cabezavallecas@upm.es",
                "Calle Principal, 456",
                Idioma.Catalan,
                Plataforma.Twitter
        )




        };

        Actividad[] actividades = {
                new Teatro("actividad1", "descripcion1", 120, 25.3, 34),
                new Cine("actividad2", "descripcion2", 34, 35.3, 23),
                new Generica("actividad3", "descripcion3", 234, 1.2, 45)
        };

        for (Actividad actividad : actividades) {
            this.repositorioActividad.crear(actividad);
        }

        Usuario user = new Usuario("Perro", 20, 6789876, "contrasenia");

        Plan[] planes = {
                new Plan(user, "plan1", LocalDateTime.of(2024, 12, 7, 23, 34, 12), "lugar1", 67),
                new Plan(user, "plan2", LocalDateTime.of(2025, 12, 7, 23, 34, 12), "lugar2", 45),
                new Plan(user, "plan3", LocalDateTime.of(2026, 12, 7, 23, 34, 12), "lugar3", 56),
                new Plan(user, "plan4", LocalDateTime.of(2027, 12, 7, 23, 34, 12), "lugar3", 56)
        };

        planes[0].aniadirActividad(actividades[0]);
        planes[0].aniadirActividad(actividades[1]);
        planes[0].aniadirActividad(actividades[2]);
        planes[1].aniadirActividad(actividades[0]);
        planes[1].aniadirActividad(actividades[1]);
        planes[3].aniadirActividad(actividades[1]);

        planes[0].aniadirUsuario(usuarios[0]);
        planes[1].aniadirUsuario(usuarios[0]);
        planes[1].aniadirUsuario(usuarios[1]);

        for (Plan plan : planes) {
            this.repositorioPlan.crear(plan);
        }
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
