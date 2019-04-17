package Hibernate.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users")
public class UsersDataSet implements Serializable {
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(name="login", unique=true, updatable = false)
    private String login;

    @Column(name="password", updatable = false)
    private String password;

    @Column(name = "email", unique = true, updatable = false)
    private String email;

    public UsersDataSet(){}

    public UsersDataSet(String login, String password, String email){
        this.setLogin(login);
        this.setPassword(password);
        this.setEmail(email);
        this.setId(-1);
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
