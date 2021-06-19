package domain.cartelera;

import co.com.sofka.domain.generic.EventChange;
import domain.cartelera.events.*;

import java.util.ArrayList;

public class CarteleraChange extends EventChange {

    public CarteleraChange(Cartelera cartelera) {

        apply((CarteleraCreada event) -> {
            cartelera.formatos = new ArrayList<>();
            cartelera.sede = event.getSede();
            cartelera.peliculas = new ArrayList<>();
        });


        apply((PeliculaAgregada event) -> {
            Pelicula peliculaAux = new Pelicula(event.getPeliculaId(), event.getFechaPelicula(), event.getGenero(), event.getNombrePelicula());
            cartelera.peliculas.add(peliculaAux);
        });


        apply((PeliculaActualizada event) -> {

            cartelera.peliculas.stream().map(peli -> {
                if (peli.identity().equals(event.getPeliculaId())) {
                    peli = event.peliculaActualizada();
                }
                return peli;
            });
        });


        apply((FechaPeliculaActualizada event) -> {
            cartelera.peliculas.stream().map(peli -> {
                if (peli.identity().equals(event.getPeliculaId())) {
                    peli.modificarFechaPelicula(event.getNuevaFechaPelicula());
                }
                return peli;
            });
        });


        apply((SedeActualizada event) -> {
            cartelera.sede = new Sede(event.getSedeId(), event.getNombreSede(), event.getDireccion());
        });
        apply((DireccionSedeActualizada event) -> {
            cartelera.sede.modificarDireccionSede(event.getDireccion());
        });

        apply((FormatoAgregado event) -> {
            Formato formatoAux = new Formato(event.getFormatoId(), event.getRestriccion(), event.getTipo());
            cartelera.formatos.add(formatoAux);
        });

        apply((FormatoActualizado event) -> {
            cartelera.formatos.stream().map(formato -> {
                if (formato.identity().equals(event.getFormatoId())) {
                    formato = event.formatoActualizado();
                }
                return formato;
            });
        });

        apply((RestriccionFormatoActualizada event) -> {
            cartelera.formatos.stream().map(formato -> {
                if (formato.identity().equals(event.getFormatoId())) {
                    formato.modificarRestriccion(event.getRestriccion());
                }
                return formato;
            });
        });
        apply((TipoFormatoActualizado event) -> {
            cartelera.formatos.stream().map(formato -> {
                if (formato.identity().equals(event.getFormatoId())) {
                    formato.modificarTipoFormato(event.getTipo());
                }
                return formato;
            });
        });

        apply((PeliculaEliminada event) -> {
            int contador = 0;
            for (Pelicula pelicula : cartelera.peliculas) {
                if (pelicula.identity().equals(event.getPeliculaId())) {
                    break;
                }
                contador++;
            }
            cartelera.peliculas.remove(contador);
            cartelera.formatos.remove(contador);
        });
    }
}
