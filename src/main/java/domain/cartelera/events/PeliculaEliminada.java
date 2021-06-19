package domain.cartelera.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cartelera.values.PeliculaId;

import java.util.Objects;

public class PeliculaEliminada extends DomainEvent {

    private final PeliculaId peliculaId;

    public PeliculaEliminada(PeliculaId peliculaId) {
        super("domain.cartelera.PeliculaEliminada");
        this.peliculaId = Objects.requireNonNull(peliculaId);
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }


}
