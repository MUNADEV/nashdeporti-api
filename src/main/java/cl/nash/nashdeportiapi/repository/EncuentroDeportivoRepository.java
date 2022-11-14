package cl.nash.nashdeportiapi.repository;

import cl.nash.nashdeportiapi.model.EncuentroDeportivo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("encuentroDeportivo")
public interface EncuentroDeportivoRepository extends MongoRepository<EncuentroDeportivo, String> {

    Optional<EncuentroDeportivo> findByTitulo(String titulo);



}
