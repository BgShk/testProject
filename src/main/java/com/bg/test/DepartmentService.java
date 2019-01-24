package com.bg.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class DepartmentService implements IDepartmentService{

    //TODO: Make a DTO

    @Autowired
    private DepartmentsRepository departmentsRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<DepartmentDTO> getAll(){

        Iterable<Department> iterable = departmentsRepository.findAll();

        List<DepartmentDTO> list = new ArrayList<>();

        Iterator<Department> iterator = iterable.iterator();
        while(iterator.hasNext()){
            list.add(new DepartmentDTO(iterator.next().getName()));
        }

        return list;
    }

    public String findDepartmentByName(String name){
        Department d = departmentsRepository.findDepartmentByName(name);
        if (d == null) return "Not found";

        return departmentsRepository.findDepartmentByName(name).toString();
    }

    public Department save(Department department){
        return departmentsRepository.save(department);
    }

    public String putUpdate(String name, Department department){
        Department d = departmentsRepository.findDepartmentByName(name);
        if (d == null) return "Not found";

        return  departmentsRepository.save(new Department(d.getId(), department.getName())).toString();
    }

    public String update(String name, Department department){
        Department d = departmentsRepository.findDepartmentByName(name);
        if (d == null){
            return "Not found";
        }

        d.setName(department.getName());
        return departmentsRepository.save(department).toString();
    }

    public String delete(String name){
        Department d = departmentsRepository.findDepartmentByName(name);
        if (d == null) return "Not found";

        departmentsRepository.delete(d);

        return "Deleted";
    }

    public DepartmentsRepository getDepartmentsRepository() {
        return departmentsRepository;
    }
}
