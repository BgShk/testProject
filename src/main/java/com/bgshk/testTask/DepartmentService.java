package com.bgshk.testTask;

public interface DepartmentService {

    DepartmentEntity save(DepartmentEntity departmentEntity);

    String getDepartmentByName(String name);

    String putUpdate(String name, DepartmentEntity departmentEntity);

    String update(String name, DepartmentEntity departmentEntity);

    void delete(String name);
}
