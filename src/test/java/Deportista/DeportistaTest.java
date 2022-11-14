package Deportista;


import cl.nash.nashdeportiapi.NashdeportiApiApplication;
import cl.nash.nashdeportiapi.repository.DeportistaRepository;
import cl.nash.nashdeportiapi.service.deportista.DeportistaService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

public class DeportistaTest  extends NashdeportiApiApplication {

    @InjectMocks
    @Autowired
    DeportistaService deportistaService;

    @Autowired
    DeportistaRepository deportistaRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        // guardarDeportista();
    }

    public void guardarDeportista(){
        String deportista = "[{\n" +
                "\t\"nombre\" : \"Pedro\",\n"
                ;
    }
}
