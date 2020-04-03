package com.jwttesting.jwtTesting.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Length(min=6,max=30)
    @Column(unique = true)
    private String username;

    @NotBlank
    @Length(min=6,max=30)
    private String password;

    @NotBlank
    @Email
    private String email;

    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dateRegistered;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dateUpdated;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Date getDateRegistered() {
        return dateRegistered;
    }

    @PrePersist
    public void setDateRegistered() {
        this.dateRegistered = new Date();
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    @PreUpdate
    public void setDateUpdated() {
        this.dateUpdated = new Date();
    }
}
