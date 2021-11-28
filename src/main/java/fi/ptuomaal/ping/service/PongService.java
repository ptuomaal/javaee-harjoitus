package fi.ptuomaal.ping.service;

import fi.ptuomaal.ping.entity.Pong;
import fi.ptuomaal.ping.repository.PongRepository;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

/**
 * Service-level class PongServices.
 * Provides methods to list Pongs in the database and for testing the application,
 * and a method for generating test content.
 * Uses the PongRepository class to implement the database operations.
 */
@Stateless
public class PongService {

    private final static Logger logger = Logger.getLogger(PongService.class.getName());

    @Inject
    @ConfigProperty(name = "message")
    String message;

    @Inject
    @ConfigProperty(name = "message2")
    String message2;

    @Inject
    PongRepository repository;

    /**
     * Returns pongs with given name. If none are found, returns all pongs.
     */
    public List<Pong> getPongs(String name) {
        List<Pong> byName = repository.findByName(name);
        return byName.isEmpty() ? repository.findAll() : byName;
    }

    public List<Pong> listPongs() {
        return repository.findAll();
    }


    public void generateContent() {
        if ( repository.findAll().isEmpty() ) {
            logger.info("Kanta on tyhjä, luodaan sinne muutama tulos");
            repository.create("Ping");
            repository.create("Pong");
            repository.create("Pang");
        } else {
            logger.info("Kannassa on jo tavaraa, ei syytä luoda lisää");
        }
    }

    public String getResponseForTest() {
        return message + " " + message2;
    }

    public boolean testDbOperations() {
        try {
            Pong tmp = repository.create("Test");
            Pong tmp2 = repository.update(tmp);
            return repository.delete(tmp2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public Pong getPong(Long id) {
        return repository.findById(id);
    }

    public Pong createPong(String name) {
        return repository.create(name);
    }

    public void deleteById(Long id) {
        // TODO: report proper error if pong is not found by ID
        repository.delete(repository.findById(id));
    }
}
