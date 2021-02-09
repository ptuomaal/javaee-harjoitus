package fi.ptuomaal.ping.repository;

import fi.ptuomaal.ping.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

/*
    ProductRepository erottaa bisnesslogiikan tietokantakyselyistä 
    tarjoamalla helposti ymmärrettäviä metodeja Product entiteettien käsittelyyn.
*/
public class ProductRepository {

    @PersistenceContext(unitName="product")
    EntityManager entityManager;

    public List<Product> findAll() {
        List<Product> results = entityManager.createNamedQuery(Product.NAMED_QUERY_GET_ALL).getResultList();
        return results;
    }

    public List<Product> findByCategory(String category) {
        List<Product> results = entityManager.createNamedQuery(Product.NAMED_QUERY_FIND_BY_CATEGORY).setParameter("category", category).getResultList();
        return results;
    }

    public Product create(String serial, String category) {
        Product p = new Product();
        p.setSerial(serial);
        p.setCategory(category);
        entityManager.persist(p);
        return p;
    }

}

