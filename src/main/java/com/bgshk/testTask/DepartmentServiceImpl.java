package com.bgshk.testTask;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.bgshk.testTask.Consts.*;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    //TODO: Rewrite getDepartment method

    private DepartmentsRepository departmentsRepository;

    private EmployeeRepository employeeRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentsRepository departmentsRepository, EmployeeRepository employeeRepository){
        this.departmentsRepository = departmentsRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<DepartmentDTO> getAll(){
        Iterable<DepartmentEntity> iterable = departmentsRepository.findAll();
        List<DepartmentDTO> list = StreamSupport.stream(iterable.spliterator(), false).map(dp -> new DepartmentDTO.Builder().setName(dp.getName()).build()).collect(Collectors.toList());

        return list;
    }

    public DepartmentDTO getDepartmentByName(String name){
        DepartmentEntity d = departmentsRepository.findDepartmentByName(name);
        if (Objects.isNull(d)) return null;

        return new DepartmentDTO.Builder().setName(d.getName()).build();
    }

    public DepartmentDTO save(DepartmentEntity departmentEntity){

        DepartmentEntity d = departmentsRepository.save(departmentEntity);

        return new DepartmentDTO.Builder().setName(d.getName()).build();
    }

    public DepartmentDTO putUpdate(String name, DepartmentEntity departmentEntity){
        DepartmentEntity d = departmentsRepository.findDepartmentByName(name);

        if (Objects.isNull(d)) return null;

        departmentsRepository.save( new DepartmentEntity.Builder().setId(d.getId()).setName(departmentEntity.getName()).build());

        return new DepartmentDTO.Builder().setName(departmentEntity.getName()).build();
    }

    public DepartmentDTO update(String name, DepartmentEntity departmentEntity){
        DepartmentEntity d = departmentsRepository.findDepartmentByName(name);
        if (Objects.isNull(d)) return null;

        departmentsRepository.save( new DepartmentEntity.Builder().setId(d.getId()).setName(departmentEntity.getName()).build());

        return new DepartmentDTO.Builder().setName(departmentEntity.getName()).build();
    }

    public void delete(String name){
        DepartmentEntity d = departmentsRepository.findDepartmentByName(name);
        if (Objects.isNull(d)) return;

        departmentsRepository.delete(d);

    }

}
