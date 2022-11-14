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
 * Enfrentamiento entre dos entididades, estas pueden ser de tipo colectivo,
 * entre equipos, o individuales, entre Deportistas, esto depende del deporte
 */
@Data
@NoArgsConstructor
@Document
public class EncuentroDeportivo {

    /**
     * Identificador de Encuentro deportivo
     */
    @Id
    private String id;

    /**
     * Titulo del Encuentro
     */
    private String titulo;

    /**
     * Descripcion del Encuentro, relata el contexto del enfrentamiento
     */
    private String descripcion;

    /**
     * Tipo de encuentro, puede ser colectivo o individual
     */
    private String tipo;

    /**
     * Fecha cuando se realiza el encuentro
     */
    private String fechaEncuentro;

    /**
     * Direccion donde se realiza el encuentro
     */
    private String direccion;

    /**
     * Resultado que hubo en el encuentro, requiere de una modificacion
     */
    private String resultado;

    /**
     * Equipo que se enfrenta
     */
    private String equipo1;

    /**
     * Equipo que se enfrenta
     */
    private String equipo2;

    /**
     * Deportista que se enfrenta
     */
    private String deportista1;

    /**
     * Deportista que se enfrenta
     */
    private String deportista2;

    /**
     * Estado del encuentro deportivo, este puede ser pendiente, aceptado o rechazado
     */
    private String estado;

    /**
     * Deporte que se realiza en el enfrentamiento
     */
    @DBRef(lazy = true)
    @JsonIgnore
    private Deporte deporte;

    /**
     * Participantes que se participan en el enfrentamiento
     */
    @DBRef(lazy = true)
    @JsonIgnore
    private List<Deportista> participantes = new ArrayList<>();

    /**
     * Equipos se participan en el enfrentamiento
     */
    @DBRef(lazy = true)
    @JsonIgnore
    private List<Equipo> equipos = new ArrayList<>();


}
