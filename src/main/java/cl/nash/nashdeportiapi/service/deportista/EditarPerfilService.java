package cl.nash.nashdeportiapi.service.deportista;

import cl.nash.nashdeportiapi.model.Deporte;
import cl.nash.nashdeportiapi.model.Deportista;
import cl.nash.nashdeportiapi.model.Preferencias;
import cl.nash.nashdeportiapi.repository.DeportistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EditarPerfilService {

    @Autowired
    private DeportistaRepository deportistaRepository;

    /**
     * Edita el perfil de un Deportista
     *
     * @param id
     * @param nombre
     * @param apellidos
     * @param descripcion
     * @param redSocialPrincipal
     * @param genero
     * @return
     */
    public boolean editarPerfil(String id,
                                String nombre,
                                String apellidos,
                                String descripcion,
                                String redSocialPrincipal,
                                String genero) {
        //no contempla deportes ni fotografia
        Optional<Deportista> deportistaOptional = deportistaRepository.findById(id);

        if (deportistaOptional.isPresent() && validarEdicionPerfil(nombre, apellidos, descripcion, redSocialPrincipal, genero)) {
            Deportista deportistaActualizar = deportistaOptional.get();
            deportistaActualizar.setNombre(nombre);
            deportistaActualizar.setApellidos(apellidos);
            deportistaActualizar.setDescripcion(descripcion);
            deportistaActualizar.setRedSocialPrincipal(redSocialPrincipal);
            deportistaActualizar.setGenero(genero);

            deportistaRepository.save(deportistaActualizar);
            return true;
        } else {
            return false;
        }

    }


    /**
     * Validar atributos de edición
     *
     * @return false si los atributos son validos
     */
    public boolean validarEdicionPerfil(String nombre,
                                        String apellidos,
                                        String descripcion,
                                        String redSocialPrincipal,
                                        String genero) {
        if (nombre.isEmpty() || apellidos.isEmpty() || descripcion.isEmpty() || redSocialPrincipal.isEmpty() || genero.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }


}
