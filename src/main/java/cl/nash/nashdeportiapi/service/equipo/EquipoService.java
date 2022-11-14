package cl.nash.nashdeportiapi.service.equipo;


import cl.nash.nashdeportiapi.model.Deportista;
import cl.nash.nashdeportiapi.model.Equipo;
import cl.nash.nashdeportiapi.model.TipoDeportista;
import cl.nash.nashdeportiapi.repository.DeportistaRepository;
import cl.nash.nashdeportiapi.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private DeportistaRepository deportistaRepository;

    public Equipo guardarEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public Optional<Equipo> obtenerEquipoXId(String id) {
        return equipoRepository.findById(id);
    }

    public List<Equipo> obtenerTodos() {
        return equipoRepository.findAll();
    }

    public void borrarPorId(String id){
        equipoRepository.deleteById(id);
    }

    public boolean crearEquipo(String idDeportista, String nombre, String descripcion){

        Optional<Deportista> deportistaOptional = deportistaRepository.findById(idDeportista);

        if(deportistaOptional.isPresent() && validarCreacionEquipo(nombre,descripcion)){

            Equipo equipo = new Equipo();
            equipo.setNombre(nombre);
            equipo.setDescripcion(descripcion);
            equipo.setRequiereVacantes(false);//se inicializa en false
            equipo.setVacantes(0);//se inicializa en false

            //asignar lider
            equipo.getDeportistas().put(TipoDeportista.lider.name(),deportistaOptional.get());
            //asignar miembro
            equipo.getDeportistas().put(TipoDeportista.miembro.name(),deportistaOptional.get());

            //asignar equipo a lider-miembro

            deportistaRepository.save(deportistaOptional.get());
            equipoRepository.save(equipo);
            return true;
        }
        return true;
    }

    public boolean validarCreacionEquipo(String nombre, String descripcion){
        boolean validacion;
        validacion = (nombre.isEmpty() || descripcion.isEmpty()); //Debe retornar falso si la validacion es correcta
        return !validacion;
    }

}
