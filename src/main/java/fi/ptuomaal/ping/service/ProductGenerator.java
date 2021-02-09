package fi.ptuomaal.ping.service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Startup
@Singleton
/*
    ProductGenerator luo sisältöä 
*/
public class ProductGenerator {

    @Inject
    ProductService service;

    @PostConstruct
    public void init() {
        service.generateContent();
    }
}
