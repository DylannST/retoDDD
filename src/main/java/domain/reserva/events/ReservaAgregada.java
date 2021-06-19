package domain.reserva.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cartelera.values.CarteleraId;
import domain.generalvalues.Fecha;
import domain.reserva.Cliente;
import domain.reserva.Factura;
import domain.reserva.Sala;
import domain.reserva.values.ReservaId;

public class ReservaAgregada extends DomainEvent {

    private final ReservaId entityId;
    private final Cliente cliente;
    private final CarteleraId carteleraId;
    private final Sala sala;
    private final Factura factura;
    private final Fecha fechaReserva;


    public ReservaAgregada(ReservaId entityId, Cliente cliente, CarteleraId carteleraId, Sala sala, Factura factura, Fecha fechaReserva) {
        super("domain.reserva.ReservaAgregada");
        this.entityId = entityId;
        this.cliente = cliente;
        this.carteleraId = carteleraId;
        this.sala = sala;
        this.factura = factura;
        this.fechaReserva = fechaReserva;
    }

    public ReservaId getEntityId() {
        return entityId;
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

    public Factura getFactura() {
        return factura;
    }

    public Fecha getFechaReserva() {
        return fechaReserva;
    }
}
