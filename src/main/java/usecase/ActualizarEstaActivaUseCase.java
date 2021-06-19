package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.reserva.Reserva;
import domain.reserva.command.ActualizarEstaActiva;

public class ActualizarEstaActivaUseCase extends UseCase<RequestCommand<ActualizarEstaActiva>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<ActualizarEstaActiva> actualizarEstaActivaRequestCommand) {
        var command = actualizarEstaActivaRequestCommand.getCommand();
        var reserva = Reserva.from(command.getReservaId(), command.getCliente(),
                command.getCarteleraId(), command.getSala(), command.getFechaReserva(),
                retrieveEvents());
        reserva.modificarEstaActivaSala(command.getSala().getEstaActiva());

        emit().onResponse(new ResponseEvents(reserva.getUncommittedChanges()));
    }
}
