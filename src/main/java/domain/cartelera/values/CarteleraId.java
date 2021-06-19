package domain.cartelera.values;

import co.com.sofka.domain.generic.Identity;

public class CarteleraId extends Identity {
    public CarteleraId() {

    }

    private CarteleraId(String id) {
        super(id);
    }

    public static CarteleraId of(String id) {
        return new CarteleraId(id);
    }
}
