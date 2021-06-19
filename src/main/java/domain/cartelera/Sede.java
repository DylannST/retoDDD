package domain.cartelera;

import co.com.sofka.domain.generic.Entity;
import domain.cartelera.values.Direccion;
import domain.cartelera.values.SedeId;
import domain.generalvalues.Nombre;

import java.util.Objects;

public class Sede extends Entity<SedeId> {
    private final Nombre nombreSede;
    private Direccion direccion;

    public Sede(SedeId sedeId, Nombre nombreSede, Direccion direccion) {
        super(sedeId);
        this.nombreSede = Objects.requireNonNull(nombreSede, "el nombre de la sede esta nulo");
        this.direccion = direccion;
    }

    public void modificarDireccionSede(Direccion direccion) {
        this.direccion = direccion;
    }


    public Nombre getNombreSede() {
        return nombreSede;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
