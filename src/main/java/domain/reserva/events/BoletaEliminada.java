package domain.reserva.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.reserva.values.BoletaId;

public class BoletaEliminada extends DomainEvent {

    private final BoletaId boletaId;

    public BoletaEliminada(BoletaId boletaId) {
        super("domain.reserva.BoletaEliminada");
        this.boletaId = boletaId;
    }

    public BoletaId getBoletaId() {
        return boletaId;
    }
}
