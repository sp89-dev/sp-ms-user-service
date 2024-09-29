package sp.ms.feign.userservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sp.ms.feign.userservice.DTO.DepartmentDto;

@FeignClient(value = "department-service", url = "http://localhost:8989")
public interface APIClient {
    @GetMapping("/api/departments/{id}")
    DepartmentDto findDepartmentById(@PathVariable("id") Long departmentId);
}
