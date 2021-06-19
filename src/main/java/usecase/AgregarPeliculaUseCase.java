package usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cartelera.Cartelera;
import domain.cartelera.command.AgregarPelicula;

public class AgregarPeliculaUseCase extends UseCase<RequestCommand<AgregarPelicula>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarPelicula> agregarPeliculaRequestCommand) {
        var command = agregarPeliculaRequestCommand.getCommand();
        var cartelera = Cartelera.from(command.getCarteleraId(), command.getSede(), retrieveEvents());

        cartelera.agregarPelicula(command.getPeliculaId(), command.getFechaPelicula(), command.getGenero(), command.getNombrePelicula());
        emit().onResponse(new ResponseEvents(cartelera.getUncommittedChanges()));
    }
}
