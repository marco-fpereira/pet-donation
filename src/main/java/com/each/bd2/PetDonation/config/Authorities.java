package com.each.bd2.PetDonation.config;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "authorities")
public class Authorities implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_authorities;

    @ManyToOne
    @JoinColumn(name = "username")
    private Users users;
    private String authority;

    public Authorities() {
    }

    public Authorities(Users users, String authority) {
        this.users = users;
        this.authority = authority;
    }

    public long getId_authorities() {
        return id_authorities;
    }

    public void setId_authorities(long id_authorities) {
        this.id_authorities = id_authorities;
    }

    public Users getUserCredentials() {
        return users;
    }

    public void setUserCredentials(Users users) {
        this.users = users;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authorities that = (Authorities) o;
        return id_authorities == that.id_authorities;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_authorities);
    }
}
