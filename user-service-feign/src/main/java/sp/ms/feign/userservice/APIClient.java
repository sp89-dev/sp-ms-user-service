package sp.ms.feign.userservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sp.ms.feign.userservice.DTO.DepartmentDto;

//for the Feign client, we need to specify the name of the service we want to call - without spring cloud config server
// @FeignClient(value = "department-service", url = "http://localhost:8989")
// after spring cloud config server - department service port is 8080 and user service fiegn port is 8081
// @FeignClient(value = "department-service", url = "http://localhost:8080")// config server
@FeignClient(value = "department-service", url = "http://DEPARTMENT-SERVICE") // eureka server
public interface APIClient {
    @GetMapping("/api/departments/{id}")
    DepartmentDto findDepartmentById(@PathVariable("id") Long departmentId);
}
