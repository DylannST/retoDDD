package domain.cartelera.command;

import co.com.sofka.domain.generic.Command;
import domain.cartelera.Sede;
import domain.cartelera.values.CarteleraId;
import domain.cartelera.values.PeliculaId;

public class EliminarPelicula implements Command {
    private final CarteleraId carteleraId;
    private final Sede sede;
    private final PeliculaId peliculaId;

    public EliminarPelicula(CarteleraId carteleraId, Sede sede, PeliculaId peliculaId) {
        this.carteleraId = carteleraId;
        this.sede = sede;
        this.peliculaId = peliculaId;
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
}
