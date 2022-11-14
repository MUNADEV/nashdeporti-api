package cl.nash.nashdeportiapi.repository;

import cl.nash.nashdeportiapi.model.Deportista;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("deportista")
public interface DeportistaRepository extends MongoRepository<Deportista, String> {


    Deportista findByCorreo(String id);

    List<Deportista> findByNombre(String name);

    boolean existsByNombre(String nombre);

    boolean existsByCorreo(String correo);

}
