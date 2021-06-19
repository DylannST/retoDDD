package domain.cartelera;

import co.com.sofka.domain.generic.Entity;
import domain.cartelera.values.Genero;
import domain.cartelera.values.PeliculaId;
import domain.generalvalues.Fecha;
import domain.generalvalues.Nombre;

import java.util.Objects;

public class Pelicula extends Entity<PeliculaId> {

    private Fecha fechaPelicula;
    private Genero genero;
    private Nombre nombrePelicula;

    public Pelicula(PeliculaId peliculaId, Fecha fechaPelicula, Genero genero, Nombre nombrePelicula) {
        super(peliculaId);
        this.fechaPelicula = Objects.requireNonNull(fechaPelicula, "fecha de la pelicula esta nulo");
        this.genero = Objects.requireNonNull(genero, "genero de la pelicula esta nulo");
        this.nombrePelicula = Objects.requireNonNull(nombrePelicula, "nombre de pelicula esta nulo");
    }

    public void modificarFechaPelicula(Fecha fechaPelicula) {
        this.fechaPelicula = Objects.requireNonNull(fechaPelicula, "la nueva fecha esta nula");
    }

    public Fecha getFechaPelicula() {
        return fechaPelicula;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "fechaPelicula=" + fechaPelicula +
                ", genero=" + genero +
                ", nombrePelicula=" + nombrePelicula +
                '}';
    }

    public Genero getGenero() {
        return genero;
    }

    public Nombre getNombrePelicula() {
        return nombrePelicula;
    }
}
