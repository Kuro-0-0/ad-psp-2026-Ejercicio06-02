package com.salesianostriana.viviendafilter.entities.dtos;

public record ViviendaFilter(
        String ciudad,
        String provincia,
        Integer minPrecio,
        Integer maxPrecio,
        Integer metrosMin,
        Integer metrosMax,
        Integer habitacionesMin,
        Integer banosMin,
        String tipo,
        String estado,
        Boolean ascensor,
        Boolean terraza,
        Boolean garaje,
        Boolean soloDisponibles
) {
}
