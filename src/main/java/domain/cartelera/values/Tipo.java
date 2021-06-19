package domain.cartelera.values;

import co.com.sofka.domain.generic.ValueObject;

public class Tipo implements ValueObject {
    private final String value;

    public Tipo(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
