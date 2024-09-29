package sp.ms.feign.userservice.Service;

import sp.ms.feign.userservice.DTO.ResponseDto;
import sp.ms.feign.userservice.Entity.User;

public interface UserService {
   User saveUser(User user);

   ResponseDto getUserWithDepartment(Long userId);
}