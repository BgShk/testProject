package com.bg.test;

import org.springframework.data.repository.CrudRepository;

public interface DepartmentsRepository extends CrudRepository<Department, Integer> {

    Department findDepartmentByName(String name);
}
