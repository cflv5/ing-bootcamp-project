package com.ing.citizenapi.dto;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

@Validated
public class Citizen {
    @Min(11)
    @Max(11)
    private String ssn;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @NotNull
    private Date birthday;

    public Citizen() {
        super();
    }

    public Citizen(@Size(min = 11, max = 11) String ssn, @NotBlank String name, @NotBlank String surname,
            @NotNull Date birthday) {
        this.ssn = ssn;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
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

    @Override
    public String toString() {
        return "Citizen [birthday=" + birthday + ", name=" + name + ", ssn=" + ssn + ", surname=" + surname + "]";
    }

}
