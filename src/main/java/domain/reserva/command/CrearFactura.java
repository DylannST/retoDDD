package domain.reserva.command;

import co.com.sofka.domain.generic.Command;
import domain.cartelera.values.CarteleraId;
import domain.generalvalues.Fecha;
import domain.reserva.Cliente;
import domain.reserva.Factura;
import domain.reserva.Sala;
import domain.reserva.values.ReservaId;

public class CrearFactura implements Command {
    private final ReservaId reservaId;
    private final Cliente cliente;
    private final CarteleraId carteleraId;
    private final Sala sala;
    Fecha fechaReserva;
    private final Factura factura;

    public CrearFactura(ReservaId reservaId, Cliente cliente, CarteleraId carteleraId, Sala sala, Factura factura) {
        this.reservaId = reservaId;
        this.cliente = cliente;
        this.carteleraId = carteleraId;
        this.sala = sala;
        this.factura = factura;
    }

    public ReservaId getReservaId() {
        return reservaId;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public CarteleraId getCarteleraId() {
        return carteleraId;
    }

    public Sala getSala() {
        return sala;
    }

    public Fecha getFechaReserva() {
        return fechaReserva;
    }

    public Factura getFactura() {
        return factura;
    }
}
