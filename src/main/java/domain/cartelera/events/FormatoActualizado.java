package domain.cartelera.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cartelera.Formato;
import domain.cartelera.values.FormatoId;
import domain.cartelera.values.Restriccion;
import domain.cartelera.values.Tipo;

import java.util.Objects;

public class FormatoActualizado extends DomainEvent {

    private final FormatoId formatoId;
    private final Restriccion restriccion;
    private final Tipo tipo;

    public FormatoActualizado(FormatoId formatoId, Restriccion restriccion, Tipo tipo) {
        super("domain.cartelera.FormatoActualizado");
        this.formatoId = Objects.requireNonNull(formatoId, "no se puede actualizar el id nulo");
        this.restriccion = Objects.requireNonNull(restriccion, "no se puede actualizar la restriccion nula");
        this.tipo = Objects.requireNonNull(tipo, "no se puede actualizar el tipo nulo");
    }

    public Formato formatoActualizado() {
        return new Formato(this.getFormatoId(), this.getRestriccion(), this.getTipo());
    }

    public FormatoId getFormatoId() {
        return formatoId;
    }

    public Restriccion getRestriccion() {
        return restriccion;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
