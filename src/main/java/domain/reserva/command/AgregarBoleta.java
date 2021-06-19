package domain.reserva.command;

import co.com.sofka.domain.generic.Command;
import domain.reserva.values.BoletaId;
import domain.reserva.values.Descripción;
import domain.reserva.values.SalaId;

public class AgregarBoleta implements Command {
    private final BoletaId boletaId;
    private final SalaId salaId;
    private final Descripción descripciónBoleta;

    public AgregarBoleta(BoletaId boletaId, SalaId salaId, Descripción descripciónBoleta) {
        this.boletaId = boletaId;
        this.salaId = salaId;
        this.descripciónBoleta = descripciónBoleta;
    }

    public BoletaId getBoletaId() {
        return boletaId;
    }

    public SalaId getSalaId() {
        return salaId;
    }

    public Descripción getDescripciónBoleta() {
        return descripciónBoleta;
    }
}
