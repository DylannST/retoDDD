package domain.reserva.values;

import co.com.sofka.domain.generic.ValueObject;

public class Estado implements ValueObject<String> {

    private final String estado;

    public Estado(String estado) {
        this.estado = estado;
    }

    @Override
    public String value() {
        return estado;
    }
}
