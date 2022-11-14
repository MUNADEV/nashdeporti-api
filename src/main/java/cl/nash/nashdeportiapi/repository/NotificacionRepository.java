package cl.nash.nashdeportiapi.repository;

import cl.nash.nashdeportiapi.model.Notificacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("notificacion")
public interface NotificacionRepository extends MongoRepository<Notificacion, String> {
}
