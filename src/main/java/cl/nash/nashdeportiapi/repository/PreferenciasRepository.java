package cl.nash.nashdeportiapi.repository;

import cl.nash.nashdeportiapi.model.Preferencias;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("preferencias")
public interface PreferenciasRepository extends MongoRepository<Preferencias, String> {

    boolean existsByComuna(String comuna);

}
