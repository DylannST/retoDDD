package domain.reserva.command;

import co.com.sofka.domain.generic.Command;
import domain.cartelera.values.CarteleraId;
import domain.generalvalues.Fecha;
import domain.reserva.Cliente;
import domain.reserva.Sala;
import domain.reserva.values.BoletaId;
import domain.reserva.values.ReservaId;

public class EliminarBoleta implements Command {
    private final BoletaId boletaId;
    private final ReservaId reservaId;
    private final Cliente cliente;
    private final CarteleraId carteleraId;
    private final Sala sala;
    private final Fecha fechaReserva;

    public EliminarBoleta(BoletaId boletaId, ReservaId reservaId, Cliente cliente, CarteleraId carteleraId, Sala sala, Fecha fechaReserva) {
        this.boletaId = boletaId;
        this.reservaId = reservaId;
        this.cliente = cliente;
        this.carteleraId = carteleraId;
        this.sala = sala;
        this.fechaReserva = fechaReserva;
    }

    public BoletaId getBoletaId() {
        return boletaId;
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
}
