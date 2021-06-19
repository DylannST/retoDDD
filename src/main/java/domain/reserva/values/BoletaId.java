package domain.reserva.values;

import co.com.sofka.domain.generic.Identity;

public class BoletaId extends Identity {
    public BoletaId() {

    }

    private BoletaId(String id) {
        super(id);
    }

    public static BoletaId of(String id) {
        return new BoletaId(id);
    }
}
