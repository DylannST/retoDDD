package domain.cartelera.command;

import co.com.sofka.domain.generic.Command;
import domain.cartelera.Sede;
import domain.cartelera.values.CarteleraId;
import domain.cartelera.values.FormatoId;
import domain.cartelera.values.Restriccion;
import domain.cartelera.values.Tipo;

public class ActualizarTipoFormato implements Command {
    private final CarteleraId carteleraId;
    private final Sede sede;
    private final FormatoId formatoId;
    private final Restriccion restriccion;
    private final Tipo tipo;

    public ActualizarTipoFormato(CarteleraId carteleraId, Sede sede, FormatoId formatoId, Restriccion restriccion, Tipo tipo) {
        this.carteleraId = carteleraId;
        this.sede = sede;
        this.formatoId = formatoId;
        this.restriccion = restriccion;
        this.tipo = tipo;
    }

    public CarteleraId getCarteleraId() {
        return carteleraId;
    }

    public Sede getSede() {
        return sede;
    }

    public FormatoId getFormatoId() {
        return formatoId;
    }

    public Restriccion getRestriccion() {
        return restriccion;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
