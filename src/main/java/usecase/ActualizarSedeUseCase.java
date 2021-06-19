package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cartelera.Cartelera;
import domain.cartelera.command.ActualizarSede;

public class ActualizarSedeUseCase extends UseCase<RequestCommand<ActualizarSede>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ActualizarSede> actualizarSedeRequestCommand) {
        var command = actualizarSedeRequestCommand.getCommand();
        var cartelera = Cartelera.from(command.getCarteleraId(), command.getSede(), retrieveEvents());
        cartelera.actualizarSede(command.getSede().identity(), command.getSede().getNombreSede(), command.getSede().getDireccion());
        emit().onResponse(new ResponseEvents(cartelera.getUncommittedChanges()));
    }
}
