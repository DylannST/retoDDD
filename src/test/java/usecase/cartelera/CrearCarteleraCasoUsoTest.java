package usecase.cartelera;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.cartelera.Sede;
import domain.cartelera.command.CrearCartelera;
import domain.cartelera.events.CarteleraCreada;
import domain.cartelera.values.CarteleraId;
import domain.cartelera.values.Direccion;
import domain.cartelera.values.SedeId;
import domain.generalvalues.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecase.CrearCarteleraUseCase;

public class CrearCarteleraCasoUsoTest {

    public CrearCarteleraUseCase crearCarteleraUseCase;

    @BeforeEach
    public void setup() {
        crearCarteleraUseCase = new CrearCarteleraUseCase();
    }

    @Test
    public void crearCartelera() {
        var command = new CrearCartelera(
                CarteleraId.of("1"),
                new Sede(SedeId.of("5"), new Nombre("viva envigado"), new Direccion("cr 25c #65b 32", "Medellin"))
        );


        var response = UseCaseHandler.getInstance().syncExecutor(
                crearCarteleraUseCase, new RequestCommand<>(command)
        ).orElseThrow();

        var event = response.getDomainEvents();

        CarteleraCreada carteleraCreada = (CarteleraCreada) event.get(0);
        Assertions.assertEquals("1", carteleraCreada.getCarteleraId().value());

    }
}
