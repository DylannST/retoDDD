package domain.cartelera.values;

import co.com.sofka.domain.generic.Identity;

public class PeliculaId extends Identity {
    public PeliculaId() {

    }

    private PeliculaId(String id) {
        super(id);
    }

    public static PeliculaId of(String id) {
        return new PeliculaId(id);
    }
}
