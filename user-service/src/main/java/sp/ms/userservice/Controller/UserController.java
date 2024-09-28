package sp.ms.userservice.Controller;


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
import sp.ms.userservice.DTO.ResponseDto;
import sp.ms.userservice.Entity.User;
import sp.ms.userservice.Service.UserService;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User userSave = userService.saveUser(user);
        return new ResponseEntity<>(userSave, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDto> getUserWithDepartment(@PathVariable("id") Long userId) {
        ResponseDto responseDto = userService.getUserWithDepartment(userId);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    
}
