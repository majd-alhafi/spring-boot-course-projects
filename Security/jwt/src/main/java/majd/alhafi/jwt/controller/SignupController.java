package majd.alhafi.jwt.controller;

import majd.alhafi.jwt.dto.SignupDTO;
import majd.alhafi.jwt.dto.UserDTO;
import majd.alhafi.jwt.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {

    @Autowired
    private  AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody SignupDTO signupDTO) {
        UserDTO createdUser = authService.createUser(signupDTO);
        if (createdUser == null){
            return new ResponseEntity<>("User not created, come again later!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

}
