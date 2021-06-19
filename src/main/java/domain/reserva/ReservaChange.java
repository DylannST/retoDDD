package domain.reserva;

import co.com.sofka.domain.generic.EventChange;
import domain.reserva.events.*;
import domain.reserva.values.Total;

import java.util.ArrayList;

public class ReservaChange extends EventChange {
    public ReservaChange(Reserva reserva) {
        apply((ClienteActualizado event) -> {
            reserva.cliente = event.clienteActualizado();
        });

        apply((EstadoActualizado event) -> {
            reserva.cliente.actualizarEstado(event.getEstado());
        });

        apply((ReservaAgregada event) -> {
            reserva.cliente = event.getCliente();
            reserva.boletas = new ArrayList<>();
            reserva.carteleraId = event.getCarteleraId();
            reserva.sala = event.getSala();
            reserva.factura = event.getFactura();
            reserva.fechaReserva = event.getFechaReserva();
        });

        apply((EstaActivaActualizado event) -> {
            reserva.sala.modificarEstaActiva(event.getEstaActiva());
        });

        apply((BoletaEliminada event) -> {
            int contador = 0;
            for (Boleta boleta : reserva.boletas) {
                if (boleta.identity().equals(event.getBoletaId())) {
                    break;
                }
                contador++;
            }
            reserva.boletas.remove(contador);
        });


        apply((BoletaAgregada event) -> {
            Boleta boleta = new Boleta(event.getBoletaId(), event.getDescripciónBoleta());
            reserva.boletas.add(boleta);
        });

        apply((FacturaCreada event) -> {
            for (int i = 0; i < reserva.sala.getSillas().size(); i++) {

                if (reserva.sala.getSillas().get(i).value().vip()) {
                    reserva.factura.actualizarTotal(new Total(event.getTotal().value() * 0.5));//se cobra el VIP

                } else {
                    reserva.factura.actualizarTotal(event.getTotal());
                }


            }

        });


        apply((SalaActualizada event) -> {
            reserva.actualizarSala(event.getSalaId(), event.getEstaActiva(), event.getNombreSala(), event.getSillas());
        });

        apply((SalaAgregada event) -> {
            reserva.agregarSala(event.getSalaId(), event.getEstaActiva(), event.getNombreSala(), event.getSillas());
        });

        apply((ClienteActualizado event) -> {
            reserva.actualizarCliente(event.getClienteId(), event.getEstado(), event.getEdad(), event.getNombreCliente());
        });
        apply((SalaIdActualizada event) -> {
            reserva.actualizarSalaIdDeBoleto(event.getSalaId());
        });
        apply((TotalFacturaActualizada event) -> {
            reserva.actualizarTotalFactura(event.getTotal());
        });
    }
}
