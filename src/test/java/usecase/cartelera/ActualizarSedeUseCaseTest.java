package usecase.cartelera;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cartelera.Sede;
import domain.cartelera.command.ActualizarSede;
import domain.cartelera.events.CarteleraCreada;
import domain.cartelera.events.PeliculaAgregada;
import domain.cartelera.events.SedeActualizada;
import domain.cartelera.values.*;
import domain.generalvalues.Fecha;
import domain.generalvalues.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecase.ActualizarSedeUseCase;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActualizarSedeUseCaseTest {
    ActualizarSedeUseCase actualizarSedeUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        actualizarSedeUseCase = new ActualizarSedeUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarSedeUseCase.addRepository(repository);
    }

    @Test
    public void actualizarSede() {
        when(repository.getEventsBy("1")).thenReturn(events());

        actualizarSedeUseCase.addRepository(repository);
        var cammand = new RequestCommand<>(new ActualizarSede(
                CarteleraId.of("2"),
                new Sede(SedeId.of("5"),
                        new Nombre("viscalla"),
                        new Direccion("calle 50 bz 90", "Medellin"))));

        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("1")
                .syncExecutor(
                        actualizarSedeUseCase, cammand
                ).orElseThrow();
        var events = response.getDomainEvents();
        SedeActualizada sedeActualizada = (SedeActualizada) events.get(1);
        Assertions.assertEquals("calle 50 bz 90", sedeActualizada.getDireccion().value().direccion());
    }

    private List<DomainEvent> events() {
        return List.of(new CarteleraCreada(CarteleraId.of("1"),
                        new Sede(SedeId.of("2"),
                                new Nombre("VivaEnvigado"),
                                new Direccion("calle 60", "Medellin"))),
                new PeliculaAgregada(PeliculaId.of("4"),
                        new Fecha("25-06-2015"),
                        new Genero("M"),
                        new Nombre("spiderman")));
    }
}
