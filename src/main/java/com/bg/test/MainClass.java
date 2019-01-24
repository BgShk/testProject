package com.bg.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainClass {

    public static void main(String[] args){
        SpringApplication.run(MainClass.class, args);

        /*EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        //Adding to the db

        *//*Department departmentIT = new Department();
        departmentIT.setName("IT");

        Department departmentHR = new Department();
        departmentHR.setName("HR");*//*

        *//*entityManager.persist(departmentIT);
        entityManager.persist(departmentHR);*//*

        //Find and update the name of department

        *//*Department department = entityManager.find(Department.class, 1);
        department.setName("IT");*//*

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();*/

    }
}
