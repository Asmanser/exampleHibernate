package by.andersen.training.hibernatecrud.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role_name",length = 20,nullable = false)
    private String roleName;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn (name = "role_id"),
            inverseJoinColumns = @JoinColumn (name = "user_id"))
    private List<User> users;

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
