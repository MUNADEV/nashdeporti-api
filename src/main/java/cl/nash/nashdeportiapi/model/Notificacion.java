package cl.nash.nashdeportiapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Notificacion {

    @Id
    private String id;

    private String mensaje;

    private boolean estado;

    @DBRef(lazy = true)
    @JsonIgnore
    private Deportista deportistaEmisor;

    @DBRef(lazy = true)
    @JsonIgnore
    private Deportista deportistaReceptor;

    @DBRef(lazy = true)
    @JsonIgnore
    private Equipo equipoEmisor;

    @DBRef(lazy = true)
    @JsonIgnore
    private Equipo equipoReceptor;

    @DBRef(lazy = true)
    @JsonIgnore
    private EncuentroDeportivo encuentroDeportivo;

}
