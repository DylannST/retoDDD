package domain.reserva.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Total implements ValueObject<Double> {
    private final double total;

    public Total(double total) {
        this.total = Objects.requireNonNull(total, "el total no puede ser nulo");
    }


    @Override
    public Double value() {
        return null;
    }
}
