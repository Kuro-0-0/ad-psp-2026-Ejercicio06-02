package com.salesianostriana.viviendafilter.services;

import com.salesianostriana.viviendafilter.entities.Vivienda;
import com.salesianostriana.viviendafilter.entities.dtos.ViviendaFilter;
import com.salesianostriana.viviendafilter.repositories.ViviendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ViviendaService {

    private final ViviendaRepository repository;

    public Page<Vivienda> getAllViviendas(Pageable pageable, ViviendaFilter filters) {
        PredicateSpecification<Vivienda> spec;

        if (filters.minPrecio() != null && filters.maxPrecio() != null &&
                filters.minPrecio() > filters.maxPrecio())
            throw new IllegalArgumentException("No puedes introducir un precio mínimo mayor que el máximo.");

        if (filters.metrosMin() != null && filters.metrosMax() != null &&
                filters.metrosMin() > filters.metrosMax())
            throw new IllegalArgumentException("No puedes introducir unos metros mínimos mayores que los máximos.");

        if (pageable.getPageSize() > 50)
            throw new IllegalArgumentException("El tamaño máximo de página es 50.");

        spec = PredicateSpecification.allOf(
                ViviendaSpecifications.hasCiudad(filters.ciudad()),
                ViviendaSpecifications.hasProvincia(filters.provincia()),
                ViviendaSpecifications.minPrecioLesserThan(filters.minPrecio()),
                ViviendaSpecifications.maxPrecioGreaterThan(filters.maxPrecio()),
                ViviendaSpecifications.metrosMinLesserThan(filters.metrosMin()),
                ViviendaSpecifications.metrosMaxGreaterThan(filters.metrosMax()),
                ViviendaSpecifications.habitacionesMinLesserThan(filters.habitacionesMin()),
                ViviendaSpecifications.banosMinLesserThan(filters.banosMin()),
                ViviendaSpecifications.hasTipo(filters.tipo()),
                ViviendaSpecifications.hasEstado(filters.estado()),
                ViviendaSpecifications.hasAscensor(filters.ascensor()),
                ViviendaSpecifications.hasTerraza(filters.terraza()),
                ViviendaSpecifications.hasGaraje(filters.garaje()),
                ViviendaSpecifications.isDisponible(filters.soloDisponibles())
        );
        return repository.findBy(spec, q -> q.page(pageable));
    }

    public interface ViviendaSpecifications {

        static PredicateSpecification<Vivienda> hasCiudad(String ciudad) {
            return (from, builder) ->
                    ciudad == null
                        ? builder.and()
                        : builder.like(builder.lower(from.get("ciudad")), "%" + ciudad.toLowerCase() + "%");
        }

        static PredicateSpecification<Vivienda> hasProvincia(String provincia) {
            return (from, builder) ->
                    provincia == null
                        ? builder.and()
                        : builder.equal(builder.lower(from.get("provincia")), provincia.toLowerCase());
        }

        static PredicateSpecification<Vivienda> minPrecioLesserThan(Integer minPrecio) {
            return (from, builder) ->
                    minPrecio == null
                        ? builder.and()
                        : builder.greaterThanOrEqualTo(from.get("precio"), minPrecio);
        }

        static PredicateSpecification<Vivienda> maxPrecioGreaterThan(Integer maxPrecio) {
            return (from, builder) ->
                    maxPrecio == null
                        ? builder.and()
                        : builder.lessThanOrEqualTo(from.get("precio"), maxPrecio);
        }

        static PredicateSpecification<Vivienda> metrosMinLesserThan(Integer metrosMin) {
            return (from, builder) ->
                    metrosMin == null
                        ? builder.and()
                        : builder.greaterThanOrEqualTo(from.get("metrosCuadrados"), metrosMin);
        }

        static PredicateSpecification<Vivienda> metrosMaxGreaterThan(Integer metrosMax) {
            return (from, builder) ->
                    metrosMax == null
                        ? builder.and()
                        : builder.lessThanOrEqualTo(from.get("metrosCuadrados"), metrosMax);
        }

        static PredicateSpecification<Vivienda> habitacionesMinLesserThan(Integer habitacionesMin) {
            return (from, builder) ->
                    habitacionesMin == null
                        ? builder.and()
                        : builder.greaterThanOrEqualTo(from.get("habitaciones"), habitacionesMin);
        }

        static PredicateSpecification<Vivienda> banosMinLesserThan(Integer banosMin) {
            return (from, builder) ->
                    banosMin == null
                        ? builder.and()
                        : builder.greaterThanOrEqualTo(from.get("banos"), banosMin);
        }

        static PredicateSpecification<Vivienda> hasTipo(String tipo) {
            return (from, builder) ->
                    tipo == null
                        ? builder.and()
                        : builder.equal(from.get("tipo"), tipo);
        }

        static PredicateSpecification<Vivienda> hasEstado(String estado) {
            return (from, builder) ->
                    estado == null
                        ? builder.and()
                        : builder.equal(from.get("estado"), estado);
        }

        static PredicateSpecification<Vivienda> hasAscensor(Boolean ascensor) {
            return (from, builder) ->
                    ascensor == null
                        ? builder.and()
                        : builder.equal(from.get("ascensor"), ascensor);
        }

        static PredicateSpecification<Vivienda> hasTerraza(Boolean terraza) {
            return (from, builder) ->
                    terraza == null
                        ? builder.and()
                        : builder.equal(from.get("terraza"), terraza);
        }

        static PredicateSpecification<Vivienda> hasGaraje(Boolean garaje) {
            return (from, builder) ->
                    garaje == null
                        ? builder.and()
                        : builder.equal(from.get("garaje"), garaje);
        }

        static PredicateSpecification<Vivienda> isDisponible(Boolean soloDisponibles) {
            return (from, builder) ->
                    soloDisponibles == null
                        ? builder.and()
                        : builder.equal(from.get("disponible"), true);
        }

    }

}
