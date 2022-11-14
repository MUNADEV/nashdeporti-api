package cl.nash.nashdeportiapi.controller.deportista;


import cl.nash.nashdeportiapi.model.Preferencias;
import cl.nash.nashdeportiapi.service.deportista.PreferenciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/preferencias")
public class PreferenciasController {
    @Autowired
    private PreferenciasService preferenciasService;

    @PostMapping
    public Preferencias registrar(@RequestBody Preferencias preferencias) {
        return preferenciasService.registrarPreferencias(preferencias);
    }

    @PutMapping("/{id}/actualizar")
    public Preferencias actualizar(@RequestBody Preferencias preferencias) {
        return preferenciasService.registrarPreferencias(preferencias);
    }

    @DeleteMapping("/{id}/borrar")
    public void borrarPorId(@PathVariable String id) {
        preferenciasService.borrarPorId(id);
    }

    @GetMapping("/{id}")
    public Optional<Preferencias> obtenerPreferenciaXId(@PathVariable("id") String id) {
        return preferenciasService.obtenerPreferenciasXId(id);
    }

    @GetMapping("/todos")
    public List<Preferencias> obtenerPreferencias() {
        return preferenciasService.obtenerTodos();
    }

    @PutMapping("/{idPreferencias}/agregar-deporte/{idDeporte}")
    public boolean actualizar(@PathVariable("idPreferencias") String idPreferenicas, @PathVariable("idDeporte") String idDeporte) {
        return preferenciasService.agregarDeporte(idPreferenicas,idDeporte);
    }

    @PostMapping("/{id}/editar")
    public boolean editarPreferencias(@RequestParam String id,
                                @RequestParam String genero,
                                @RequestParam int edadMinima,
                                @RequestParam int edadMaxima,
                                @RequestParam String comuna){

        return preferenciasService.editarPreferencias(id,genero,edadMinima,edadMaxima,comuna);
    }

}
