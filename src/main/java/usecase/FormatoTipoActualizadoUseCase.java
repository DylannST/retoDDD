package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cartelera.Cartelera;
import domain.cartelera.command.ActualizarTipoFormato;

public class FormatoTipoActualizadoUseCase extends UseCase<RequestCommand<ActualizarTipoFormato>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarTipoFormato> formatoActualizadoRequestCommand) {
        var command = formatoActualizadoRequestCommand.getCommand();
        var cartelera = Cartelera.from(command.getCarteleraId(), command.getSede(), retrieveEvents());
        cartelera.actualizarFormato(command.getFormatoId(), command.getRestriccion(), command.getTipo());
        emit().onResponse(new ResponseEvents(cartelera.getUncommittedChanges()));
    }
}
