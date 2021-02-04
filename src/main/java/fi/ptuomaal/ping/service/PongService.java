package fi.ptuomaal.ping.service;

import fi.ptuomaal.ping.entity.Pong;
import fi.ptuomaal.ping.repository.PongRepository;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class PongService {

    private final static Logger logger = Logger.getLogger(PongService.class.getName());

    @Inject
    @ConfigProperty(name = "message")
    String message;

    @Inject
    PongRepository repository;

    public List<Pong> getPongs(String name) {
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
        return message;
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
}
