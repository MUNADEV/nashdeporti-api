package cl.nash.nashdeportiapi.controller.deportista;

import cl.nash.nashdeportiapi.model.Deportista;
import cl.nash.nashdeportiapi.model.Notificacion;
import cl.nash.nashdeportiapi.service.deportista.DeportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/deportista")
public class DeportistaController {

    @Autowired
    private DeportistaService deportistaService;

    @PutMapping("/{id}/actualizar")
    public Deportista actualizar(@RequestBody Deportista deportista) {

        return deportistaService.registrarDeportista(deportista);
    }

    @DeleteMapping("/{id}/borrar")
    public void borrarPorId(@PathVariable String id) {
        deportistaService.borrarPorId(id);
    }

    @GetMapping("/{id}")
    public Optional<Deportista> obtenerDeportistaXId(@PathVariable("id") String id) {
        return deportistaService.obtenerDeportistaXId(id);
    }

    @GetMapping("/{id}/notificaciones")
    public List<Notificacion> obtenerNotificacionesXDeportista(@PathVariable("id") String id){
        return deportistaService.obtenerNotificacionesXDeportista(id);
    }

    @GetMapping("/{id}/contactos")
    public List<Deportista> obtenerContactosXDeportista(@PathVariable("id") String id){
        return deportistaService.obtenerContactosXDeportista(id);
    }

    @GetMapping("/todos")
    public List<Deportista> obtenerDeportistas() {
        return deportistaService.obtenerTodos();
    }


}
