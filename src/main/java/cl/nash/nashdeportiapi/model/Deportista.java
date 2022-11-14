package cl.nash.nashdeportiapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.ArrayList;
import java.util.List;

/**
 * Usuario de NashDeporti, puede crear y unirse a un Equipo,
 * donde tambien puede realizar enfrentamientos con otros equipo
 */
@Data
@NoArgsConstructor
@Document
public class Deportista {

    /**
     * Identificador unico del deportista.
     */
    @Id
    private String id;

    /**
     * Nombre del usuario.
     */
    private String nombre;

    /**
     * Apellido del usuario
     */
    private String apellidos;

    /**
     * Correo electronico del usuario. Este proviene del servicio de correo de Google
     */
    private String correo;

    private String contrasena;

    /**
     * Genero del Deportista, hombre, mujer y no binario
     */
    private String genero;

    /**
     * Autodescripcion del deportista.
     */
    private String descripcion;

    /**
     * Variable refleja el estado del usuario en el sistema, conectado-desconectado
     */
    private Boolean estado;

    /**
     * Variable refleja el estado de registro del usuario en el sistema
     */
    private Boolean registrado;

    /**
     * Comuna donde reside o donde quiere practicar deporte el usuario.
     */
    private String comuna;

    //Atributos del deportista que afectan el relacionado

    /**
     * Fecha de nacimiento del usuario, se utiliza para calcular la edad.
     */
    private String fechaNacimiento;

    /**
     * Edad del usuario, se obtiene mediante la fecha de nacimiento.
     */
    private int edad;


    /**
     * Imagen a mostrar en el perfil
     */
    private String foto;

    /**
     * Red social utilizada por el Deportista
     */
    private String redSocialPrincipal;

    /**
     * Deportes preferidos por el Deportista
     */
    @DBRef(lazy = true)
    @JsonIgnore
    private List<Deporte> deportesPreferidos = new ArrayList<>();;

    /**
     * Preferencias del Deportista, son el conjutno de caracteristicas que limitan su busqueda
     */
    @DBRef(lazy = true)
    @JsonIgnore
    private Preferencias preferencias;

    /**
     * Equipos donde participa el Deportista
     */
    @DBRef(lazy = true)
    @JsonIgnore
    private List<Equipo> equipos = new ArrayList<>();

    /**
     * Encuentros Deportivos realizados por el deportista
     */
    @DBRef(lazy = true)
    @JsonIgnore//@jsonmanagedreference
    private List<EncuentroDeportivo> encuentrosDeportivos = new ArrayList<>();

    /**
     * Contactos formados por el Deportista
     */
    @DBRef(lazy = true)
    @JsonIgnore
    private List<Deportista> contactos = new ArrayList<>();

    @DBRef(lazy = true)
    @JsonIgnore
    private List<Notificacion> notificaciones = new ArrayList<>();


}
