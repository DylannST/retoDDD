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
import domain.reserva.command.CrearFactura;
import domain.reserva.events.FacturaCreada;
import domain.reserva.events.ReservaAgregada;
import domain.reserva.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecase.CrearFacturaUseCase;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CrearFacturaUseCaseTest {
    CrearFacturaUseCase crearFacturaUseCase;
    private DomainEventRepository repository;

    @BeforeEach
    public void setup() {
        crearFacturaUseCase = new CrearFacturaUseCase();
        repository = mock(DomainEventRepository.class);
        crearFacturaUseCase.addRepository(repository);

    }

    @Test
    public void crearFactura() {
        when(repository.getEventsBy("2")).thenReturn(events());
        crearFacturaUseCase.addRepository(repository);
        List<Silla> sillas = new ArrayList<>();
        sillas.add(new Silla("15B", 15000, true));

        var command = new RequestCommand<>(new CrearFactura(
                ReservaId.of("1"),
                new Cliente(ClienteId.of("3"),
                        new Estado("sano"),
                        new Edad(15),
                        new Nombre("pedro")),
                CarteleraId.of("5"),
                new Sala(SalaId.of("23"),
                        new EstaActiva(true, "disponible"),
                        new Nombre("imax"),
                        sillas),
                new Factura(FacturaId.of("3"),
                        new Total(16000))

        ));

        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor("2")
                .syncExecutor(crearFacturaUseCase, command)
                .orElseThrow();

        var events = response.getDomainEvents();
        FacturaCreada facturaCreada = (FacturaCreada) events.get(1);
        Assertions.assertNotNull(facturaCreada);
    }

    private List<DomainEvent> events() {
        List<Silla> sillas = new ArrayList<>();
        sillas.add(new Silla("144A", 3000, false));
        return List.of(new ReservaAgregada(
                ReservaId.of("2"),
                new Cliente(ClienteId.of("3"),
                        new Estado("sano"),
                        new Edad(15),
                        new Nombre("pedro")),
                CarteleraId.of("5"),
                new Sala(SalaId.of("23"),
                        new EstaActiva(true, "disponible"),
                        new Nombre("imax"),
                        sillas),
                new Factura(FacturaId.of("3"),
                        new Total(15000)),
                new Fecha("25-06-2021")
        ));
    }
}
