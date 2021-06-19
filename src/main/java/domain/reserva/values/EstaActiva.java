package domain.reserva.values;


import co.com.sofka.domain.generic.ValueObject;

public class EstaActiva implements ValueObject<EstaActiva.Values> {

    private final boolean disponible;
    private final String descripcion;

    public EstaActiva(boolean disponible, String descripcion) {
        this.disponible = disponible;
        this.descripcion = descripcion;
    }


    @Override
    public Values value() {

        return new Values() {
            @Override
            public boolean disponible() {
                return disponible;
            }

            @Override
            public String descripcion() {
                return descripcion;
            }
        };
    }

    public interface Values {
        boolean disponible();

        String descripcion();
    }
}
