package cl.nash.nashdeportiapi.service.equipo;

import cl.nash.nashdeportiapi.model.Deportista;
import cl.nash.nashdeportiapi.model.Equipo;
import cl.nash.nashdeportiapi.model.TipoDeportista;
import cl.nash.nashdeportiapi.repository.DeportistaRepository;
import cl.nash.nashdeportiapi.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * CU-09. Permitir unirse a equipo
 */
@Service
public class AdicionarMiembroService {

    @Autowired
    DeportistaRepository deportistaRepository;

    @Autowired
    EquipoRepository equipoRepository;

    /**
     * Envia solicitud de union al equipo
     * @param idEquipo
     * @param idDeportista
     * @return True si la operacion es valida de lo contrario es False
     */
    public boolean enviarSolicitud(String idEquipo, String idDeportista){
        Optional<Deportista> deportista = deportistaRepository.findById(idDeportista);
        Optional<Equipo> equipo = equipoRepository.findById(idEquipo);

        if(deportista.isPresent() && equipo.isPresent() && equipo.get().getVacantes() > 0 && equipo.get().isRequiereVacantes()){
            //enviar solicitud
            equipo.get().getDeportistas().put(TipoDeportista.solicitante.name(), deportista.get());
            int vacantes = equipo.get().getVacantes();
            equipo.get().setVacantes(vacantes-1);

            equipoRepository.save(equipo.get());

            return true;
        }else{
            return false;
        }
    }
}
