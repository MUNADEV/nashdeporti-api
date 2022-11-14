package cl.nash.nashdeportiapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Union de Deportistas con intereses comunes, pueden realizar Enfrentamientos y es administrado
 * por un lider de equipo
 */
@Data
@Document
public class Equipo{

    /**
     * Identificador unido de Equipo.
     */
    @Id
    private String id;

    /**
     * Nombre del Equipo.
     */
    private String nombre;

    /**
     * Descripcion del Equipo
     */
    private String descripcion;

    /**
     * Estado que indica la disponibilidad de requerir miebros
     */
    private boolean requiereVacantes;

    /**
     * Numero de vacantes disponibles
     */
    private int vacantes;

    /**
     * Imagen del equipo, corresponde una url de referencia
     */
    private String imagen;

    /**
     * Deportistas divididos en: miembros y solicitantes
     */
    @DBRef(lazy = true)
    @JsonIgnore
    private HashMap<String, Deportista> deportistas = new HashMap<>();

    /**
     * Encuentros deportivos realizados por el equipo
     */
    @DBRef(lazy = true)
    @JsonIgnore
    private List<EncuentroDeportivo> encuentroDeportivos = new ArrayList<>();


}
