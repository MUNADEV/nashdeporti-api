package cl.nash.nashdeportiapi.repository;

import cl.nash.nashdeportiapi.model.Equipo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("equipo")
public interface EquipoRepository extends MongoRepository<Equipo, String> {

    List<Equipo> findByNombre(String nombre);

    boolean existsByNombre(String nombre);

}
