package cl.nash.nashdeportiapi.controller.equipos;

import cl.nash.nashdeportiapi.model.Equipo;
import cl.nash.nashdeportiapi.service.equipo.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/equipo")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @PostMapping
    public Equipo registrar(@RequestBody Equipo equipo) {
        return equipoService.guardarEquipo(equipo);
    }

    @PutMapping("/{id}/actualizar")
    public Equipo actualizar(@RequestBody Equipo equipo) {
        return equipoService.guardarEquipo(equipo);
    }

    @DeleteMapping("/{id}/borrar")
    public void borrarPorId(@PathVariable String id) {
        equipoService.borrarPorId(id);
    }

    @GetMapping("/{id}")
    public Optional<Equipo> obtenerEquipoXId(@PathVariable("id") String id) {
        return equipoService.obtenerEquipoXId(id);
    }

    @GetMapping("/todos")
    public List<Equipo> obtenerEquipos() {
        return equipoService.obtenerTodos();
    }

    @PostMapping("/crear")
    public boolean crearEquipo(@RequestParam String idDeportista,
                               @RequestParam String nombre,
                               @RequestParam String descripcion){
        return equipoService.crearEquipo(idDeportista,nombre,descripcion);
    }


}
