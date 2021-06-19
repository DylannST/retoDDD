package domain.cartelera.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cartelera.Sede;
import domain.cartelera.values.CarteleraId;

public class CarteleraCreada extends DomainEvent {

    private final CarteleraId carteleraId;
    private final Sede sede;

    public CarteleraCreada(CarteleraId carteleraId, Sede sede) {
        super("domain.cartelera.CarteleraCreada");
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
