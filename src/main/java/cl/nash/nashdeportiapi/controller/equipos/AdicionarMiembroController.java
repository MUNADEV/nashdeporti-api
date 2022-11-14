package cl.nash.nashdeportiapi.controller.equipos;

import cl.nash.nashdeportiapi.model.Equipo;
import cl.nash.nashdeportiapi.service.equipo.AdicionarMiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * CU-09. Permitir administrar Equipo
 */
@RestController
@CrossOrigin
@RequestMapping("/api/equipo")
public class AdicionarMiembroController {

    @Autowired
    AdicionarMiembroService adicionarMiembroService;

    /**
     * Envia la solicitud de unión de Equipo por parte de un Deportista
     * @param id
     * @param idDeportista
     * @return Retorna el resultado éxito de la opereración
     */
    @PutMapping("{id}/enviar-solicitud/{idDeportista}")
    public boolean enviarSolicitud(@PathVariable("id") String id, @PathVariable("idDeportista") String idDeportista){
        return adicionarMiembroService.enviarSolicitud(id,idDeportista);
    }
}
