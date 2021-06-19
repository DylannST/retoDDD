package domain.cartelera.command;

import co.com.sofka.domain.generic.Command;
import domain.cartelera.Sede;
import domain.cartelera.values.CarteleraId;
import domain.cartelera.values.PeliculaId;
import domain.generalvalues.Fecha;

public class ModificarFechaPelicula implements Command {

    private final CarteleraId carteleraId;
    private final Sede sede;
    private final PeliculaId peliculaId;
    private final Fecha nuevaFechaPelicula;

    public ModificarFechaPelicula(CarteleraId carteleraId, Sede sede, PeliculaId peliculaId, Fecha nuevaFechaPelicula) {
        this.carteleraId = carteleraId;
        this.sede = sede;
        this.peliculaId = peliculaId;
        this.nuevaFechaPelicula = nuevaFechaPelicula;
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

    public Fecha getNuevaFechaPelicula() {
        return nuevaFechaPelicula;
    }
}
