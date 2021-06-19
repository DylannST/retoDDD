package domain.cartelera.command;

import co.com.sofka.domain.generic.Command;
import domain.cartelera.Sede;
import domain.cartelera.values.CarteleraId;
import domain.cartelera.values.Genero;
import domain.cartelera.values.PeliculaId;
import domain.generalvalues.Fecha;
import domain.generalvalues.Nombre;

public class AgregarPelicula implements Command {

    private final CarteleraId carteleraId;
    private final Sede sede;
    private final PeliculaId peliculaId;
    private final Fecha fechaPelicula;
    private final Genero genero;
    private final Nombre nombrePelicula;

    public AgregarPelicula(CarteleraId carteleraId, Sede sede, PeliculaId peliculaId, Fecha fechaPelicula, Genero genero, Nombre nombrePelicula) {
        this.carteleraId = carteleraId;
        this.sede = sede;
        this.peliculaId = peliculaId;
        this.fechaPelicula = fechaPelicula;
        this.genero = genero;
        this.nombrePelicula = nombrePelicula;
    }

    public CarteleraId getCarteleraId() {
        return carteleraId;
    }

    public Sede getSede() {
        return sede;
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
