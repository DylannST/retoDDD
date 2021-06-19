package usecase.cartelera;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import domain.cartelera.values.CarteleraId;
import domain.generalvalues.Fecha;
import domain.generalvalues.Nombre;
import domain.reserva.Cliente;
import domain.reserva.Sala;
import domain.reserva.command.AgregarReserva;
import domain.reserva.events.ReservaAgregada;
import domain.reserva.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecase.AgregarReservaUseCase;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class AgregarReservaUseCaseTest {
    AgregarReservaUseCase agregarReservaUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void sstup() {
        agregarReservaUseCase = new AgregarReservaUseCase();
        repository = mock(DomainEventRepository.class);
        agregarReservaUseCase.addRepository(repository);
    }

    @Test
    public void agregarReserva() {
        List<Silla> sillas = new ArrayList<>();
        sillas.add(new Silla("15B", 15000, true));
        sillas.add(new Silla("16B", 4000, false));
        var command = new RequestCommand<>(new AgregarReserva(ReservaId.of("1"),
                new Cliente(ClienteId.of("2"),
                        new Estado("normal"),
                        new Edad(15),
                        new Nombre("pepe")),
                CarteleraId.of("5"),
                new Sala(SalaId.of("23"),
                        new EstaActiva(true, "disponible"),
                        new Nombre("imax"),
                        sillas),
                new Fecha("25-09-2021")));

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("2")
                .syncExecutor(agregarReservaUseCase, command)
                .orElseThrow();

        var events = response.getDomainEvents();

        ReservaAgregada reservaAgregada = (ReservaAgregada) events.get(0);
        Assertions.assertEquals("1", reservaAgregada.getEntityId().value());

    }
}
