package com.nguyen.entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    private String address;
    @Temporal(TemporalType.DATE)
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "bank_fk")
    private Bank bank;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
