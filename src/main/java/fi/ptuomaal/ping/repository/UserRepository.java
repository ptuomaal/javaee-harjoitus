package fi.ptuomaal.ping.repository;

import fi.ptuomaal.ping.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Defines methods to query and update the Pong rows in the database.
 */
public class UserRepository {

    @PersistenceContext(unitName="ping")
    EntityManager entityManager;

    public List<User> findAll() {
        List<User> results = castUserList(entityManager.createNamedQuery(User.NAMED_QUERY_GET_ALL).getResultList());
        return results;
    }


    public User create(String firstName, String lastName) {
        User u = new User();
        u.setFirstName(firstName);
        u.setLastName(lastName);
        entityManager.persist(u);
        return u;
    }

    private static List<User> castUserList(List<?> li) {
        List<User> list = new ArrayList<User>(li.size());
        for (Object o: li) {
          list.add((User) o);
        }
        return list;
    }
}
