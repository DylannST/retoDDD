package domain.cartelera.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cartelera.values.FormatoId;
import domain.cartelera.values.Restriccion;

public class RestriccionFormatoActualizada extends DomainEvent {

    private final FormatoId formatoId;
    private final Restriccion restriccion;

    public RestriccionFormatoActualizada(FormatoId formatoId, Restriccion restriccion) {
        super("domain.cartelera.RestriccionFormatoActualizada");
        this.formatoId = formatoId;
        this.restriccion = restriccion;
    }

    public FormatoId getFormatoId() {
        return formatoId;
    }

    public Restriccion getRestriccion() {
        return restriccion;
    }
}
