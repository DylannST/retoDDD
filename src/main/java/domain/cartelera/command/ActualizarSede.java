package domain.cartelera.command;

import co.com.sofka.domain.generic.Command;
import domain.cartelera.Sede;
import domain.cartelera.values.CarteleraId;
import domain.cartelera.values.Direccion;
import domain.generalvalues.Nombre;

public class ActualizarSede implements Command {
    private final CarteleraId carteleraId;
    private final Sede sede;

    public ActualizarSede(CarteleraId carteleraId, Sede sede) {
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
