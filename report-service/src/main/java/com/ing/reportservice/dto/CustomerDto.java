package com.ing.reportservice.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CustomerDto {
    @NotBlank
    private String ssn;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotNull
    private Date birthday;

    @NotBlank
    private String phone;

    @NotBlank
    private String email;

    public CustomerDto(@NotBlank String ssn, @NotBlank String name, @NotBlank String surname, @NotNull Date birthday,
            @NotBlank String phone, @NotBlank String email) {
        this.ssn = ssn;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
    }

    public String getSsn() {
        return ssn;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

}
