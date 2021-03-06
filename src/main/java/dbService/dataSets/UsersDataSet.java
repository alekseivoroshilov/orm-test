package dbService.dataSets;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
@Entity
@Table(name = "users")
public class UsersDataSet implements Serializable { // Serializable Important to Hibernate!
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true, updatable = false)
    private String name;

    @Column(name = "password", unique = false, updatable = false)
    private String password;

    //Important to Hibernate!
    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet() {
    }

    @SuppressWarnings("UnusedDeclaration")
    public UsersDataSet(long id, String name, String password) {
        this.setId(id);
        this.setName(name);
        this.setPassword(password);
    }

    public UsersDataSet(String name, String password) {
        this.setId(-1);
        this.setName(name);
        this.setPassword(password);
    }

    public UsersDataSet(String name) {
        this.setId(-1);
        this.setName(name);
        this.setPassword("password");
    }

    @SuppressWarnings("UnusedDeclaration")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }


    @Override
    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", name='" + name +
                ", password='" + password + '\'' +
                '}';
    }
}