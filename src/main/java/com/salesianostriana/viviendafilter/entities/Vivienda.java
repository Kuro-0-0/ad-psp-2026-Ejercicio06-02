package com.salesianostriana.viviendafilter.entities;

import com.salesianostriana.viviendafilter.entities.extras.EstadoVivienda;
import com.salesianostriana.viviendafilter.entities.extras.TipoVivienda;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDate;

@Entity @Table(name = "viviendas")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Vivienda {

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

    @CreatedDate
    private LocalDate fechaPublicacion;


}
