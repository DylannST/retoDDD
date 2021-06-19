package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cartelera.Cartelera;
import domain.cartelera.command.ModificarFechaPelicula;

public class ModificarFechaPeliculaUseCase extends UseCase<RequestCommand<ModificarFechaPelicula>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModificarFechaPelicula> modificarFechaPeliculaRequestCommand) {
        var command = modificarFechaPeliculaRequestCommand.getCommand();
        var cartelera = Cartelera.from(command.getCarteleraId(), command.getSede(), retrieveEvents());
        cartelera.modificarFechaPelicula(command.getPeliculaId(), command.getNuevaFechaPelicula());
        emit().onResponse(new ResponseEvents(cartelera.getUncommittedChanges()));
    }
}
