package cl.nash.nashdeportiapi.repository;

import cl.nash.nashdeportiapi.model.Deporte;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("deporte")
public interface DeporteRepository extends MongoRepository<Deporte, String> {

    Optional<Deporte> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
