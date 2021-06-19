package domain.cartelera.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cartelera.values.Direccion;
import domain.cartelera.values.SedeId;
import domain.generalvalues.Nombre;

public class SedeActualizada extends DomainEvent {
    private final SedeId sedeId;
    private final Nombre nombreSede;
    private final Direccion direccion;

    public SedeActualizada(SedeId sedeId, Nombre nombreSede, Direccion direccion) {
        super("domain.cartelera.SedeActualizada");
        this.sedeId = sedeId;
        this.nombreSede = nombreSede;
        this.direccion = direccion;
    }

    public SedeId getSedeId() {
        return sedeId;
    }

    public Nombre getNombreSede() {
        return nombreSede;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
