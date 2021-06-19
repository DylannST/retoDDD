package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.reserva.Reserva;
import domain.reserva.command.CrearFactura;

public class CrearFacturaUseCase extends UseCase<RequestCommand<CrearFactura>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearFactura> crearFacturaRequestCommand) {
        var command = crearFacturaRequestCommand.getCommand();
        var reserva = Reserva.from(command.getReservaId(), command.getCliente(), command.getCarteleraId(), command.getSala(), command.getFechaReserva(), retrieveEvents());
        reserva.crearFactura(command.getFactura().identity(), command.getFactura().getTotal());
        emit().onResponse(new ResponseEvents(reserva.getUncommittedChanges()));
    }
}
