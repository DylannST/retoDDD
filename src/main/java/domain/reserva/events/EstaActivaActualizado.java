package domain.reserva.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.reserva.values.EstaActiva;

public class EstaActivaActualizado extends DomainEvent {

    private final EstaActiva estaActiva;

    public EstaActivaActualizado(EstaActiva estaActiva) {
        super("domain.reserva.EstaActivaActualizado");
        this.estaActiva = estaActiva;
    }

    public EstaActiva getEstaActiva() {
        return estaActiva;
    }
}
