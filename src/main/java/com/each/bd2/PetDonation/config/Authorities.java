package com.each.bd2.PetDonation.config;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Authorities{

    private String authority;

    public Authorities() {}

    public Authorities(String authority) {
        this.authority = authority;
    }

}
