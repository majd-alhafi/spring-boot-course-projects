package majd.alhafi.jwt.service.auth;

import majd.alhafi.jwt.dto.SignupDTO;
import majd.alhafi.jwt.dto.UserDTO;

public interface AuthService {
    UserDTO createUser(SignupDTO signupDTO);
}
