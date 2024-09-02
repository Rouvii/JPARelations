package org.example.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Rouvi
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity


public class PersonDetail {
    @Id
    private int id;
    private String address;
    private String city;
    private String zipCode;
    private int age;

    public PersonDetail(String address, String city, String zipCode, int age) {
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.age = age;
    }

//Relations 1:1

    @OneToOne
    @MapsId
    private Person person;

}
