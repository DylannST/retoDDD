package domain.cartelera.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cartelera.values.PeliculaId;
import domain.generalvalues.Fecha;

public class FechaPeliculaActualizada extends DomainEvent {

    private final PeliculaId peliculaId;
    private final Fecha nuevaFechaPelicula;

    public FechaPeliculaActualizada(PeliculaId peliculaId, Fecha nuevaFechaPelicula) {
        super("domain.cartelera.FechaPeliculaActualizada");
        this.peliculaId = peliculaId;
        this.nuevaFechaPelicula = nuevaFechaPelicula;
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }

    public Fecha getNuevaFechaPelicula() {
        return nuevaFechaPelicula;
    }
}
