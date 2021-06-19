package domain.reserva.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.generalvalues.Nombre;
import domain.reserva.values.EstaActiva;
import domain.reserva.values.SalaId;
import domain.reserva.values.Silla;

import java.util.List;

public class SalaAgregada extends DomainEvent {
    private final SalaId salaId;
    private final EstaActiva estaActiva;
    private final Nombre nombreSala;
    private final List<Silla> sillas;

    public SalaAgregada(SalaId salaId, EstaActiva estaActiva, Nombre nombreSala, List<Silla> sillas) {
        super("domain.cartelera.SalaAgregada");
        this.salaId = salaId;
        this.estaActiva = estaActiva;
        this.nombreSala = nombreSala;
        this.sillas = sillas;
    }

    public SalaId getSalaId() {
        return salaId;
    }

    public EstaActiva getEstaActiva() {
        return estaActiva;
    }

    public Nombre getNombreSala() {
        return nombreSala;
    }

    public List<Silla> getSillas() {
        return sillas;
    }
}
