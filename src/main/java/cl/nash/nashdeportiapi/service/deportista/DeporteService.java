package cl.nash.nashdeportiapi.service.deportista;

import cl.nash.nashdeportiapi.model.Deporte;
import cl.nash.nashdeportiapi.repository.DeporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeporteService {

    @Autowired
    private DeporteRepository deporteRepository;

    public Optional<Deporte> obtenerDeporteXId(String id) {
        return deporteRepository.findById(id);
    }

    public Optional<Deporte> obtenerDeporteXNombre(String nombre) {
        return deporteRepository.findByNombre(nombre);
    }

    public List<Deporte> obtenerTodos() {
        return deporteRepository.findAll();
    }

    public Deporte registrarDeporte(Deporte deporte) {
        return deporteRepository.save(deporte);
    }

    public void borrarPorId(String id){
        deporteRepository.deleteById(id);
    }
}
