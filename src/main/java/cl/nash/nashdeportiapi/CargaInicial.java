package cl.nash.nashdeportiapi;


import cl.nash.nashdeportiapi.model.*;
import cl.nash.nashdeportiapi.repository.DeporteRepository;
import cl.nash.nashdeportiapi.repository.DeportistaRepository;
import cl.nash.nashdeportiapi.repository.EquipoRepository;
import cl.nash.nashdeportiapi.repository.PreferenciasRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Logger;

@Configuration
public class CargaInicial {

    private final static Logger LOGGER = Logger.getLogger(CargaInicial.class.getName());


    @Bean
    public CommandLineRunner cargarDeportes(DeporteRepository deporteRepository) {
        return (args -> {
            if(!deporteRepository.existsByNombre("Futbol")) {

                Deporte deporte = new Deporte();

                deporte.setDescripcion("El objetivo del baloncesto es marcar más puntos que el equipo contrincante, encestando el balón en el cesto contrario e impidiendo a los jugadores contrincantes encestar en la propia. Una canasta lanzada desde el tiro libre vale 1 punto. Una canasta lanzada desde la zona de tiro de 2 puntos vale 2 puntos.");
                deporte.setNombre("Basketball");
                deporte.setCategoria(Categoria.Pelota.name());
                deporte.setTipo(Tipo.Colectivo.name());
                deporte.setImagen("https://www.latercera.com/resizer/4WJf2fsP7ZAx0GfJnKfcjc_xWug=/900x600/smart/cloudfront-us-east-1.images.arcpublishing.com/copesa/JTHKBOFPUJFC7LTF4ZBF4LYMLQ.jpg");

                Deporte deporte2 = new Deporte();
                deporte2.setNombre("Futbol");
                deporte2.setDescripcion("Deporte que se practica entre dos equipos de once jugadores que tratan de introducir un balón en la portería del contrario impulsándolo con los pies, la cabeza o cualquier parte del cuerpo excepto las manos y los brazos; en cada equipo hay un portero, que puede tocar el balón con las manos, aunque solamente dentro del área; vence el equipo que logra más goles durante los 90 minutos que dura el encuentro.");
                deporte2.setTipo(Tipo.Colectivo.name());
                deporte2.setCategoria(Categoria.Pelota.name());
                deporte2.setImagen("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTF0CxGi6bF4pl9BqXv7mJiD5qXWlCOIp8RfNpRvzAAG1e9_QCpIr7pebUMd4cF2g4Te0Y&usqp=CAU");

                Deporte deporte3 = new Deporte();
                deporte3.setNombre("Voleyball");
                deporte3.setDescripcion("");
                deporte3.setTipo(Tipo.Colectivo.name());
                deporte3.setCategoria(Categoria.Pelota.name());
                deporte3.setImagen("https://www.reuters.com/resizer/yLED8t0vbXdS8D5q1_4URDT2PrY=/1200x0/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/AYGN62PUMJJCXP53ZLYXI6VLDQ.jpg");

                Deporte deporte4 = new Deporte();
                deporte4.setNombre("Trote");
                deporte4.setDescripcion("Ejercicio similar a la carrera a pie. El propósito de esta actividad es mantener la actividad física con menos exigencia para el cuerpo que cuando se corre. La ejecución de este ejercicio por largos períodos de tiempo, es un tipo de entrenamiento aeróbico.");
                deporte4.setTipo(Tipo.Individual.name());
                deporte4.setCategoria(Categoria.Aerobico.name());
                deporte4.setImagen("https://web.asdeporte.com/wp-content/uploads/2020/10/trote-suave-philly-run-1200.jpg");

                Deporte deporte5 = new Deporte();
                deporte5.setNombre("Ciclismo");
                deporte5.setDescripcion("");
                deporte5.setTipo(Tipo.Individual.name());
                deporte5.setCategoria(Categoria.Ruedas.name());
                deporte5.setImagen("https://media.istockphoto.com/photos/mountain-biker-ride-down-from-hill-close-up-wheel-image-active-and-picture-id1057566460?k=20&m=1057566460&s=612x612&w=0&h=Webt3bpJ2MCOKMhkDJZO4lPMb9K953P_tnvwCp_qwmo=");

                Deporte deporte6 = new Deporte();
                deporte6.setNombre("Tenis");
                deporte6.setDescripcion("Deporte de raqueta practicado sobre una pista rectangular, delimitada por líneas y dividida por una red.\u200B Se disputa entre dos jugadores.");
                deporte6.setTipo(Tipo.Individual.name());
                deporte6.setCategoria(Categoria.Pelota.name());
                deporte6.setImagen("https://phantom-marca.unidadeditorial.es/c2dce301874194458a42c716e298527d/resize/1320/f/jpg/assets/multimedia/imagenes/2022/01/11/16419151289194.jpg");

                deporteRepository.save(deporte);
                deporteRepository.save(deporte2);
                deporteRepository.save(deporte3);
                deporteRepository.save(deporte4);
                deporteRepository.save(deporte5);
                deporteRepository.save(deporte6);


            }


        });
    }

