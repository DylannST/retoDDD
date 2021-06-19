package usecase.cartelera;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cartelera.Sede;
import domain.cartelera.command.ActualizarTipoFormato;
import domain.cartelera.events.CarteleraCreada;
import domain.cartelera.events.FormatoActualizado;
import domain.cartelera.events.FormatoAgregado;
import domain.cartelera.events.PeliculaAgregada;
import domain.cartelera.values.*;
import domain.generalvalues.Fecha;
import domain.generalvalues.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecase.FormatoTipoActualizadoUseCase;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FormatoTipoActualizadoUseCaseTest {
    FormatoTipoActualizadoUseCase formatoActualizadoUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        formatoActualizadoUseCase = new FormatoTipoActualizadoUseCase();
        repository = mock(DomainEventRepository.class);
        formatoActualizadoUseCase.addRepository(repository);
    }

    @Test
    public void actualizarFormatoTipo() {
        when(repository.getEventsBy("10")).thenReturn(events());

        formatoActualizadoUseCase.addRepository(repository);

        var command = new RequestCommand<>(
                new ActualizarTipoFormato(CarteleraId.of("10"),
                        new Sede(SedeId.of("2"),
                                new Nombre("VivaEnvigado"),
                                new Direccion("calle 60", "Medellin")),
                        FormatoId.of("3"),
                        new Restriccion("no se permite paranoicos"),
                        new Tipo("3D"))
        );
        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("10")
                .syncExecutor(
                        formatoActualizadoUseCase, command
                ).orElseThrow();
        var events = response.getDomainEvents();
        FormatoActualizado formatoActualizado = (FormatoActualizado) events.get(1);
        Assertions.assertEquals("3D", formatoActualizado.getTipo().value());

    }

    public List<DomainEvent> events() {
        return List.of(new CarteleraCreada(CarteleraId.of("10"),
                        new Sede(SedeId.of("2"),
                                new Nombre("VivaEnvigado"),
                                new Direccion("calle 60", "Medellin"))),
                new PeliculaAgregada(PeliculaId.of("4"),
                        new Fecha("25-06-2015"),
                        new Genero("M"),
                        new Nombre("spiderman")),
                new FormatoAgregado(FormatoId.of("1"),
                        new Restriccion("no se permite raquiticos"),
                        new Tipo("4D")));
    }
}
