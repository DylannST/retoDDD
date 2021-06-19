package domain.reserva.values;

import co.com.sofka.domain.generic.ValueObject;

public class Edad implements ValueObject<Integer> {

    private final int edad;

    public Edad(int edad) {
        this.edad = edad;
    }

    @Override
    public Integer value() {
        return edad;
    }
}
