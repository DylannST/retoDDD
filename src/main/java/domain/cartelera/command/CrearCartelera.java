package domain.cartelera.command;

import co.com.sofka.domain.generic.Command;
import domain.cartelera.Sede;
import domain.cartelera.values.CarteleraId;

public class CrearCartelera implements Command {
    private final CarteleraId carteleraId;
    private final Sede sede;

    public CrearCartelera(CarteleraId carteleraId, Sede sede) {
        this.carteleraId = carteleraId;
        this.sede = sede;
    }

    public CarteleraId getCarteleraId() {
        return carteleraId;
    }

    public Sede getSede() {
        return sede;
    }
}
