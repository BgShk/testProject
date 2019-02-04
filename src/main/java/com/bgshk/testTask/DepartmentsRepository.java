package com.bgshk.testTask;

import org.springframework.data.repository.CrudRepository;

public interface DepartmentsRepository extends CrudRepository<DepartmentEntity, Integer> {

    DepartmentEntity findDepartmentByName(String name);
}

