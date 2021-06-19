package domain.cartelera.values;

import co.com.sofka.domain.generic.Identity;

public class SedeId extends Identity {
    public SedeId() {

    }

    private SedeId(String id) {
        super(id);
    }

    public static SedeId of(String id) {
        return new SedeId(id);
    }
}
