package fi.ptuomaal.ping.repository;

import fi.ptuomaal.ping.entity.Pong;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PongRepository {

    @PersistenceContext(unitName="ping")
    EntityManager entityManager;

    public List<Pong> findAll() {
        List<Pong> results = entityManager.createNamedQuery(Pong.NAMED_QUERY_GET_ALL).getResultList();
        return results;
    }

    public Pong create(String name) {
        Pong p = new Pong();
        p.setName(name);
        entityManager.persist(p);
        return p;
    }

    public Pong update(Pong p) {
        Pong fresh = entityManager.merge(p);
        return fresh;
    }

    public boolean delete(Pong p) {
        try {
            entityManager.remove(p);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Pong> findByName(String name) {
        List<Pong> results = entityManager.createNamedQuery(Pong.NAMED_QUERY_FIND_BY_NAME).setParameter("name", name).getResultList();
        return results;
    }

    public Pong findById(int id) {
        return entityManager.find(Pong.class, id);
    }
}

