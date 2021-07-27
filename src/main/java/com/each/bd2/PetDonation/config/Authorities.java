package com.each.bd2.PetDonation.config;

import javax.persistence.*;

@Embeddable
public class Authorities{

    private String authority;

    public Authorities() {}

    public Authorities(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
