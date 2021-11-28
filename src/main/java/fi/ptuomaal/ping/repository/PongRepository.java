package fi.ptuomaal.ping.repository;

import fi.ptuomaal.ping.entity.Pong;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Defines methods to query and update the Pong rows in the database.
 */
public class PongRepository {

    @PersistenceContext(unitName="ping")
    EntityManager entityManager;

    public List<Pong> findAll() {
        List<Pong> results = castPongList(entityManager.createNamedQuery(Pong.NAMED_QUERY_GET_ALL).getResultList());
        return results;
    }

    public List<Pong> findByPongName(String name) {
        List<Pong> tmp = findAll();
        List<Pong> results = new ArrayList<>();
        for(Pong p : tmp) {
            if ( p.getName().equals(name))
                results.add(p);
        }
        return results;
    }

    public List<Pong> findByName(String name) {
        List<Pong> results = castPongList(entityManager.createNamedQuery(Pong.NAMED_QUERY_FIND_BY_NAME).setParameter("name", name).getResultList());
        return results;
    }

    public Pong findById(Long id) {
        return (Pong) entityManager.createNativeQuery("select * from pong where id=" + id, Pong.class).getSingleResult();
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

    private static List<Pong> castPongList(List<?> li) {
        List<Pong> list = new ArrayList<Pong>(li.size());
        for (Object o: li) {
          list.add((Pong) o);
        }
        return list;
    }

}

