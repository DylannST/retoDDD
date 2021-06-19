package domain.cartelera;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cartelera.events.*;
import domain.cartelera.values.*;
import domain.generalvalues.Fecha;
import domain.generalvalues.Nombre;

import java.util.List;

public class Cartelera extends AggregateEvent<CarteleraId> {

    protected List<Formato> formatos;
    protected Sede sede;
    protected List<Pelicula> peliculas;

    public Cartelera(CarteleraId carteleraId, Sede sede) {
        super(carteleraId);
        this.sede = sede;
        appendChange(new CarteleraCreada(carteleraId, sede)).apply();
    }

    public static Cartelera from(CarteleraId carteleraId, Sede sede, List<DomainEvent> events) {
        var carterela = new Cartelera(carteleraId, sede);
        events.forEach(carterela::applyEvent);
        return carterela;
    }


    public void agregarPelicula(PeliculaId peliculaId, Fecha fechaPelicula, Genero genero, Nombre nombrePelicula) {
        appendChange(new PeliculaAgregada(peliculaId, fechaPelicula, genero, nombrePelicula)).apply();
    }

    public void actualizarPelicula(PeliculaId peliculaId, Fecha fechaPelicula, Genero genero, Nombre nombrePelicula) {
        appendChange(new PeliculaActualizada(peliculaId, fechaPelicula, genero, nombrePelicula)).apply();
    }

    public void modificarFechaPelicula(PeliculaId peliculaId, Fecha nuevaFechaPelicula) {
        appendChange(new FechaPeliculaActualizada(peliculaId, nuevaFechaPelicula)).apply();
    }

    public void actualizarSede(SedeId sedeId, Nombre nombreSede, Direccion direccion) {
        appendChange(new SedeActualizada(sedeId, nombreSede, direccion)).apply();
    }

    public void agregarFormato(FormatoId formatoId, Restriccion restriccion, Tipo tipo) {
        appendChange(new FormatoAgregado(formatoId, restriccion, tipo)).apply();
    }

    public void modificarRestriccionFormato(FormatoId formatoId, Restriccion restriccion) {
        appendChange(new RestriccionFormatoActualizada(formatoId, restriccion)).apply();
    }

    public void modificarTipoFormato(FormatoId formatoId, Tipo tipo) {
        appendChange(new TipoFormatoActualizado(formatoId, tipo)).apply();
    }

    public void modificarDireccionSede(SedeId sedeId, Direccion direccion) {
        appendChange(new DireccionSedeActualizada(sedeId, direccion)).apply();
    }

    public void actualizarFormato(FormatoId formatoId, Restriccion restriccion, Tipo tipo) {
        appendChange(new FormatoActualizado(formatoId, restriccion, tipo)).apply();
    }

    public void eliminarPelicula(PeliculaId peliculaId) {
        appendChange(new PeliculaEliminada(peliculaId)).apply();
    }


}
