package domain.reserva.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.reserva.values.Total;

public class TotalFacturaActualizada extends DomainEvent {

    private final Total total;

    public TotalFacturaActualizada(Total total) {
        super("domain.reserva.TotalFacturaActualizada");
        this.total = total;
    }

    public Total getTotal() {
        return total;
    }
}