    @Bean
    public CommandLineRunner cargaDeportistas(DeportistaRepository deportistaRepository){
        return (args -> {
                if(!deportistaRepository.existsByNombre("Sebastian")){
                    Deportista deportista = new Deportista();
                    deportista.setNombre("Sebastian");
                    deportista.setApellidos("Olave Diaz");
                    deportista.setDescripcion("Quieren jugar...juguemos");
                    deportista.setCorreo("sebaolave@gmail.com");
                    deportista.setGenero(Genero.Masculino.name());
                    deportista.setEstado(false);
                    deportista.setComuna("Temuco");
                    deportista.setFechaNacimiento("01/06/2001");
                    deportista.setEdad(21);
                    deportista.setFoto("https://external-preview.redd.it/vbc0iShrY0lwFxeJ_MHf5tGUwuBcFuwASdawElKu4Rc.jpg?auto=webp&s=ae30a4115eae66459b5c410b539e25c4d18577ba");
                    deportista.setRedSocialPrincipal("instagram.com/instagram");

                    Deportista deportista2 = new Deportista();
                    deportista2.setNombre("Giovanni");
                    deportista2.setApellidos("Cassanelli");
                    deportista2.setDescripcion("Este año me encuentro aprendidendo basketball, invitenme si quieren");
                    deportista2.setCorreo("giovanni@gmail.com");
                    deportista2.setGenero(Genero.Sin_especificar.name());
                    deportista2.setEstado(false);
                    deportista2.setComuna("Temuco");
                    deportista2.setFechaNacimiento("02/06/2001");
                    deportista2.setEdad(21);
                    deportista2.setFoto("https://www.nintenderos.com/wp-content/uploads/2020/07/Pok%C3%A9mon-GO.jpg");
                    deportista2.setRedSocialPrincipal("facebook.com/facebook");

                    Deportista deportista3 = new Deportista();
                    deportista3.setNombre("Luis");
                    deportista3.setApellidos("Martinez");
                    deportista3.setDescripcion("Me gusta jugar futbol los martes en la ufro");
                    deportista3.setCorreo("luismartinez@gmail.com");
                    deportista3.setGenero(Genero.Sin_especificar.name());
                    deportista3.setEstado(false);
                    deportista3.setComuna("Temuco");
                    deportista3.setFechaNacimiento("01/01/1999");
                    deportista3.setEdad(23);
                    deportista3.setFoto("https://img-cdn.hltv.org/gallerypicture/XqaSs07bUGCfbTJ16xYs_b.jpg?ixlib=java-2.1.0&w=1200&s=5874d97e2171598784ad97290ceefab1");
                    deportista3.setRedSocialPrincipal("");

                    Deportista deportista4 = new Deportista();
                    deportista4.setNombre("Fernanda");
                    deportista4.setApellidos("Paredes");
                    deportista4.setDescripcion("Salgo a andar en bicicleta los fines de semana");
                    deportista4.setCorreo("ferparedes@gmail.com");
                    deportista4.setGenero(Genero.Femenino.name());
                    deportista4.setEstado(false);
                    deportista4.setComuna("Temuco");
                    deportista4.setFechaNacimiento("02/02/2002");
                    deportista4.setEdad(20);
                    deportista4.setFoto("https://static.wikia.nocookie.net/reinoanimalia/images/5/54/Leon_del_atlas_2.png/revision/latest?cb=20150308212254&path-prefix=es");
                    deportista4.setRedSocialPrincipal("instagram.com/instagram");

                    Deportista deportista5 = new Deportista();
                    deportista5.setNombre("Pedro");
                    deportista5.setApellidos("Carrasco");
                    deportista5.setDescripcion("Me encanta el futbol y salir a trotar");
                    deportista5.setCorreo("pedrocarrasco@gmail.com");
                    deportista5.setGenero(Genero.No_binario.name());
                    deportista5.setEstado(false);
                    deportista5.setComuna("Temuco");
                    deportista5.setFechaNacimiento("01/01/2001");
                    deportista5.setEdad(21);
                    deportista5.setFoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbXU0vBwMNND_ZOl-tTsPnp3hcVjNfLbYfgF6ieWID5lEbKxw2r7e7XCKyw3wd3RDqGrc&usqp=CAU");
                    deportista5.setRedSocialPrincipal("");

                    Deportista deportista6 = new Deportista();
                    deportista6.setNombre("Francisca");
                    deportista6.setApellidos("Morales");
                    deportista6.setDescripcion("Estoy volviendo a tomar la vida deportiva despues de la pandemia");
                    deportista6.setCorreo("franmorales@gmail.com");
                    deportista6.setGenero(Genero.Femenino.name());
                    deportista6.setEstado(false);
                    deportista6.setComuna("Temuco");
                    deportista6.setFechaNacimiento("04/04/2001");
                    deportista6.setEdad(21);
                    deportista6.setFoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbXU0vBwMNND_ZOl-tTsPnp3hcVjNfLbYfgF6ieWID5lEbKxw2r7e7XCKyw3wd3RDqGrc&usqp=CAU");
                    deportista6.setRedSocialPrincipal("");

                    deportistaRepository.save(deportista);
                    deportistaRepository.save(deportista2);
                    deportistaRepository.save(deportista3);
                    deportistaRepository.save(deportista4);
                    deportistaRepository.save(deportista5);
                    deportistaRepository.save(deportista6);

                }
        });
    }

