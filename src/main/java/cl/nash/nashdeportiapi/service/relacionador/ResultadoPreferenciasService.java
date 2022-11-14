package cl.nash.nashdeportiapi.service.relacionador;

import cl.nash.nashdeportiapi.model.*;
import cl.nash.nashdeportiapi.repository.DeportistaRepository;
import cl.nash.nashdeportiapi.repository.PreferenciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResultadoPreferenciasService {

    @Autowired
    DeportistaRepository deportistaRepository;

    @Autowired
    PreferenciasRepository preferenciasRepository;

    public List<Deportista> resultadosPreferencia(String idDeportista) {
        Optional<Deportista> deportistaOptional = deportistaRepository.findById(idDeportista);
        List<Deportista> deportistasLista = deportistaRepository.findAll();

        List<Deportista> deportistasCoincidentes = new ArrayList<>();


        if (validarPreferencia(idDeportista)) {
            //Preferencias del deportista

            Preferencias preferencias = deportistaOptional.get().getPreferencias();
            for (Deportista deportista : deportistasLista) {
                if (validarPreferencia(deportista.getId())) {

                    Preferencias preferenciasDeportista = deportista.getPreferencias();
                    boolean repeticion = validarRepeticion(deportistaOptional.get().getId(),deportista.getId());
                    //comuna
                   boolean comuna = compararComuna(preferencias.getComuna(), preferenciasDeportista.getComuna());
                    //rango etario
                    boolean rangoEtario = compararRangoEtario(preferencias.getRangoEtario(), deportista.getEdad());
                    //genero
                    boolean genero = compararGenero(preferencias.getGenero(),deportista.getGenero());
                    //deportes
                    boolean deportes = compararDeportes(preferencias.getDeportes(), preferenciasDeportista.getDeportes());

                    boolean cumplePreferencia = comuna && rangoEtario && genero && deportes && repeticion;

                    if(cumplePreferencia){
                        deportistasCoincidentes.add(deportista);
                    }
                }
            }
        }

        return deportistasCoincidentes;
    }


    public boolean validarPreferencia(String idDeportista) {

        //validar si posee preferencia

        Optional<Deportista> deportista = deportistaRepository.findById(idDeportista);

        if (deportista.isPresent()) {

            if ((deportista.get().getPreferencias()) != null) {
                Optional<Preferencias> preferencias = Optional.of(deportista.get().getPreferencias());
                if (validarDeportes(preferencias.get())) {
                    return true;

                }
            }
        }
        return false;
    }


    public boolean validarDeportes(Preferencias preferencias) {
        return !preferencias.getDeportes().isEmpty();
    }

    public boolean compararComuna(String comuna1, String comuna2) {
        return comuna1.equalsIgnoreCase(comuna2);
    }

    public boolean compararRangoEtario(String rangoEtario, int edad) {
        if (rangoEtario.equalsIgnoreCase(RangoEtario.AdultoJoven.name()) && edad >= 20 && edad <=35 ) {
            return true;
        } else if (rangoEtario.equalsIgnoreCase(RangoEtario.AdultoIntermedio.name()) && edad >=36 && edad <= 59) {
            return true;
        } else if (rangoEtario.equalsIgnoreCase(RangoEtario.AdultoAvanzado.name()) && edad >= 60) {
            return true;
        } else {
            return false;
        }
    }

    public boolean compararGenero(String genero1, String genero2) {
        if (genero1.equalsIgnoreCase( Genero.Sin_especificar.name())) {
            System.out.println("sin especificar");
            return true;
        }
        if (genero1.equalsIgnoreCase(Genero.Masculino.name()) && genero2.equalsIgnoreCase(Genero.Masculino.name())) {
            System.out.println("hombre ");
            return true;
        }

        if (genero2.equalsIgnoreCase(Genero.Femenino.name()) && genero1.equalsIgnoreCase(Genero.Femenino.name())) {
            System.out.println(" mujer");
            return true;
        }

        if (genero1.equalsIgnoreCase(Genero.No_binario.name()) && genero1.equalsIgnoreCase(Genero.No_binario.name())) {
            System.out.println("no binario");
            return true;
        }
        return false;
    }

    public boolean validarRepeticion(String id1, String id2){
        return !id1.equalsIgnoreCase(id2);
    }

    public boolean compararDeportes(List<Deporte> deportes1, List<Deporte> deportes2) {
        for (Deporte deporte1 : deportes1) {
            for (Deporte deporte2 : deportes2) {
                if (deporte2.equals(deporte1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
