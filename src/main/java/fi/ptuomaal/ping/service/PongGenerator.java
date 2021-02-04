package fi.ptuomaal.ping.service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
public class PongGenerator {

    @Inject
    PongService service;

    @PostConstruct
    public void init() {
        service.generateContent();
    }
}