    @Bean
    public CommandLineRunner cargaPreferencias(PreferenciasRepository preferenciasRepository, DeportistaRepository deportistaRepository,DeporteRepository deporteRepository){
        return (args -> {
            if(deportistaRepository.existsByNombre("Sebastian") && !preferenciasRepository.existsByComuna("Temuco")){
                //obtener los deportes
                Optional<Deporte> futbol = deporteRepository.findByNombre("Futbol");
                Optional<Deporte> basketball = deporteRepository.findByNombre("Basketball");
                Optional<Deporte> voleyball = deporteRepository.findByNombre("Voleyball");
                Optional<Deporte> trote = deporteRepository.findByNombre("Trote");
                Optional<Deporte> ciclismo = deporteRepository.findByNombre("Ciclismo");
                Optional<Deporte> tenis = deporteRepository.findByNombre("Tenis");


                //deportista : Sebastian Olave
                Preferencias preferencias = new Preferencias();
                Deportista deportista = deportistaRepository.findByCorreo("sebaolave@gmail.com");
                preferencias.setGenero(Genero.Sin_especificar.name());
                preferencias.setComuna(deportista.getComuna());
                preferencias.setRangoEtario(RangoEtario.AdultoJoven.name());
                //Deportista
                preferencias.getDeportes().add(futbol.get());
                futbol.get().getDeportistas().add(deportista);

                preferencias.getDeportes().add(basketball.get());
                basketball.get().getDeportistas().add(deportista);

                preferencias.getDeportes().add(trote.get());
                trote.get().getDeportistas().add(deportista);

                deportista.setPreferencias(preferencias);

                //deportista : Giovanni Cassanelli
                Preferencias preferencias2 = new Preferencias();
                Deportista deportista2 = deportistaRepository.findByCorreo("giovanni@gmail.com");
                preferencias2.setGenero(Genero.Masculino.name());
                preferencias2.setComuna(deportista2.getComuna());
                preferencias2.setRangoEtario(RangoEtario.AdultoJoven.name());
                preferencias2.getDeportes().add(futbol.get());
                //Deporte
                futbol.get().getDeportistas().add(deportista2);
                preferencias2.getDeportes().add(basketball.get());
                basketball.get().getDeportistas().add(deportista2);


                deportista2.setPreferencias(preferencias2);

                //deportista : Luis Martinez
                Preferencias preferencias3 = new Preferencias();
                Deportista deportista3 = deportistaRepository.findByCorreo("luismartinez@gmail.com");
                preferencias3.setGenero(Genero.Sin_especificar.name());
                preferencias3.setComuna(deportista3.getComuna());
                preferencias3.setRangoEtario(RangoEtario.AdultoJoven.name());
                preferencias3.getDeportes().add(futbol.get());
                futbol.get().getDeportistas().add(deportista3);

                deportista3.setPreferencias(preferencias3);

                //deportista : Fernanda Paredes
                Preferencias preferencias4 = new Preferencias();
                Deportista deportista4 = deportistaRepository.findByCorreo("ferparedes@gmail.com");
                preferencias4.setGenero(Genero.Femenino.name());
                preferencias4.setComuna(deportista4.getComuna());
                preferencias4.setRangoEtario(RangoEtario.AdultoJoven.name());
                //Deporte
                preferencias4.getDeportes().add(ciclismo.get());
                ciclismo.get().getDeportistas().add(deportista4);

                preferencias4.getDeportes().add(voleyball.get());
                voleyball.get().getDeportistas().add(deportista4);

                deportista4.setPreferencias(preferencias4);

                //deportista : Pedro Carrasco
                Preferencias preferencias5 = new Preferencias();
                Deportista deportista5 = deportistaRepository.findByCorreo("pedrocarrasco@gmail.com");
                preferencias5.setGenero(Genero.No_binario.name());
                preferencias5.setComuna(deportista5.getComuna());
                preferencias5.setRangoEtario(RangoEtario.AdultoJoven.name());

                //Deporte
                preferencias5.getDeportes().add(futbol.get());
                futbol.get().getDeportistas().add(deportista5);
                preferencias5.getDeportes().add(trote.get());
                trote.get().getDeportistas().add(deportista5);


                deportista5.setPreferencias(preferencias5);

                //deportista : Francisca Morales
                Preferencias preferencias6 = new Preferencias();
                Deportista deportista6 = deportistaRepository.findByCorreo("franmorales@gmail.com");
                preferencias6.setGenero(Genero.Femenino.name());
                preferencias6.setComuna(deportista6.getComuna());
                preferencias6.setRangoEtario(RangoEtario.AdultoJoven.name());

                //Deporte

                preferencias6.getDeportes().add(futbol.get());
                futbol.get().getDeportistas().add(deportista6);

                preferencias6.getDeportes().add(basketball.get());
                basketball.get().getDeportistas().add(deportista6);

                preferencias6.getDeportes().add(trote.get());
                trote.get().getDeportistas().add(deportista6);

                preferencias6.getDeportes().add(ciclismo.get());
                ciclismo.get().getDeportistas().add(deportista6);

                preferencias6.getDeportes().add(voleyball.get());
                voleyball.get().getDeportistas().add(deportista6);

                preferencias6.getDeportes().add(tenis.get());
                tenis.get().getDeportistas().add(deportista6);

                deportista6.setPreferencias(preferencias6);

                preferenciasRepository.save(preferencias);
                preferenciasRepository.save(preferencias2);
                preferenciasRepository.save(preferencias3);
                preferenciasRepository.save(preferencias4);
                preferenciasRepository.save(preferencias5);
                preferenciasRepository.save(preferencias6);

                deportistaRepository.save(deportista);
                deportistaRepository.save(deportista2);
                deportistaRepository.save(deportista3);
                deportistaRepository.save(deportista4);
                deportistaRepository.save(deportista5);
                deportistaRepository.save(deportista6);






            }
        });
    }

