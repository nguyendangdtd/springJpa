package com.nguyen.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author XV
 */
@Entity
public class Account {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ownerName;
    private double babance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getBabance() {
        return babance;
    }

    public void setBabance(double babance) {
        this.babance = babance;
    }

    @Override
    public String toString() {
        return "Account Information - ID: " + this.id
                + " - Name: " + this.ownerName
                + " - balance: " + this.babance;
    }

}
