package com.bgshk.testTask;

public interface DepartmentService {

    DepartmentDTO save(DepartmentEntity departmentEntity);

    DepartmentDTO getDepartmentByName(String name);

    DepartmentDTO putUpdate(String name, DepartmentEntity departmentEntity);

    DepartmentDTO update(String name, DepartmentEntity departmentEntity);

    void delete(String name);
}
