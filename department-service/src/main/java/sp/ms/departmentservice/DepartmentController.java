package sp.ms.departmentservice.Controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sp.ms.departmentservice.Entity.Department;
import sp.ms.departmentservice.Service.DepartmentService;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    
    // @PostMapping("/departments")
    // public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
    //     Department saveDepartment = departmentService.saveDepartment(department);
    //     return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    // }   

    // @GetMapping("/departments/{id}")
    // public ResponseEntity<Department> findDepartmentById(@PathVariable("id") UUID departmentId) {
    //     Department department = departmentService.findDepartmentById(departmentId);
    //     return new ResponseEntity<>(department, HttpStatus.OK);
    // }
    @PostMapping
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
        Department saveDepartment = departmentService.saveDepartment(department);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }   

    @GetMapping("{id}")
    public ResponseEntity<Department> findDepartmentById(@PathVariable("id") Long departmentId) {
        Department department = departmentService.findDepartmentById(departmentId);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }
}
