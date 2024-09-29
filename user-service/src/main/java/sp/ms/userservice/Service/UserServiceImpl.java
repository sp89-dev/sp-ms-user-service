package sp.ms.userservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;
import sp.ms.userservice.DTO.DepartmentDto;
import sp.ms.userservice.DTO.ResponseDto;
import sp.ms.userservice.DTO.UserDto;
import sp.ms.userservice.Entity.User;
import sp.ms.userservice.Repository.UserRepository;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    private WebClient webClient;

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

        DepartmentDto departmentDto = webClient.get()
            .uri("http://localhost:8989/api/departments/" + user.getDepartmentId())
            .retrieve()
            .bodyToMono(DepartmentDto.class)
            .block();
        
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
