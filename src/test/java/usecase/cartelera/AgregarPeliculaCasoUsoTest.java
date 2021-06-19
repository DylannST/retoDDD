package usecase.cartelera;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cartelera.Sede;
import domain.cartelera.command.AgregarPelicula;
import domain.cartelera.events.CarteleraCreada;
import domain.cartelera.events.PeliculaAgregada;
import domain.cartelera.values.*;
import domain.generalvalues.Fecha;
import domain.generalvalues.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecase.AgregarPeliculaUseCase;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AgregarPeliculaCasoUsoTest {
    AgregarPeliculaUseCase agregarPeliculaUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        agregarPeliculaUseCase = new AgregarPeliculaUseCase();
        repository = mock(DomainEventRepository.class);
        agregarPeliculaUseCase.addRepository(repository);
    }

    @Test
    public void agregarPelicula() {
        when(repository.getEventsBy("2")).thenReturn(events());
        agregarPeliculaUseCase.addRepository(repository);

        var command = new RequestCommand<>(new AgregarPelicula(CarteleraId.of("1"),
                new Sede(SedeId.of("2"),
                        new Nombre("vivaEnvigado"),
                        new Direccion("cr 89a #55 32", "Medellin")),
                PeliculaId.of("3"),
                new Fecha("25-04-2020"),
                new Genero("M"),
                new Nombre("Roberto")));


        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("2")
                .syncExecutor(
                        agregarPeliculaUseCase, command)
                .orElseThrow();

        var event = response.getDomainEvents();
        PeliculaAgregada peliculaAgregada = (PeliculaAgregada) event.get(1);

        Assertions.assertEquals("3", peliculaAgregada.getPeliculaId().value());

    }

    private List<DomainEvent> events() {
        return List.of(new CarteleraCreada(CarteleraId.of("1"),
                new Sede(SedeId.of("2"),
                        new Nombre("vivaEnvigado"),
                        new Direccion("cr 89a #55 32", "Medellin")))
        );
    }
}
