package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.persistence.entities.Fee;
import org.example.persistence.entities.Person;
import org.example.persistence.entities.PersonDetail;

import java.time.LocalDate;

public class Main {



    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

      try(EntityManager em = emf.createEntityManager()) {

          Person p1 = new Person("Rouvi");
          PersonDetail pd1 = new PersonDetail("Middelgrundsvej", "KBH", "2300", 25);
          p1.setPersonDetail(pd1);
          Fee f1 = new Fee(100, LocalDate.of(2024,9,2));
          Fee f2 = new Fee(150, LocalDate.of(2024,10,2));

          p1.addFee(f1);
            p1.addFee(f2);

          em.getTransaction().begin();
          em.persist(p1);
          em.getTransaction().commit();
      }


    }
}