package upm.data.persitencia.map;

import upm.data.modelo.Dueno;
import upm.data.modelo.Mascota;
import upm.data.persitencia.PersistenciaMascota;

import java.io.File;
import java.util.Map;
import java.util.Optional;

public class PersistenciaMascotaMap extends PersistenciaMap<Mascota> implements PersistenciaMascota {
    @Override
    public Optional<Mascota> findByCodigoRIAC(String codigoRIAC){
        Optional<Mascota> optional = Optional.empty();
        for(Mascota mascota : this.findAll()){
            if(mascota.getCodigoRIAC().equals(codigoRIAC)){
                optional = Optional.of(mascota);
            }
        }
        return optional;
    }
    @Override
    public Optional<Mascota> findByPolizaSeguro(String polizaSeguro){
        Optional<Mascota> optional = Optional.empty();
        for(Mascota mascota : this.findAll()){
            if(mascota.getCodigoRIAC().equals(polizaSeguro)){
                optional = Optional.of(mascota);
            }
        }
        return optional;
    }
}
