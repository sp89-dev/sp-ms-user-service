package sp.ms.feign.userservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sp.ms.feign.userservice.APIClient;
import sp.ms.feign.userservice.DTO.DepartmentDto;
import sp.ms.feign.userservice.DTO.ResponseDto;
import sp.ms.feign.userservice.DTO.UserDto;
import sp.ms.feign.userservice.Entity.User;
import sp.ms.feign.userservice.Repository.UserRepository;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    // First, inject APIClient and then use it:
    private APIClient apiClient;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseDto getUserWithDepartment(Long userId) {
        ResponseDto responseDto = new ResponseDto();

        User user = userRepository.findById(userId).get();
        UserDto userDto = mapToUser(user);

        //get the department data from department service
        // ResponseEntity<DepartmentDto> responseEntity = new ResponseEntity<>(null);

        // RestTemplate to make a REST API call to department-service
        // Retrieve a representation by doing a GET on the URL. The response is converted and stored in a ResponseEntity.
        /*ResponseEntity<DepartmentDto> responseEntity = restTemplate
            .getForEntity("http://localhost:8989/api/departments/" + user.getDepartmentId(),
            DepartmentDto.class);

        DepartmentDto departmentDto = responseEntity.getBody();*/

        // DepartmentDto departmentDto = webClient.get()
        //     .uri("http://localhost:8989/api/departments/" + user.getDepartmentId())
        //     .retrieve()
        //     .bodyToMono(DepartmentDto.class)
        //     .block();
        
        // Change the getUser method to call APIClient
        DepartmentDto departmentDto = apiClient.findDepartmentById(user.getDepartmentId());
        responseDto.setUser(userDto);
        responseDto.setDepartment(departmentDto);
        return responseDto;
    }

    private UserDto mapToUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        // userDto.setDepartmentId(user.getDepartmentId());
        return userDto;
    }
    
}
