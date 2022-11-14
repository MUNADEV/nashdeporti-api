package cl.nash.nashdeportiapi.service.relacionador;

import cl.nash.nashdeportiapi.model.EncuentroDeportivo;
import cl.nash.nashdeportiapi.repository.EncuentroDeportivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncuentroDeportivoService {

    @Autowired
    private EncuentroDeportivoRepository encuentroDeportivoRepository;

    public Optional<EncuentroDeportivo> obtenerEncuentroXId(String id) {
        return encuentroDeportivoRepository.findById(id);
    }

    public Optional<EncuentroDeportivo> obtenerEncuentroXTitulo(String titulo) {
        return encuentroDeportivoRepository.findByTitulo(titulo);
    }

//    public Optional<EncuentroDeportivo> obtenerEncuentroXParticipante(String id) {
//        return encuentroDeportivoRepository.findByPartipantes(id);
//    }
    public List<EncuentroDeportivo> obtenerTodos() {
        return encuentroDeportivoRepository.findAll();
    }

    public EncuentroDeportivo registrarEncuentro(EncuentroDeportivo encuentro) {
        return encuentroDeportivoRepository.save(encuentro);
    }

    public void borrarPorId(String id){
        encuentroDeportivoRepository.deleteById(id);
    }

}
