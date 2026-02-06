package com.salesianostriana.viviendafilter.entities;

import com.salesianostriana.viviendafilter.entities.extras.EstadoVivienda;
import com.salesianostriana.viviendafilter.entities.extras.TipoVivienda;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity @Table(name = "viviendas")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
@Builder
public class Vivienda {

    /* -- Atributos --

    id - Long
    titulo - String
    descripcion - String
    ciudad - String
    provincia - String
    precio - Integer
    metrosCuadrados - Integer
    habitaciones - Integer
    banos - Integer
    tipo - TipoVivienda (enum)
    estado - EstadoVivienda (enum)
    ascensor - Boolean
    terraza - Boolean
    garaje - Boolean
    disponible - Boolean
    fechaPublicacion - LocalDate
    * */

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;
    private String descripcion;
    private String ciudad;
    private String provincia;

    private Integer precio;
    private Integer metrosCuadrados;
    private Integer habitaciones;
    private Integer banos;

    private Boolean ascensor;
    private Boolean terraza;
    private Boolean garaje;
    private Boolean disponible;

    @Enumerated(EnumType.STRING)
    private TipoVivienda tipo;
    @Enumerated(EnumType.STRING)
    private EstadoVivienda estado;

    private LocalDate fechaPublicacion;


}
