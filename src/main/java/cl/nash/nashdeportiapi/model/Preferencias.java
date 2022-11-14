package cl.nash.nashdeportiapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Corresponde a las preferencias  y caracteristicas que un Deportista busca en otro Deportista
 */
@Data
@NoArgsConstructor
@Document
public class Preferencias {

    /**
     * ID de Preferenicas
     */
    @Id
    private String id;

    /**
     * Genero del Deportista
     */
    private String genero;

    /**
     * Edad minima buscada de Deportista
     */
    private String rangoEtario;

    /**
     * Comuna donde reside el Deportista
     */
    private String comuna;

    /**
     * Deportes practicados por el Deportista
     */
    @DBRef(lazy = true)
    @JsonIgnore
    private List<Deporte> deportes = new ArrayList<>();
}
