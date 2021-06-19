package usecase.cartelera;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cartelera.values.CarteleraId;
import domain.generalvalues.Fecha;
import domain.generalvalues.Nombre;
import domain.reserva.Cliente;
import domain.reserva.Factura;
import domain.reserva.Sala;
import domain.reserva.command.ActualizarEstaActiva;
import domain.reserva.events.EstaActivaActualizado;
import domain.reserva.events.ReservaAgregada;
import domain.reserva.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecase.ActualizarEstaActivaUseCase;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ActualizarEstaActivaUseCaseTest {
    ActualizarEstaActivaUseCase actualizarEstaActivaUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        actualizarEstaActivaUseCase = new ActualizarEstaActivaUseCase();
        repository = mock(DomainEventRepository.class);
        actualizarEstaActivaUseCase.addRepository(repository);
    }

    @Test
    public void actualizarEstadoActiva() {
        when(repository.getEventsBy("2")).thenReturn(events());

        actualizarEstaActivaUseCase.addRepository(repository);
        List<Silla> sillas = new ArrayList<>();
        sillas.add(new Silla("50C", 20000, false));
        var command = new RequestCommand<>(
                new ActualizarEstaActiva(ReservaId.of("2"),
                        new Cliente(ClienteId.of("3"),
                                new Estado("cumple"),
                                new Edad(25),
                                new Nombre("rigoberto")),
                        CarteleraId.of("5"),
                        new Sala(SalaId.of("3"),
                                new EstaActiva(false, "se dañaron sillas"),
                                new Nombre("imax"), sillas
                        ), new Fecha("25-08-2015")));
        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("2")
                .syncExecutor(
                        actualizarEstaActivaUseCase, command
                ).orElseThrow();
        var events = response.getDomainEvents();
        EstaActivaActualizado estaActivaActualizado = (EstaActivaActualizado) events.get(1);
        Assertions.assertEquals(false, estaActivaActualizado.getEstaActiva().value().disponible());
    }

    private List<DomainEvent> events() {
        List<Silla> sillas = new ArrayList<>();
        sillas.add(new Silla("50C", 500000, true));
        sillas.add(new Silla("44a", 30000, false));
        return List.of(new ReservaAgregada(ReservaId.of("2"),
                new Cliente(ClienteId.of("2"),
                        new Estado("normal"),
                        new Edad(15),
                        new Nombre("pepe")),
                CarteleraId.of("5"),
                new Sala(SalaId.of("23"),
                        new EstaActiva(true, "disponible"),
                        new Nombre("imax"),
                        sillas), new Factura(FacturaId.of("3"),
                new Total(500000)),
                new Fecha("25-09-2021")));
    }
}
