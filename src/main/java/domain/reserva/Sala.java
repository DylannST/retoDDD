package domain.reserva;

import co.com.sofka.domain.generic.Entity;
import domain.generalvalues.Nombre;
import domain.reserva.values.EstaActiva;
import domain.reserva.values.SalaId;
import domain.reserva.values.Silla;

import java.util.List;
import java.util.Objects;

public class Sala extends Entity<SalaId> {

    private EstaActiva estaActiva;
    private Nombre nombreSala;
    private List<Silla> sillas;


    public Sala(SalaId salaId, EstaActiva estaActiva, Nombre nombreSala, List<Silla> sillas) {
        super(salaId);
        this.estaActiva = Objects.requireNonNull(estaActiva, "estaActiva esta nulo");
        this.nombreSala = Objects.requireNonNull(nombreSala, "nombre de la sala esta nulo");
        this.sillas = Objects.requireNonNull(sillas, "la sillas estan nulas");
    }



    public void modificarEstaActiva(EstaActiva estaActiva) {
        this.estaActiva = Objects.requireNonNull(estaActiva, "el estaActiva esta nulo");
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
