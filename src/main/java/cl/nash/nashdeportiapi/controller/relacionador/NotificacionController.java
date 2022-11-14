package cl.nash.nashdeportiapi.controller.relacionador;

import cl.nash.nashdeportiapi.model.Notificacion;
import cl.nash.nashdeportiapi.service.relacionador.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/notificacion")
public class NotificacionController {

    @Autowired
    NotificacionService notificacionService;

    @DeleteMapping("{id}/eliminar")
    public void eliminarNotificacion(@PathVariable("id") String id){
        notificacionService.eliminarNotificacion(id);
    }

    @GetMapping("{id}")
    public Optional<Notificacion> obtenerNotificacion(@PathVariable("id") String id){
        return notificacionService.obtenerNotificacion(id);
    }

    @PutMapping("{id}/obtener/{aceptado}")
    public void aceptarInvitacion (@PathVariable("id") String id,@PathVariable("aceptado") boolean aceptado){
        notificacionService.aceptarInvitacion(id,aceptado);
    }
    @PutMapping("/crear-notificacion/{idEncuentro}/{idEmisor}/hacia/{idReceptor}")
    public Notificacion crearNotificacion(@PathVariable("idEncuentro") String idEncuentro,
                                          @PathVariable("idEmisor") String idEmisor,
                                          @PathVariable("idReceptor") String idReceptor){
        return notificacionService.crearNotificacion(idEncuentro,idEmisor,idReceptor);
    }




}
