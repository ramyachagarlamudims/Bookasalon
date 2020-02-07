package com.bookasalon.appointments.Models;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table(name="userdata")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @NotEmpty(message = "Please provide a FullName")
    @Column(name = "fullname")
    private String fullname;

    @NotEmpty(message = "Please provide email or username")
    @Email(message = "*Please provide a valid Email")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Please provide password")
    @Column(name = "password")
    private String password;

    @ManyToMany
    private Set<Role> roles;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return email;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

