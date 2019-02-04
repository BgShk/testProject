package com.bgshk.testTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class Initializer implements CommandLineRunner {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @Override
    public void run(String... args) throws Exception {
        Stream.of("IT", "HR", "IT2", "HR2").forEach(departmentName -> departmentService.save(new DepartmentEntity.Builder().setName(departmentName).build()));
    }
}
