package com.bgshk.testTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.bgshk.testTask.Consts.*;

import java.util.List;

@Controller
@RequestMapping("/departments")
public class DepartmentsController {

    @Autowired
    private DepartmentServiceImpl departmentService;

    @GetMapping
    public @ResponseBody List<DepartmentDTO> departments(){
       return departmentService.getAll();
    }

    @GetMapping("{name}")
    public @ResponseBody String department(@PathVariable(name = "name") String name){
        return departmentService.getDepartmentByName(name);
    }

   @PostMapping
   public @ResponseBody String add(@RequestBody DepartmentEntity d){
        return SAVED + departmentService.save(d);
   }

   @PutMapping("{name}")
   public @ResponseBody String putUpdate(@PathVariable(name = "name") String name, @RequestBody DepartmentEntity departmentEntity){
        return UPDATED_TO + departmentService.putUpdate(name, departmentEntity);
   }

   @PatchMapping("{name}")
   public @ResponseBody String update(@PathVariable(name = "name") String name, @RequestBody DepartmentEntity departmentEntity){
       return RENAMED_TO + departmentService.update(name, departmentEntity);
   }

   @DeleteMapping("{name}")
   public @ResponseBody void delete(@PathVariable(name = "name") String name){
        departmentService.delete(name);
   }

}
