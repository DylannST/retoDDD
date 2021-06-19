package domain.cartelera.values;

import co.com.sofka.domain.generic.Identity;

public class FormatoId extends Identity {
    public FormatoId() {

    }

    private FormatoId(String id) {
        super(id);
    }

    public static FormatoId of(String id) {
        return new FormatoId(id);
    }
}
