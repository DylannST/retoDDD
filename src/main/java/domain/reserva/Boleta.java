package domain.reserva;

import co.com.sofka.domain.generic.Entity;
import domain.reserva.values.BoletaId;
import domain.reserva.values.Descripción;
import domain.reserva.values.SalaId;

public class Boleta extends Entity<BoletaId> {


    private Descripción descripciónBoleta;

    public Boleta(BoletaId entityId,  Descripción descripciónBoleta) {
        super(entityId);
        this.descripciónBoleta = descripciónBoleta;
    }

    @Override
    public String toString() {
        return "Boleta{" +
                "descripción=" + descripciónBoleta +
                '}';
    }
}
