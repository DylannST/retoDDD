package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cartelera.Cartelera;
import domain.cartelera.command.CrearCartelera;

public class CrearCarteleraUseCase extends UseCase<RequestCommand<CrearCartelera>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearCartelera> crearCarteleraRequestCommand) {
        var command = crearCarteleraRequestCommand.getCommand();

        var cartelera = new Cartelera(command.getCarteleraId(), command.getSede());



        emit().onResponse(new ResponseEvents(cartelera.getUncommittedChanges()));

    }
}
