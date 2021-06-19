package domain.cartelera.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cartelera.values.Genero;
import domain.cartelera.values.PeliculaId;
import domain.generalvalues.Fecha;
import domain.generalvalues.Nombre;

import java.util.Objects;

public class PeliculaAgregada extends DomainEvent {

    private final PeliculaId peliculaId;
    private final Fecha fechaPelicula;
    private final Genero genero;
    private final Nombre nombrePelicula;

    public PeliculaAgregada(PeliculaId peliculaId, Fecha fechaPelicula, Genero genero, Nombre nombrePelicula) {
        super("domain.cartelera.PeliculaAgregada");
        this.peliculaId = Objects.requireNonNull(peliculaId, "id pelicula esta nulo no se puede crear");
        this.fechaPelicula = Objects.requireNonNull(fechaPelicula, "fecha pelicula esta nulo no se puede crear");
        this.genero = Objects.requireNonNull(genero, "genero pelicula esta nulo no se puede crear");
        this.nombrePelicula = Objects.requireNonNull(nombrePelicula, "nombre pelicula pelicula esta nulo no se puede crear");
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
