package cl.nash.nashdeportiapi.controller.relacionador;

import cl.nash.nashdeportiapi.model.EncuentroDeportivo;

import cl.nash.nashdeportiapi.service.relacionador.EncuentroDeportivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/encuentro")
public class EncuentroDeportivoController {

    @Autowired
    private EncuentroDeportivoService encuentroDeportivoService;

    @GetMapping("/buscar/{id}")
    public Optional<EncuentroDeportivo> buscarPorId(@PathVariable String id) {
        return encuentroDeportivoService.obtenerEncuentroXId(id);
    }

//    @GetMapping("/buscar/{id}")
//    public Optional<EncuentroDeportivo> buscarPorParticipante(@PathVariable String id) {
//        return encuentroDeportivoService.obtenerEncuentroXParticipante(id);
//    }

    @PostMapping
    public EncuentroDeportivo registrar(@RequestBody EncuentroDeportivo encuentroDeportivo) {
        return encuentroDeportivoService.registrarEncuentro(encuentroDeportivo);
    }

    @PutMapping("/{id}/actualizar")
    public EncuentroDeportivo actualizar(@RequestBody EncuentroDeportivo encuentroDeportivo) {
        return encuentroDeportivoService.registrarEncuentro(encuentroDeportivo);
    }

    @DeleteMapping("/{id}/borrar")
    public void borrarPorId(@PathVariable String id) {
        encuentroDeportivoService.borrarPorId(id);
    }

    @GetMapping("/{id}")
    public Optional<EncuentroDeportivo> obtenerEncuentroXId(@PathVariable("id") String id) {
        return encuentroDeportivoService.obtenerEncuentroXId(id);
    }

    @GetMapping("/{nombre}")
    public Optional<EncuentroDeportivo> obtenerEncuentroXTitulo(@PathVariable("nombre") String nombre) {
        return encuentroDeportivoService.obtenerEncuentroXTitulo(nombre);
    }

    @GetMapping("/todos")
    public List<EncuentroDeportivo> obtenerEncuentrosDeportivos() {
        return encuentroDeportivoService.obtenerTodos();
    }

}
