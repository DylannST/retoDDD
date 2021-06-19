package domain.cartelera.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cartelera.values.Direccion;
import domain.cartelera.values.SedeId;

public class DireccionSedeActualizada extends DomainEvent {
    private final SedeId sedeId;
    private final Direccion direccion;

    public DireccionSedeActualizada(SedeId sedeId, Direccion direccion) {
        super("domain.cartelera.DireccionSedeActualizada");
        this.sedeId = sedeId;
        this.direccion = direccion;
    }

    public SedeId getSedeId() {
        return sedeId;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
