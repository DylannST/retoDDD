package domain.cartelera.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Restriccion implements ValueObject<String> {
    private final String value;

    public Restriccion(String value) {
        this.value = Objects.requireNonNull(value, "La restricion esta nula");
    }

    @Override
    public String value() {
        return value;
    }
}
