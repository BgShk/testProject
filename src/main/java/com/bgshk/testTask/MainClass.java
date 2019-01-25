package com.bgshk.testTask;

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

        *//*DepartmentEntity departmentIT = new DepartmentEntity();
        departmentIT.setName("IT");

        DepartmentEntity departmentHR = new DepartmentEntity();
        departmentHR.setName("HR");*//*

        *//*entityManager.persist(departmentIT);
        entityManager.persist(departmentHR);*//*

        //Find and update the name of department

        *//*DepartmentEntity department = entityManager.find(DepartmentEntity.class, 1);
        department.setName("IT");*//*

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();*/

    }
}
