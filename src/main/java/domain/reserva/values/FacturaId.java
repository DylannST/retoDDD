package domain.reserva.values;

import co.com.sofka.domain.generic.Identity;

public class FacturaId extends Identity {
    public FacturaId() {

    }

    private FacturaId(String id) {
        super(id);
    }

    public static FacturaId of(String id) {
        return new FacturaId(id);
    }
}
