package domain.cartelera.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cartelera.Pelicula;
import domain.cartelera.values.Genero;
import domain.cartelera.values.PeliculaId;
import domain.generalvalues.Fecha;
import domain.generalvalues.Nombre;

public class PeliculaActualizada extends DomainEvent {
    private final PeliculaId peliculaId;
    private final Fecha fechaPelicula;
    private final Genero genero;
    private final Nombre nombrePelicula;

    public PeliculaActualizada(PeliculaId peliculaId, Fecha fechaPelicula, Genero genero, Nombre nombrePelicula) {
        super("domain.cartelera.PeliculaAgregada");
        this.peliculaId = peliculaId;
        this.fechaPelicula = fechaPelicula;
        this.genero = genero;
        this.nombrePelicula = nombrePelicula;
    }

    public Pelicula peliculaActualizada() {
        return new Pelicula(this.peliculaId, this.fechaPelicula, this.genero, this.nombrePelicula);
    }

    public PeliculaId getPeliculaId() {
        return peliculaId;
    }

    public Fecha getFechaPelicula() {
        return fechaPelicula;
    }

    public Genero getGenero() {
        return genero;
    }

    public Nombre getNombrePelicula() {
        return nombrePelicula;
    }
}
