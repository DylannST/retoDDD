package domain.cartelera.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cartelera.values.FormatoId;
import domain.cartelera.values.Restriccion;
import domain.cartelera.values.Tipo;

import java.util.Objects;

public class FormatoAgregado extends DomainEvent {
    private final FormatoId formatoId;
    private final Restriccion restriccion;
    private final Tipo tipo;

    public FormatoAgregado(FormatoId formatoId, Restriccion restriccion, Tipo tipo) {
        super("domain.cartelera.FormatoAgregado");
        this.formatoId = Objects.requireNonNull(formatoId, " no se puede agregar el id de formato nulo");
        this.restriccion = Objects.requireNonNull(restriccion, "no se puede agregar la restriccion nula");
        this.tipo = Objects.requireNonNull(tipo, "no se puede agregar el tipo nulo");
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
