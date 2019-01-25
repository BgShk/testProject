package com.bgshk.testTask;

import lombok.Getter;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.bgshk.testTask.Consts.*;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    //TODO: Rewrite getDepartment method

    @Getter
    private DepartmentsRepository departmentsRepository;

    @Getter
    private EmployeeRepository employeeRepository;

    public DepartmentServiceImpl(DepartmentsRepository departmentsRepository){
        this.departmentsRepository = departmentsRepository;
    }

    public List<DepartmentDTO> getAll(){
        Iterable<DepartmentEntity> iterable = departmentsRepository.findAll();
        List<DepartmentDTO> list = StreamSupport.stream(iterable.spliterator(), false).map(dp -> new DepartmentDTO(dp.getName())).collect(Collectors.toList());

        return list;
    }

    public String getDepartmentByName(String name){
        DepartmentEntity d = departmentsRepository.findDepartmentByName(name);
        if (Objects.isNull(d)) return NOT_FOUND;

        return departmentsRepository.findDepartmentByName(name).toString();
    }

    public DepartmentEntity save(DepartmentEntity departmentEntity){
        return departmentsRepository.save(departmentEntity);
    }

    public String putUpdate(String name, DepartmentEntity departmentEntity){
        DepartmentEntity d = departmentsRepository.findDepartmentByName(name);
        if (Objects.isNull(d)) return NOT_FOUND;

        return  departmentsRepository.save(new DepartmentEntity(d.getId(), departmentEntity.getName())).toString();
    }

    public String update(String name, DepartmentEntity departmentEntity){
        DepartmentEntity d = departmentsRepository.findDepartmentByName(name);
        if (Objects.isNull(d)) return NOT_FOUND;


        d.setName(departmentEntity.getName());
        return departmentsRepository.save(departmentEntity).toString();
    }

    public void delete(String name){
        DepartmentEntity d = departmentsRepository.findDepartmentByName(name);
        if (Objects.isNull(d)) return;

        departmentsRepository.delete(d);

    }

}
