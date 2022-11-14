package cl.nash.nashdeportiapi.service.deportista;

import cl.nash.nashdeportiapi.model.Deporte;
import cl.nash.nashdeportiapi.model.Preferencias;
import cl.nash.nashdeportiapi.repository.DeporteRepository;
import cl.nash.nashdeportiapi.repository.PreferenciasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreferenciasService {

    @Autowired
    private PreferenciasRepository preferenciasRepository;
    @Autowired
    private DeporteRepository deporteRepository;

    public Preferencias registrarPreferencias(Preferencias preferencias) {
        return preferenciasRepository.save(preferencias);
    }

    public Optional<Preferencias> obtenerPreferenciasXId(String id) {
        return preferenciasRepository.findById(id);
    }

    public List<Preferencias> obtenerTodos() {
        return preferenciasRepository.findAll();
    }

    public void borrarPorId(String id) {
        preferenciasRepository.deleteById(id);
    }


    public boolean editarPreferencias(String id,
                                      String genero,
                                      int edadMinima,
                                      int edadMaxima,
                                      String comuna) {

        Optional<Preferencias> preferenciasOptional = preferenciasRepository.findById(id);

        if (preferenciasOptional.isPresent() && validarEdicionPreferencia(genero,edadMinima,edadMaxima,comuna)){
            Preferencias preferenciasActualizar = preferenciasOptional.get();
            preferenciasActualizar.setGenero(genero);
            preferenciasActualizar.setComuna(comuna);

            preferenciasRepository.save(preferenciasActualizar);
            return true;
        }else{
            return false;
        }
    }

    public boolean agregarDeporte(String idPreferencia, String idDeporte){
        Optional<Preferencias> preferencias = preferenciasRepository.findById(idPreferencia);
        Optional<Deporte> deporte = deporteRepository.findById(idDeporte);

        if(preferencias.isPresent() && deporte.isPresent()){
            preferencias.get().getDeportes().add(deporte.get());
            preferenciasRepository.save(preferencias.get());
            return true;
        }else{
            return false;
        }
    }

    public boolean validarEdicionPreferencia(String genero, int edadMinima, int edadMaxima, String comuna) {
        //enero!= Genero.No_binario.name() || genero!= Genero.Sin_especificar.name() || genero != Genero.Femenino.name() || genero!= Genero.Masculino.name()
        //Requiere refactorizacion
        // validar comuna
        if (edadMaxima < edadMinima || edadMaxima == 0 || edadMaxima < 16 || edadMaxima > 120 || edadMinima < 16) {
            return false;
        }else{
            return true;
        }

    }
}
