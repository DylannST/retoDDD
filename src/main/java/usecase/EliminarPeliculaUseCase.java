package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cartelera.Cartelera;
import domain.cartelera.command.EliminarPelicula;

public class EliminarPeliculaUseCase extends UseCase<RequestCommand<EliminarPelicula>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<EliminarPelicula> eliminarPeliculaRequestCommand) {
        var command = eliminarPeliculaRequestCommand.getCommand();
        var cartelera = Cartelera.from(command.getCarteleraId(), command.getSede(), retrieveEvents());

        cartelera.eliminarPelicula(command.getPeliculaId());
        emit().onResponse(new ResponseEvents(cartelera.getUncommittedChanges()));
    }
}
