package usecase.cartelera;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cartelera.Sede;
import domain.cartelera.command.ModificarFechaPelicula;
import domain.cartelera.events.CarteleraCreada;
import domain.cartelera.events.FechaPeliculaActualizada;
import domain.cartelera.events.PeliculaAgregada;
import domain.cartelera.values.*;
import domain.generalvalues.Fecha;
import domain.generalvalues.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecase.ModificarFechaPeliculaUseCase;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ModificarFechaPeliculaUseCaseTest {
    ModificarFechaPeliculaUseCase modificarFechaPeliculaUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        modificarFechaPeliculaUseCase = new ModificarFechaPeliculaUseCase();
        repository = mock(DomainEventRepository.class);
        modificarFechaPeliculaUseCase.addRepository(repository);
    }

    @Test
    public void modificarFechaPelicula() {
        when(repository.getEventsBy("1")).thenReturn(events());

        modificarFechaPeliculaUseCase.addRepository(repository);
        var command = new RequestCommand<>(new ModificarFechaPelicula(CarteleraId.of("1"),
                new Sede(SedeId.of("2"),
                        new Nombre("VivaEnvigado"),
                        new Direccion("calle 60", "Medellin")),
                PeliculaId.of("4"), new Fecha("01-02-2020")));

        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(
                        modificarFechaPeliculaUseCase, command
                ).orElseThrow();
        var events = response.getDomainEvents();
        FechaPeliculaActualizada fechaPeliculaActualizada = (FechaPeliculaActualizada) events.get(1);
        Assertions.assertEquals("01-02-2020", fechaPeliculaActualizada.getNuevaFechaPelicula().value());
    }

    private List<DomainEvent> events() {
        return List.of(new CarteleraCreada(CarteleraId.of("1"),
                        new Sede(SedeId.of("2"),
                                new Nombre("VivaEnvigado"),
                                new Direccion("calle 60", "Medellin"))),
                new PeliculaAgregada(PeliculaId.of("4"),
                        new Fecha("25-06-2019"),
                        new Genero("M"),
                        new Nombre("spiderman"))
        );
    }

}
