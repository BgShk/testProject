package com.bg.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DepartmentsController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public @ResponseBody List<DepartmentDTO> departments(){
       return departmentService.getAll();
    }

    @GetMapping("departments/{name}")
    public @ResponseBody String department(@PathVariable(name = "name") String name){
        return departmentService.findDepartmentByName(name);
    }

   @PostMapping("departments")
   public @ResponseBody String add(@RequestBody Department d){
        return"Saved " + departmentService.save(d);
   }

   @PutMapping("departments/{name}")
   public @ResponseBody String putUpdate(@PathVariable(name = "name") String name, @RequestBody Department department){
        return "Updated to " + departmentService.putUpdate(name, department);
   }

   @PatchMapping("departments/{name}")
   public @ResponseBody String update(@PathVariable(name = "name") String name, @RequestBody Department department){
       return "Renamed to " + departmentService.update(name, department);
   }

   @DeleteMapping("departments/{name}")
   public @ResponseBody String delete(@PathVariable(name = "name") String name){
        return  departmentService.delete(name);
   }

    @GetMapping
    public String index(){
        return "index";
    }

}
