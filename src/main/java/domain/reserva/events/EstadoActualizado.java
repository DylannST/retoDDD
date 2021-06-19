package domain.reserva.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.reserva.values.Estado;

public class EstadoActualizado extends DomainEvent {

    private final Estado estado;

    public EstadoActualizado(Estado estado) {
        super("domain.reserva.EstadoActualizado");
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }
}
