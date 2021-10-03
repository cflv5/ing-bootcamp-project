package com.ing.reportservice.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ing.reportservice.dto.CustomerDto;

@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String ssn;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private Date birthday;

    public Customer() {
        super();
    }

    public Customer(CustomerDto customer) {
        super();
        this.name = customer.getName();
        this.surname = customer.getSurname();
        this.ssn = customer.getSsn();
        this.birthday = customer.getBirthday();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Customer [birthday=" + birthday + ", id=" + id + ", name=" + name + ", ssn=" + ssn + ", surname="
                + surname + "]";
    }

}
