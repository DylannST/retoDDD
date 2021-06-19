package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.reserva.Reserva;
import domain.reserva.command.AgregarReserva;

public class AgregarReservaUseCase extends UseCase<RequestCommand<AgregarReserva>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarReserva> agregarReservaRequestCommand) {
        var command = agregarReservaRequestCommand.getCommand();
        var reserva = new Reserva(command.getEntityId(), command.getCliente(), command.getCarteleraId(), command.getSala(), command.getFechaReserva());

        emit().onResponse(new ResponseEvents(reserva.getUncommittedChanges()));
    }
}
