package domain.reserva.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.reserva.values.FacturaId;
import domain.reserva.values.Total;

public class FacturaCreada extends DomainEvent {
    private final FacturaId facturaId;
    private final Total total;

    public FacturaCreada(FacturaId facturaId, Total total) {
        super("domain.reserva.FacturaCreada");
        this.facturaId = facturaId;
        this.total = total;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Total getTotal() {
        return total;
    }
}
