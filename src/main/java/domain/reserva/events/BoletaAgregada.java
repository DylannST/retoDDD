package domain.reserva.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.reserva.values.BoletaId;
import domain.reserva.values.Descripción;

public class BoletaAgregada extends DomainEvent {


    private final BoletaId boletaId;
    private final Descripción descripciónBoleta;

    public BoletaAgregada(BoletaId boletaId, Descripción descripciónBoleta) {
        super("domain.reserva.BoletaAgregada");
        this.boletaId = boletaId;
        this.descripciónBoleta = descripciónBoleta;
    }

    public BoletaId getBoletaId() {
        return boletaId;
    }


    public Descripción getDescripciónBoleta() {
        return descripciónBoleta;
    }
}
