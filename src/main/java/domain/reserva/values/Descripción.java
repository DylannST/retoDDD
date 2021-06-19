package domain.reserva.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Descripción implements ValueObject<String> {

    private final String descripcion;

    public Descripción(String descripcion) {
        this.descripcion = Objects.requireNonNull(descripcion, "la descripción esta nulo");
    }

    @Override
    public String value() {
        return descripcion;
    }
}
