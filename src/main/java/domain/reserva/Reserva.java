package domain.reserva;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cartelera.values.CarteleraId;
import domain.generalvalues.Fecha;
import domain.generalvalues.Nombre;
import domain.reserva.events.*;
import domain.reserva.values.*;

import java.util.List;

public class Reserva extends AggregateEvent<ReservaId> {

    protected Cliente cliente;
    protected List<Boleta> boletas;
    protected CarteleraId carteleraId;
    protected Sala sala;
    protected Factura factura;
    protected Fecha fechaReserva;

    public Reserva(ReservaId entityId, Cliente cliente, CarteleraId carteleraId, Sala sala, Fecha fechaReserva) {
        super(entityId);
        this.cliente = cliente;
        this.carteleraId = carteleraId;
        this.fechaReserva = fechaReserva;
        this.sala = sala;
        appendChange(new ReservaAgregada(entityId, cliente, carteleraId, sala, factura, fechaReserva)).apply();
    }

    public static Reserva from(ReservaId reservaId, Cliente cliente, CarteleraId carteleraId, Sala sala, Fecha fechaReserva, List<DomainEvent> events) {
        var reserva = new Reserva(reservaId, cliente, carteleraId, sala, fechaReserva);
        events.forEach(reserva::applyEvent);
        return reserva;
    }



    public void actualizarCliente(ClienteId clienteId, Estado estado, Edad edad, Nombre nombreCliente) {
        appendChange(new ClienteActualizado(clienteId, estado, edad, nombreCliente)).apply();
    }

    public void actualizarEstadoCliente(Estado estado) {
        appendChange(new EstadoActualizado(estado)).apply();
    }

    public void crearFactura(FacturaId facturaId, Total total) {
        appendChange(new FacturaCreada(facturaId, total)).apply();
    }

    public void actualizarTotalFactura(Total total) {
        appendChange(new TotalFacturaActualizada(total)).apply();
    }

    public void agregarSala(SalaId salaId, EstaActiva estaActiva, Nombre nombreSala, List<Silla> sillas) {
        appendChange(new SalaAgregada(salaId, estaActiva, nombreSala, sillas)).apply();
    }


    public void modificarEstaActivaSala(EstaActiva estaActiva) {
        appendChange(new EstaActivaActualizado(estaActiva)).apply();
    }

    public void actualizarSala(SalaId salaId, EstaActiva estaActiva, Nombre nombreSala, List<Silla> sillas) {
        appendChange(new SalaActualizada(salaId, estaActiva, nombreSala, sillas)).apply();
    }

    public void agregarBoleta(BoletaId entityId, Descripción descripciónBoleta) {
        appendChange(new BoletaAgregada(entityId, descripciónBoleta)).apply();
    }

    public void eliminarBoleta(BoletaId entityId) {
        appendChange(new BoletaEliminada(entityId)).apply();
    }

    public void actualizarSalaIdDeBoleto(SalaId salaId) {
        appendChange(new SalaIdActualizada(salaId)).apply();
    }


}
