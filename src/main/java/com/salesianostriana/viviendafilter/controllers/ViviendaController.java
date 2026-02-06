package com.salesianostriana.viviendafilter.controllers;

import com.salesianostriana.viviendafilter.entities.dtos.ViviendaFilter;
import com.salesianostriana.viviendafilter.entities.dtos.ViviendaResponse;
import com.salesianostriana.viviendafilter.entities.extras.EstadoVivienda;
import com.salesianostriana.viviendafilter.entities.extras.TipoVivienda;
import com.salesianostriana.viviendafilter.services.ViviendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller @RequiredArgsConstructor
public class ViviendaController {

    private final ViviendaService service;

    @GetMapping("/api/v1/viviendas")
    public ResponseEntity<Page<ViviendaResponse>> getAllViviendas(
            @PageableDefault(
            page = 0,
            size = 10,
            sort = "fechaPublicacion",
            direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam(required = false) String ciudad,
            @RequestParam(required = false) String provincia,
            @RequestParam(required = false) Integer minPrecio,
            @RequestParam(required = false) Integer maxPrecio,
            @RequestParam(required = false) Integer metrosMin,
            @RequestParam(required = false) Integer metrosMax,
            @RequestParam(required = false) Integer habitacionesMin,
            @RequestParam(required = false) Integer banosMin,
            @RequestParam(required = false) TipoVivienda tipo,
            @RequestParam(required = false) EstadoVivienda estado,
            @RequestParam(required = false) Boolean ascensor,
            @RequestParam(required = false) Boolean terraza,
            @RequestParam(required = false) Boolean garaje,
            @RequestParam(required = false) Boolean soloDisponibles
        )
    {
        ViviendaFilter filters = new ViviendaFilter(
                ciudad,
                provincia,
                minPrecio,
                maxPrecio,
                metrosMin,
                metrosMax,
                habitacionesMin,
                banosMin,
                tipo != null ? tipo.name() : null,
                estado != null ? estado.name() : null,
                ascensor,
                terraza,
                garaje,
                soloDisponibles
        );
        return ResponseEntity.ok(
                service.getAllViviendas(pageable, filters).map(ViviendaResponse::to)
        );
    }

}
