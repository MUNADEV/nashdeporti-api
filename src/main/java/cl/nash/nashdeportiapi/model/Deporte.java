package cl.nash.nashdeportiapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa el Deporte que se realiza en un Enfrentamiento deportivo,se utiliza para clasificar
 * Deportistas y Enfrentamientos y tambien se utiliza para establecer preferencias e intereses de
 * los usuarios Deportistas
 */
@Data
@NoArgsConstructor
@Document
public class Deporte {

    /**
     * Identificador unido de Deporte
     */
    @Id
    private String id;

    /**
     * Nombre del Deporte.
     */
    private String nombre;

    /**
     * Categoría del Deporte
     */
    private String categoria;

    /**
     * Tipo de Deporte
     */
    private String tipo;

    /**
     * Descripción del Deporte
     */
    private String descripcion;

    /**
     * Imagen del deporte
     */
    private String imagen;

    /**
     * Deportistas que practican el Deporte
     */
    @DBRef(lazy = true)
    @JsonIgnore
    private List<Deportista> deportistas = new ArrayList<>();

    /**
     * Encuentros deportivos que practican el Deporte
     */
    @DBRef(lazy = true)
    @JsonIgnore
    private List<EncuentroDeportivo> encuentroDeportivos = new ArrayList<>();


}
