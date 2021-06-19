package domain.reserva.command;

import co.com.sofka.domain.generic.Command;
import domain.cartelera.values.CarteleraId;
import domain.generalvalues.Fecha;
import domain.reserva.Cliente;
import domain.reserva.Sala;
import domain.reserva.values.ReservaId;

public class AgregarReserva implements Command {
    private final ReservaId entityId;
    private final Cliente cliente;
    private final CarteleraId carteleraId;
    private final Sala sala;
    private final Fecha fechaReserva;

    public AgregarReserva(ReservaId entityId, Cliente cliente, CarteleraId carteleraId, Sala sala, Fecha fechaReserva) {
        this.entityId = entityId;
        this.cliente = cliente;
        this.carteleraId = carteleraId;
        this.sala = sala;
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

    public Fecha getFechaReserva() {
        return fechaReserva;
    }
}
