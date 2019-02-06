package com.bgshk.testTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.bgshk.testTask.Consts.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
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
    public @ResponseBody ResponseEntity<DepartmentDTO> department(@PathVariable(name = "name") String name){
       return new ResponseEntity<>(departmentService.getDepartmentByName(name), HttpStatus.OK);
    }

   @PostMapping
   public ResponseEntity<DepartmentDTO> add(@RequestBody DepartmentEntity d){
        return new ResponseEntity<>(departmentService.save(d), HttpStatus.CREATED);
   }

   @PutMapping("{name}")
   public @ResponseBody ResponseEntity<DepartmentDTO> putUpdate(@PathVariable(name = "name") String name, @RequestBody DepartmentEntity departmentEntity){
        return new ResponseEntity<>(departmentService.putUpdate(name, departmentEntity), HttpStatus.OK);
   }

   @PatchMapping("{name}")
   public @ResponseBody ResponseEntity<DepartmentDTO> update(@PathVariable(name = "name") String name, @RequestBody DepartmentEntity departmentEntity){
       return new ResponseEntity<>(departmentService.update(name, departmentEntity), HttpStatus.OK);
   }

   @DeleteMapping("{name}")
   public @ResponseBody void delete(@PathVariable(name = "name") String name){
        departmentService.delete(name);
   }

}
