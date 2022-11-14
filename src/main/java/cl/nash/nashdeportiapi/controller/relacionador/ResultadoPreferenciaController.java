package cl.nash.nashdeportiapi.controller.relacionador;


import cl.nash.nashdeportiapi.model.Deportista;
import cl.nash.nashdeportiapi.service.relacionador.ResultadoPreferenciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/relacionador")
public class ResultadoPreferenciaController {

    @Autowired
    ResultadoPreferenciasService resultadosPreferenciaService;

    @GetMapping("/{idDeportista}")
    public List<Deportista> resultadoPreferencia(@PathVariable("idDeportista") String idDeportista){
        return resultadosPreferenciaService.resultadosPreferencia(idDeportista);
    }
}
