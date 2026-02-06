package com.salesianostriana.viviendafilter.entities.dtos;

import com.salesianostriana.viviendafilter.entities.Vivienda;
import com.salesianostriana.viviendafilter.entities.extras.EstadoVivienda;
import com.salesianostriana.viviendafilter.entities.extras.TipoVivienda;
import com.salesianostriana.viviendafilter.validations.MetrosCuadradosLimite;
import com.salesianostriana.viviendafilter.validations.PrecioLimite;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/*
*
* titulo String @NotBlank, @Size(max=120)
* descripcion String @Size(max=2000) (opcional)
* ciudad String @NotBlank, @Size(max=80)
* provincia String @NotBlank, @Size(max=80)
* precio Integer @NotNull, @Min(0)
* metrosCuadrados Integer @NotNull, @Min(1)
* habitaciones Integer @NotNull, @Min(0)
* banos Integer @NotNull, @Min(0)
* tipo TipoVivienda @NotNull
* estado EstadoVivienda @NotNull
* ascensor Boolean @NotNull
* terraza Boolean @NotNull
* garaje Boolean @NotNull
* disponible Boolean @NotNull
* */

public record ViviendaCreateRequest (
        @NotBlank @Size(max = 120)
        String titulo,
        @Size(max = 2000)
        String descripcion,
        @NotBlank @Size(max = 80)
        String ciudad,
        @NotBlank @Size(max = 80)
        String provincia,
        @NotNull @Min(0) @PrecioLimite(value = 1000000)
        Integer precio,
        @NotNull @Min(1) @MetrosCuadradosLimite(value = 1000)
        Integer metrosCuadrados,
        @NotNull @Min(0)
        Integer habitaciones,
        @NotNull @Min(0)
        Integer banos,
        @NotNull
        TipoVivienda tipo,
        @NotNull
        EstadoVivienda estado,
        @NotNull
        Boolean ascensor,
        @NotNull
        Boolean terraza,
        @NotNull
        Boolean garaje,
        @NotNull
        Boolean disponible
        

) {
    public Vivienda to() {
        return Vivienda.builder()
                .titulo(this.titulo)
                .descripcion(this.descripcion)
                .ciudad(this.ciudad)
                .provincia(this.provincia)
                .precio(this.precio)
                .metrosCuadrados(this.metrosCuadrados)
                .habitaciones(this.habitaciones)
                .banos(this.banos)
                .tipo(this.tipo)
                .estado(this.estado)
                .ascensor(this.ascensor)
                .terraza(this.terraza)
                .garaje(this.garaje)
                .disponible(this.disponible)
                .build();
    }
}
