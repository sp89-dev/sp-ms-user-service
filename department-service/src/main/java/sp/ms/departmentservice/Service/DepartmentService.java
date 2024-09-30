package sp.ms.departmentservice.Service;

import sp.ms.departmentservice.Entity.Department;
import java.util.UUID;

public interface DepartmentService {
    // Create Department Service
    Department saveDepartment(Department department);
    // Get Department by Id
    Department findDepartmentById(Long departmentId);
    
}
