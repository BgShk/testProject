package com.bgshk.testTask;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "departments")
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

    @OneToMany
    @JoinColumn(name = "departments_id")
    @Getter
    private Set<Employee> employeeList;

    public static class Builder {

        private int id;
        private String name;

        public Builder setName(String name){
            this.name = name;

            return this;
        }

        public Builder setId(int id){
            this.id = id;

            return this;
        }

        public DepartmentEntity build(){
            DepartmentEntity d = new DepartmentEntity();
            d.name = name;
            d.id = id;

            return d;
        }

    }

    private DepartmentEntity() {}

    @Override
    public String toString() {
        return "DepartmentEntity{" +
                "name='" + name + '\'' +
                '}';
    }
}
