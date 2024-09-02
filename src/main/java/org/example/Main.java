package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.persistence.entities.Person;
import org.example.persistence.entities.PersonDetail;

public class Main {



    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();

      try(EntityManager em = emf.createEntityManager()) {

          Person p1 = new Person("Rouvi");
          PersonDetail pd1 = new PersonDetail("Middelgrundsvej", "KBH", "2300", 25);
          p1.setPersonDetail(pd1);

          em.getTransaction().begin();
          em.persist(p1);
          em.getTransaction().commit();
      }


    }
}