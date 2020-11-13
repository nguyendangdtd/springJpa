package com.nguyen.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
    
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private List<Bank> banks;
    
    
    public List<Bank> getBanks() {
        return banks;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }

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
