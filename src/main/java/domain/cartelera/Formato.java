package domain.cartelera;

import co.com.sofka.domain.generic.Entity;
import domain.cartelera.values.FormatoId;
import domain.cartelera.values.Restriccion;
import domain.cartelera.values.Tipo;

import java.util.Objects;

public class Formato extends Entity {

    private Restriccion restriccion;
    private Tipo tipo;

    public Formato(FormatoId formatoId, Restriccion restriccion, Tipo tipo) {
        super(formatoId);
        this.restriccion = Objects.requireNonNull(restriccion, "las restricciones del formato esta nula");
        this.tipo = Objects.requireNonNull(tipo, "el tipo de la pelicula esta nulo");
    }


    public void modificarRestriccion(Restriccion restriccion) {
        this.restriccion = restriccion;
    }

    public void modificarTipoFormato(Tipo tipo) {
        this.tipo = tipo;
    }

    public Restriccion getRestriccion() {
        return restriccion;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
