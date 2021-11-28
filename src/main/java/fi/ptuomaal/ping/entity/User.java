package fi.ptuomaal.ping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery
            (
            name=User.NAMED_QUERY_GET_ALL,
            query="SELECT u FROM User u"
            ),@NamedQuery
    (
            name=User.NAMED_QUERY_FIND_BY_FIRST_NAME,
            query="SELECT u FROM User u where u.firstName =:firstName"
    )
})
public class User {
    public static final String NAMED_QUERY_GET_ALL="USER_GET_ALL";
    public static final String NAMED_QUERY_FIND_BY_FIRST_NAME="USER_FIND_BY_FIRST_NAME";

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    public User() {   }

    public User(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
