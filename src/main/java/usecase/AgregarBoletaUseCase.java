package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import domain.reserva.Reserva;
import domain.reserva.events.ReservaAgregada;
import domain.reserva.values.BoletaId;
import domain.reserva.values.Descripción;
import domain.reserva.values.ReservaId;

public class AgregarBoletaUseCase extends UseCase<TriggeredEvent<ReservaAgregada>, ResponseEvents> {


    @Override
    public void executeUseCase(TriggeredEvent<ReservaAgregada> reservaAgregadaTriggeredEvent) {
        var event = reservaAgregadaTriggeredEvent.getDomainEvent();
        var reserva = Reserva.from(ReservaId.of(event.aggregateRootId()), event.getCliente(),
                event.getCarteleraId(), event.getSala(), event.getFechaReserva(), retrieveEvents());

        reserva.agregarBoleta(BoletaId.of(event.aggregateRootId()),
                new Descripción(""));
    }
}
