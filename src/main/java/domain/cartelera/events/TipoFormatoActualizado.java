package domain.cartelera.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cartelera.values.FormatoId;
import domain.cartelera.values.Tipo;

public class TipoFormatoActualizado extends DomainEvent {

    private final FormatoId formatoId;
    private final Tipo tipo;

    public TipoFormatoActualizado(FormatoId formatoId, Tipo tipo) {
        super("domain.cartelera.TipoFormatoActualizado");
        this.formatoId = formatoId;
        this.tipo = tipo;
    }

    public FormatoId getFormatoId() {
        return formatoId;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
