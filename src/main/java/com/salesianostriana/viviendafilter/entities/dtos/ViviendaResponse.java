package com.salesianostriana.viviendafilter.entities.dtos;

import com.salesianostriana.viviendafilter.entities.Vivienda;

public record ViviendaResponse(
        Long id,
        String titulo,
        String ciudad,
        String provincia,
        Integer precio,
        Integer metrosCuadrados,
        Integer habitaciones,
        Integer banos,
        String tipo,
        String estado,
        Boolean disponible,
        String fechaPublicacion
) {

    public static ViviendaResponse to(Vivienda vivienda) {
        return new ViviendaResponse(
                vivienda.getId(),
                vivienda.getTitulo(),
                vivienda.getCiudad(),
                vivienda.getProvincia(),
                vivienda.getPrecio(),
                vivienda.getMetrosCuadrados(),
                vivienda.getHabitaciones(),
                vivienda.getBanos(),
                vivienda.getTipo().name(),
                vivienda.getEstado().name(),
                vivienda.getDisponible(),
                vivienda.getFechaPublicacion().toString()
        );
    }

}
