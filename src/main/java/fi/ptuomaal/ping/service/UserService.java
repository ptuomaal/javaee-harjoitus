package fi.ptuomaal.ping.service;

import fi.ptuomaal.ping.entity.User;
import fi.ptuomaal.ping.repository.UserRepository;
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
public class UserService {

    private final static Logger logger = Logger.getLogger(UserService.class.getName());

    @Inject
    UserRepository repository;

    public void generateContent() {
        if ( repository.findAll().isEmpty() ) {
            logger.info("Kanta on tyhjä, luodaan sinne muutama tulos");
            repository.create("Matti", "Makkonen");
            repository.create("Teppo", "Toivanen");
        } else {
            logger.info("Kannassa on jo tavaraa, ei syytä luoda lisää");
        }
    }

    public List<User> listUsers() {
        return repository.findAll();
    }

    public List<User> getUsers(String firstName) {
        return repository.findByFirstName(firstName);
    }
}
