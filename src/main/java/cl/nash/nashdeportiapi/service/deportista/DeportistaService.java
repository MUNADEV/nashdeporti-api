package cl.nash.nashdeportiapi.service.deportista;

import cl.nash.nashdeportiapi.model.Deportista;
import cl.nash.nashdeportiapi.model.Notificacion;
import cl.nash.nashdeportiapi.repository.DeportistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeportistaService {

    @Autowired
    private DeportistaRepository deportistaRepository;

    public Deportista registrarDeportista(Deportista deportista) {
        return deportistaRepository.save(deportista);
    }

    public Optional<Deportista> obtenerDeportistaXId(String id) {
        return deportistaRepository.findById(id);
    }

    public List<Notificacion> obtenerNotificacionesXDeportista(@PathVariable("id") String id){
        List<Notificacion> notificaciones = new ArrayList<>();

        Optional<Deportista> deportista = deportistaRepository.findById(id);

        if(deportista.isPresent()){
            notificaciones = deportista.get().getNotificaciones();
        }

        return notificaciones;
    }

    public List<Deportista> obtenerContactosXDeportista(@PathVariable("id") String id){
        List<Deportista> contactos = new ArrayList<>();

        Optional<Deportista> deportista = deportistaRepository.findById(id);

        if(deportista.isPresent()){
            contactos = deportista.get().getContactos();
        }

        return contactos;
    }
    public Deportista obtenerDeportistaXCorreo(String correo) {
        return deportistaRepository.findByCorreo(correo);
    }

    public List<Deportista> obtenerTodos() {
        return deportistaRepository.findAll();
    }

    public void borrarPorId(String id){
        deportistaRepository.deleteById(id);
    }


}
