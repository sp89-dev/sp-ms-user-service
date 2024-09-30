package sp.ms.departmentservice.Repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import sp.ms.departmentservice.Entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
    
}
