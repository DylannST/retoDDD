package domain.generalvalues;

import co.com.sofka.domain.generic.ValueObject;

public class Fecha implements ValueObject<String> {
    private final String fecha;

    public Fecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String value() {
        return fecha;
    }
}
