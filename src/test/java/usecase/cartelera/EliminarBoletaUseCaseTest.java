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
import domain.reserva.command.EliminarBoleta;
import domain.reserva.events.BoletaEliminada;
import domain.reserva.events.ReservaAgregada;
import domain.reserva.values.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecase.EliminarBoletaUseCase;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EliminarBoletaUseCaseTest {
    EliminarBoletaUseCase eliminarBoletaUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        eliminarBoletaUseCase = new EliminarBoletaUseCase();
        repository = mock(DomainEventRepository.class);
        eliminarBoletaUseCase.addRepository(repository);


    }

    @Test
    public void eliminarBoleta() {
        List<Silla> sillas = new ArrayList<>();
        sillas.add(new Silla("50C", 500000, true));

        when(repository.getEventsBy("4")).thenReturn(events());
        var command = new RequestCommand<>(
                new EliminarBoleta(BoletaId.of("4"),
                        ReservaId.of("4"),
                        new Cliente(ClienteId.of("1152"),
                                new Estado("sano"),
                                new Edad(25),
                                new Nombre("salome")),
                        CarteleraId.of("1"),
                        new Sala(SalaId.of("1"),
                                new EstaActiva(true, "disponible"),
                                new Nombre("imax"), sillas),
                        new Fecha("25-12-2021"))
        );
        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("4")
                .syncExecutor(
                        eliminarBoletaUseCase, command
                ).orElseThrow();
        var events = response.getDomainEvents();
        BoletaEliminada boletaEliminada = (BoletaEliminada) events.get(1);
    }

    private List<DomainEvent> events() {
        List<Silla> sillas = new ArrayList<>();
        sillas.add(new Silla("50C", 500000, true));
        return List.of(new ReservaAgregada(ReservaId.of("4"),
                new Cliente(ClienteId.of("2"),
                        new Estado("sano"),
                        new Edad(40),
                        new Nombre("Rosa")),
                CarteleraId.of("5"),
                new Sala(SalaId.of("13"),
                        new EstaActiva(true, "Disponible"),
                        new Nombre("imax"), sillas),
                new Factura(FacturaId.of("552"),
                        new Total(50000)),
                new Fecha("15-06-2021")));
    }
}
