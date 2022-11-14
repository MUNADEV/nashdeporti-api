package cl.nash.nashdeportiapi.service.busqueda;

import cl.nash.nashdeportiapi.model.Deportista;
import cl.nash.nashdeportiapi.model.Equipo;
import cl.nash.nashdeportiapi.repository.DeportistaRepository;
import cl.nash.nashdeportiapi.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * CU-05: Permitir busqueda de equipo y deportistas.
 */
@Service
public class BusquedaService {

    @Autowired
    DeportistaRepository deportistaRepository;

    @Autowired
    EquipoRepository equipoRepository;

    /**
     * Busqueda de deportista por nombre y tambien con nombre y apellido
     *
     * @param nombre nombre del deportista
     * @return Lista de deportistas coincidentes
     */
    public List<Object> obtenerDeportistasXNombre(String nombre) {
        String nombreAux = "";
        String apellidosAux = "";

        List<Deportista> deportistas;
        List<Deportista> deportistasXNombre;
        List<Deportista> deportistasXApellidos;

        if (nombreValido(nombre)) {
            return Collections.emptyList();
        } else {
            if (existeEspacio(nombre)) {
                String[] parts = nombre.split(" ");
                nombreAux = parts[0];

                //Ciclo utilizado para dividir el nombre en nombre y apellido
                for (int i = 1; i < parts.length; i++) {
                    apellidosAux = " " + parts[i];
                }
                //se realiza consulta de forma individual
                deportistasXNombre = (deportistaRepository.findByNombre(nombreAux));
                deportistasXApellidos = (deportistaRepository.findByNombre(apellidosAux));
                //se concatena los resultados de busqueda individual
                deportistas = Stream.concat(deportistasXNombre.stream(),deportistasXApellidos.stream()).collect(Collectors.toList());
            } else {
                 deportistas = deportistaRepository.findByNombre(nombre);
            }


            if (deportistas.isEmpty()) {
                return Collections.emptyList();
            } else {
                return Collections.singletonList(deportistas);
            }
        }
    }

    /**
     * Busqueda de equipo por nombre
     *
     * @param nombre Nombre del equipo
     * @return Lista de equipos coincidentes
     */
    public List<Object> obtenerEquiposXNombre(String nombre) {


        if (nombreValido(nombre)) {
            return Collections.emptyList();
        } else {

            List<Equipo> equipo = equipoRepository.findByNombre(nombre);

            if (equipo.isEmpty()) {
                return Collections.emptyList();
            } else {
                return Collections.singletonList(equipo);
            }
        }
    }

    /**
     * Valida que el nombre no esté vacio
     *
     * @param nombre Cadena a evaluar
     * @return Verdadero si el nombre es valido, Falso si el nombre no es valido.
     */
    public boolean nombreValido(String nombre) {
        return (nombre.isEmpty() || nombre.isBlank());
    }

    /**
     * Valida si existe un espacio en el nombre
     *
     * @param nombre Cadena a evaluar
     * @return Verdadero si existe espacio y Falso y no existe espacio
     */
    public boolean existeEspacio(String nombre) {
        return nombre.contains(" ");
    }


}
