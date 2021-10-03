package com.ing.reportservice.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class CreditReport implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @ManyToOne
    private Customer customer;

    @CreationTimestamp
    private Timestamp createdAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;

    @Column(nullable = false)
    private Integer amount;

    @OneToOne
    private ContactInformation contactInformation;

    public CreditReport id(UUID id) {
        this.id = id;
        return this;
    }

    public CreditReport customer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public CreditReport createdAt(Timestamp createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public CreditReport currencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
        return this;
    }

    public CreditReport amount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public CreditReport contactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
        return this;
    }

    public CreditReport() {
        super();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    @Override
    public String toString() {
        return "CreditReport [amount=" + amount + ", contactInformation=" + contactInformation + ", createdAt="
                + createdAt + ", currencyType=" + currencyType + ", customer=" + customer + ", id=" + id + "]";
    }

}
