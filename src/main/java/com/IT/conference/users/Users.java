package com.IT.conference.users;

import com.IT.conference.prelections.Prelections;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Users {
    @Id
    @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_sequence"
    )

    private Long id;
    @NotNull
    private String login;
    @NotNull
    private String email;

    @ManyToMany
    @JoinTable(
            name = "registerToPrelection",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "prelection_id")
    )
    private List<Prelections> register = new ArrayList<>();


    public Users() {
    }

    public Users(Long id,
                String login,
                String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }

    public Users(String login,
                String email) {
        this.login = login;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void register(Prelections prelection){
        register.add(prelection);
    }

    public void delete(Prelections prelection){
        register.remove(prelection);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
