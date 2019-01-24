package com.bg.test;

public interface IDepartmentService {

    Department save(Department department);

    String findDepartmentByName(String name);

    String putUpdate(String name, Department department);

    String update(String name, Department department);

    String delete(String name);
}
