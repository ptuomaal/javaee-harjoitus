package fi.ptuomaal.ping.service;

import fi.ptuomaal.ping.entity.Product;
import fi.ptuomaal.ping.repository.ProductRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

/*
    ProductService keskittää Product entiteetteihin liittyvät operaatiot, eli ns. businesslogiikan.
*/
@Stateless
public class ProductService {

    private final static Logger logger = Logger.getLogger(ProductService.class.getName());

    @Inject
    ProductRepository repository;

    public List<Product> getProducts() {
        List<Product> results = repository.findAll();
        return results;
    }

    public void generateContent() {
        if ( repository.findAll().isEmpty() ) {
            logger.info("Kanta on tyhjä, luodaan sinne muutama tulos");
            repository.create("1234", "tools");
            repository.create("4321", "tools");
            repository.create("0001", "material");
        } else {
            logger.info("Kannassa on jo tavaraa, ei syytä luoda lisää");
        }
    }

    public List<Product> getProductsByCategory(String category) {
        List<Product> results = repository.findByCategory(category);
        return results;
    }
}
