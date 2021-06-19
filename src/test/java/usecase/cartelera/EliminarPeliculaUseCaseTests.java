package usecase.cartelera;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cartelera.Sede;
import domain.cartelera.command.EliminarPelicula;
import domain.cartelera.events.CarteleraCreada;
import domain.cartelera.events.PeliculaAgregada;
import domain.cartelera.events.PeliculaEliminada;
import domain.cartelera.values.*;
import domain.generalvalues.Fecha;
import domain.generalvalues.Nombre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecase.EliminarPeliculaUseCase;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EliminarPeliculaUseCaseTests {

    EliminarPeliculaUseCase eliminarPeliculaUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        eliminarPeliculaUseCase = new EliminarPeliculaUseCase();
        repository = mock(DomainEventRepository.class);
        eliminarPeliculaUseCase.addRepository(repository);
    }

    @Test
    public void eliminarPelicula() {

        when(repository.getEventsBy("1")).thenReturn(events());
        eliminarPeliculaUseCase.addRepository(repository);

        var command = new RequestCommand<>(new EliminarPelicula(CarteleraId.of("1"),
                new Sede(SedeId.of("5"),
                        new Nombre("VivaEnvigado"),
                        new Direccion("calle 60", "Medellin")),
                PeliculaId.of("4")));

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(eliminarPeliculaUseCase, command)
                .orElseThrow();

        var events = response.getDomainEvents();
        PeliculaEliminada peliculaEliminada = (PeliculaEliminada) events.get(1);

    }

    private List<DomainEvent> events() {
        return List.of(new CarteleraCreada(CarteleraId.of("1"),
                        new Sede(SedeId.of("5"),
                                new Nombre("VivaEnvigado"),
                                new Direccion("calle 60", "Medellin"))),
                new PeliculaAgregada(PeliculaId.of("4"),
                        new Fecha("25-06-2019"),
                        new Genero("M"),
                        new Nombre("spiderman")));
    }
}
