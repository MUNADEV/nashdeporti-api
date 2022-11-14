package cl.nash.nashdeportiapi.controller.busqueda;

import cl.nash.nashdeportiapi.service.busqueda.BusquedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CU-06 Permitir la busqueda de deporte y deportista
 */
@RestController
@CrossOrigin
@RequestMapping("/api/busqueda")
public class BusquedaController {

    @Autowired
    BusquedaService busquedaService;

    /**
     * Busqueda de deportista mediante nombre, puede ser nombre o nombre y apellido juntos
     * @param nombreDeportista Nombre del deportista
     * @return Lista de deporitsta coindicentes
     */
    @GetMapping("/deportista/{nombreDeportista}")
    public List<Object> obtenerDeportistasXNombre(@PathVariable("nombreDeportista") String nombreDeportista){
        return busquedaService.obtenerDeportistasXNombre(nombreDeportista);
    }

    /**
     * Busqueda de equipo mediante nombre
     * @param nombreEquipo Nombre del equipo
     * @return Lista de equipos coincidentes
     */
    @GetMapping("/equipo/{nombreEquipo}")
    public List<Object> obtenerEquiposXNombre(@PathVariable("nombreEquipo") String nombreEquipo) {
        return busquedaService.obtenerEquiposXNombre(nombreEquipo);
    }


}
