package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.reserva.Reserva;
import domain.reserva.command.EliminarBoleta;

public class EliminarBoletaUseCase extends UseCase<RequestCommand<EliminarBoleta>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<EliminarBoleta> eliminarBoletaRequestCommand) {
        var command = eliminarBoletaRequestCommand.getCommand();
        var reserva = Reserva.from(command.getReservaId(), command.getCliente(),
                command.getCarteleraId(), command.getSala(), command.getFechaReserva(),
                retrieveEvents());
        reserva.eliminarBoleta(command.getBoletaId());
        emit().onResponse(new ResponseEvents(reserva.getUncommittedChanges()));
    }
}
