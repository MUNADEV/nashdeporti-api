package cl.nash.nashdeportiapi.controller.deportista;

import cl.nash.nashdeportiapi.service.deportista.EditarPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RestController
@RequestMapping("/api/deportista")
@CrossOrigin
public class EditarPerfilController {

    @Autowired
    EditarPerfilService editarPerfilService;

    @PostMapping("{id}/editar")
    public boolean editarPerfil(@RequestParam String id,
                                @RequestParam String nombre,
                                @RequestParam String apellidos,
                                @RequestParam String descripcion,
                                @RequestParam String  redSocialPrincipal,
                                @RequestParam String genero){

        return editarPerfilService.editarPerfil
                (id,nombre,apellidos,descripcion,redSocialPrincipal,genero);
    }

}
