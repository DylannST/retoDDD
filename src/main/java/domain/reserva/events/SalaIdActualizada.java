package domain.reserva.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.reserva.values.SalaId;

public class SalaIdActualizada extends DomainEvent {

    private final SalaId salaId;

    public SalaIdActualizada(SalaId salaId) {
        super("domain.reserva.SalaIdActualizada");
        this.salaId = salaId;
    }

    public SalaId getSalaId() {
        return salaId;
    }
}