    @Bean
    public CommandLineRunner cargaEquipo(DeportistaRepository deportistaRepository, EquipoRepository equipoRepository){
        return(args -> {
            if(deportistaRepository.existsByNombre("Sebastian") && !equipoRepository.existsByNombre("Temuco Sports") ){
                //Equipo 1
                Equipo equipo = new Equipo();
                equipo.setNombre("Temuco Sports");
                equipo.setDescripcion("El mejor equipo de Labranza");
                equipo.setRequiereVacantes(false);
                equipo.setVacantes(0);

                Deportista deportista1 = deportistaRepository.findByCorreo("sebaolave@gmail.com");
                deportista1.getEquipos().add(equipo);

                equipo.getDeportistas().put(TipoDeportista.lider.name(), deportista1);
                equipo.getDeportistas().put(TipoDeportista.miembro.name(), deportista1);

                Deportista deportista2 = deportistaRepository.findByCorreo("giovanni@gmail.com");
                Deportista deportista3 = deportistaRepository.findByCorreo("luismartinez@gmail.com");
                Deportista deportista4 = deportistaRepository.findByCorreo("ferparedes@gmail.com");
                Deportista deportista5 = deportistaRepository.findByCorreo("pedrocarrasco@gmail.com");
                Deportista deportista6 = deportistaRepository.findByCorreo("franmorales@gmail.com");

                equipo.getDeportistas().put(TipoDeportista.miembro.name(),deportista3 );
                equipo.getDeportistas().put(TipoDeportista.miembro.name(), deportista2);
                equipo.setImagen("https://pbs.twimg.com/profile_images/1155522219/logo_400x400.jpg");

                //Equipo 2
                Equipo equipo2 = new Equipo();
                equipo2.setNombre("Team UFRO");
                equipo2.setDescripcion("Team UFRO");
                equipo2.setRequiereVacantes(true);
                equipo2.setVacantes(5);
                equipo2.getDeportistas().put(TipoDeportista.lider.name(), deportista4);
                equipo2.getDeportistas().put(TipoDeportista.miembro.name(), deportista4);
                deportista4.getEquipos().add(equipo2);

                equipo2.getDeportistas().put(TipoDeportista.miembro.name(), deportista1);
                deportista1.getEquipos().add(equipo2);

                equipo2.getDeportistas().put(TipoDeportista.miembro.name(), deportista5);
                deportista5.getEquipos().add(equipo2);

                equipo2.getDeportistas().put(TipoDeportista.miembro.name(), deportista6);
                deportista6.getEquipos().add(equipo2);

                equipo2.getDeportistas().put(TipoDeportista.miembro.name(), deportista2);
                deportista2.getEquipos().add(equipo2);

                equipo2.setImagen("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Logo_Nuevo_Ufro.jpg/1200px-Logo_Nuevo_Ufro.jpg");

                equipoRepository.save(equipo);
                equipoRepository.save(equipo2);
                deportistaRepository.save(deportista1);
                deportistaRepository.save(deportista2);
                deportistaRepository.save(deportista3);
                deportistaRepository.save(deportista4);
                deportistaRepository.save(deportista5);
                deportistaRepository.save(deportista6);
            }
        });
    }


}
