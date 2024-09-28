package sp.ms.userservice.Service;

import sp.ms.userservice.DTO.ResponseDto;
import sp.ms.userservice.Entity.User;

public interface UserService {
   User saveUser(User user);

   ResponseDto getUserWithDepartment(Long userId);
}