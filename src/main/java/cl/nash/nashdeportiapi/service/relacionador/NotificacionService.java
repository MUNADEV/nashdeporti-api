package cl.nash.nashdeportiapi.service.relacionador;

import cl.nash.nashdeportiapi.model.Deportista;
import cl.nash.nashdeportiapi.model.EncuentroDeportivo;
import cl.nash.nashdeportiapi.model.Equipo;
import cl.nash.nashdeportiapi.model.Notificacion;
import cl.nash.nashdeportiapi.repository.DeportistaRepository;
import cl.nash.nashdeportiapi.repository.EncuentroDeportivoRepository;
import cl.nash.nashdeportiapi.repository.EquipoRepository;
import cl.nash.nashdeportiapi.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotificacionService {

    @Autowired
    NotificacionRepository notificacionRepository;

    private final String enunciado = "Ha recibido un invitacion";

    @Autowired
    EncuentroDeportivoRepository encuentroRepository;

    @Autowired
    DeportistaRepository deportistaRepository;

    @Autowired
    EquipoRepository equipoRepository;

    public void eliminarNotificacion(String id){
        notificacionRepository.deleteById(id);

    }

    public Optional<Notificacion> obtenerNotificacion(String id){
        return notificacionRepository.findById(id);

    }

    public void aceptarInvitacion(String id, boolean aceptado){

        Optional<Notificacion> notificacion = notificacionRepository.findById(id);

        if(notificacion.isPresent()){
            Deportista emisor = notificacion.get().getDeportistaEmisor();
            Deportista receptor = notificacion.get().getDeportistaReceptor();
            if(aceptado){
                emisor.getContactos().add(emisor);
                emisor.getNotificaciones().remove(notificacion.get());
                receptor.getContactos().add(receptor);
                receptor.getNotificaciones().remove(notificacion.get());
            }else{
                receptor.getContactos().add(receptor);
                receptor.getNotificaciones().remove(notificacion.get());
            }
        }
    }

    public Notificacion crearNotificacion(String idEncuentro, String idEmisor,String idReceptor){
        Optional<EncuentroDeportivo> encuentro = encuentroRepository.findById(idEncuentro);
        Notificacion notificacion = new Notificacion();
        if(encuentro.isPresent()){

            notificacion.setMensaje(enunciado);
            notificacion.setEncuentroDeportivo(encuentro.get());
            notificacion.setEstado(false);

            if(deportistaRepository.existsById(idEmisor)){
                Optional<Deportista> deportistaEmisor = deportistaRepository.findById(idEmisor);
                Optional<Deportista> deportistaReceptor = deportistaRepository.findById(idReceptor);
                if(deportistaEmisor.isPresent() && deportistaReceptor.isPresent()){
                    notificacion.setDeportistaEmisor(deportistaEmisor.get());
                    notificacion.setDeportistaReceptor(deportistaReceptor.get());
                    deportistaReceptor.get().getNotificaciones().add(notificacion);
                    deportistaEmisor.get().getNotificaciones().add(notificacion);

                    deportistaEmisor.get().getEncuentrosDeportivos().add(encuentro.get());
                    deportistaReceptor.get().getEncuentrosDeportivos().add(encuentro.get());
                }
            }else{
                Optional<Equipo> equipoEmisor = equipoRepository.findById(idEmisor);
                Optional<Equipo> equipoReceptor = equipoRepository.findById(idReceptor);
                if(equipoEmisor.isPresent() && equipoReceptor.isPresent()){
                    notificacion.setEquipoEmisor(equipoEmisor.get());
                    notificacion.setEquipoReceptor(equipoReceptor.get());
                }
            }
        }

        return notificacion;
    }
}
