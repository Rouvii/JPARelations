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
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


    //relationer 1:1
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private PersonDetail personDetail;

    public Person(String name) {
        this.name = name;
    }


    //Bi-directional update

    public void setPersonDetail(PersonDetail personDetail) {
        this.personDetail = personDetail;

        if (personDetail != null)
        {
            personDetail.setPerson(this);
        }


    }
}
