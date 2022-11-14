package cl.nash.nashdeportiapi.controller.equipos;

import cl.nash.nashdeportiapi.model.Equipo;
import cl.nash.nashdeportiapi.service.equipo.AdministracionEquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Casos de Uso relacionados con la administracion del Equipo.
 */
@RestController
@CrossOrigin
@RequestMapping("/api/equipo")
public class AdministrarEquipoController {

    @Autowired
    AdministracionEquipoService administracionEquipoService;

    /**
     * Metodo utilizado para editar el Equipo
     * @param id
     * @param nombre
     * @param descripcion
     * @param requiereVacantes
     * @param vacantes
     * @return Retorna el resultado de éxito de la operacion
     */
    @PostMapping("{id}/editar-equipo")
    public boolean editarEquipo(@RequestParam String id,
                                @RequestParam String nombre,
                                @RequestParam String descripcion,
                                @RequestParam boolean requiereVacantes,
                                @RequestParam int vacantes){

        return administracionEquipoService.editarEquipo(id,nombre,descripcion,requiereVacantes,vacantes);
    }

    /**
     * Elimina el miembro de un Equipo
     * @param id
     * @param idMiembro
     * @return Retorna el resultado de éxito de la operacion
     */
    @DeleteMapping("{id}/eliminar-miembro/{idMiembro}")
    public boolean eliminarMiembro(@PathVariable("id")String id, @PathVariable("idMiembro") String idMiembro){
        return eliminarMiembro(id,idMiembro);
    }

    /**
     * Acepta un solicitante como miembro de un Equipo
     * @param id
     * @param idSolicitante
     * @return Retorna el resultado de éxito de la operacion
     */
    @PutMapping("{id}/aceptar-miembro/{idSolicitante}")
    public boolean aceptarSolicitante(@PathVariable("id") String id, @PathVariable("idSolicitante") String idSolicitante){
        return aceptarSolicitante(id,idSolicitante);
    }


}
