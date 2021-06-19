package domain.reserva;

import co.com.sofka.domain.generic.Entity;
import domain.reserva.values.FacturaId;
import domain.reserva.values.Total;

import java.util.Objects;

public class Factura extends Entity<FacturaId> {


    private Total total;

    public Factura(FacturaId facturaId, Total total) {
        super(facturaId);
        this.total = total;
    }

    public void actualizarTotal(Total total) {
        this.total = Objects.requireNonNull(total, "el nuevo total de la factura es null");
    }

    public Total getTotal() {
        return total;
    }
}
