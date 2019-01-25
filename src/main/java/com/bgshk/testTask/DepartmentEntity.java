package com.bgshk.testTask;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "departments")
@NoArgsConstructor
public class DepartmentEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment")
    @Getter
    private int id;

    @Column(name = "name")
    @Getter @Setter
    private String name;


    @OneToMany(mappedBy = "id")
    @Getter
    private Set<Employee> employeeList;


    public DepartmentEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "DepartmentEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
