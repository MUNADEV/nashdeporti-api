package cl.nash.nashdeportiapi.controller.deportista;

import cl.nash.nashdeportiapi.model.Deporte;
import cl.nash.nashdeportiapi.service.deportista.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/deporte")
public class DeporteController {

    @Autowired
    private DeporteService deporteService;

    @PostMapping
    public Deporte registrar(@RequestBody Deporte deporte) {
        return deporteService.registrarDeporte(deporte);
    }

    @PutMapping("/{id}/actualizar")
    public Deporte actualizar(@RequestBody Deporte deporte) {
        return deporteService.registrarDeporte(deporte);
    }

    @DeleteMapping("/{id}/borrar")
    public void borrarPorId(@PathVariable String id) {
        deporteService.borrarPorId(id);
    }

    @GetMapping("/{id}")
    public Optional<Deporte> obtenerDeporteXId(@PathVariable("id") String id) {
        return deporteService.obtenerDeporteXId(id);
    }

    @GetMapping("/{nombre}")
    public Optional<Deporte> obtenerDeporteXNombre(@PathVariable("nombre") String nombre) {
        return deporteService.obtenerDeporteXNombre(nombre);
    }

    @GetMapping("/todos")
    public List<Deporte> obtenerDeportes() {
        return deporteService.obtenerTodos();
    }



}
