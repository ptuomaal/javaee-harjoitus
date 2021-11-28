package fi.ptuomaal.ping.service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Generates test content when the application starts (if the DB is empty).
 */
@Startup
@Singleton
public class UserGenerator {

    @Inject
    UserService service;

    @PostConstruct
    public void init() {
        service.generateContent();
    }
}
