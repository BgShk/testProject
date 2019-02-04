package com.bgshk.testTask;

import lombok.Getter;
import lombok.Setter;

public class DepartmentDTO {

    @Getter
    private String name;

    public static class Builder{

        private String name;

        public Builder setName(String name){
            this.name = name;

            return this;
        }

        public DepartmentDTO build(){
            DepartmentDTO dto = new DepartmentDTO();

            dto.name = name;

            return dto;
        }

    }

    private DepartmentDTO() { }

}

