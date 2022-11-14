package cl.nash.nashdeportiapi.service.equipo;

import cl.nash.nashdeportiapi.model.Deportista;
import cl.nash.nashdeportiapi.model.Equipo;
import cl.nash.nashdeportiapi.model.TipoDeportista;
import cl.nash.nashdeportiapi.repository.DeportistaRepository;
import cl.nash.nashdeportiapi.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * CU-011 Permitir Administrar Equipo
 */
@Service
public class AdministracionEquipoService {

    @Autowired
    EquipoRepository equipoRepository;

    @Autowired
    DeportistaRepository deportistaRepository;

    /**
     * Edita el equipo por medio del panel de edicion(frontend). Este puede ser editado solomente por el Lider de equipo
     * @param id
     * @param nombre
     * @param descripcion
     * @param requiereVacantes
     * @param vacantes
     * @return Retorna el resultado de la operación
     */
    public boolean editarEquipo
            (String id, String nombre, String descripcion,
             boolean requiereVacantes, int vacantes) {

        Optional<Equipo> equipoOptional = equipoRepository.findById(id);

        if (equipoOptional.isPresent() && validarEdicionEquipo(nombre, descripcion, requiereVacantes, vacantes)) {
            Equipo equipoActualizado = equipoOptional.get();

            equipoActualizado.setNombre(nombre);
            equipoActualizado.setDescripcion(descripcion);
            equipoActualizado.setRequiereVacantes(requiereVacantes);
            equipoActualizado.setVacantes(vacantes);

            equipoRepository.save(equipoActualizado);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Elimina un miembro del equipo
     * @param idEquipo
     * @param idMiembro
     * @return Retorna el resultado de la operación
     */
    public boolean eliminarMiembro(String idEquipo, String idMiembro){
        Optional<Equipo> equipo = equipoRepository.findById(idEquipo);
        Optional<Deportista> deportista = deportistaRepository.findById(idEquipo);

        if(equipo.isPresent() && deportista.isPresent()){
            //elimina miembro
            equipo.get().getDeportistas().
                    remove(TipoDeportista.miembro.name(),deportista.get());
            //elimina el equipo del deportista
            deportista.get().getEquipos().
                    remove(equipo.get());

            deportistaRepository.save(deportista.get());
            equipoRepository.save(equipo.get());
            return true;
        }else{
            return false;
        }
    }

    /**
     * Acepta un Solicitante como miembro
     * @param idEquipo
     * @param idSolicitante
     * @return Retorna el resultado de la operacion
     */
    public boolean aceptarSolicitante(String idEquipo, String idSolicitante){
        Optional<Equipo> equipo = equipoRepository.findById(idEquipo);
        Optional<Deportista> deportista = deportistaRepository.findById(idSolicitante);

        if(equipo.isPresent() && deportista.isPresent()){
            //aceptar solicitante
            equipo.get().getDeportistas().remove(TipoDeportista.solicitante.name(),deportista.get());
            //validar existencia de miembro, se requiere
            equipo.get().getDeportistas().put(TipoDeportista.miembro.name(), deportista.get());
            equipo.get().setVacantes(equipo.get().getVacantes()+1);

            //agregar equipo a deportista
            deportista.get().getEquipos().add(equipo.get());
            equipoRepository.save(equipo.get());
            deportistaRepository.save(deportista.get());

            return true;
        }else{
            return false;
        }
    }

    /**
     * Valida los parametro recibidos para la edicion de Equipo
     * @param nombre
     * @param descripcion
     * @param requiereVacantes
     * @param vacantes
     * @return Retorna la la validez de los atributos
     */
    public boolean validarEdicionEquipo(String nombre,String descripcion, boolean requiereVacantes, int vacantes) {

        if (nombre.isEmpty() || descripcion.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
