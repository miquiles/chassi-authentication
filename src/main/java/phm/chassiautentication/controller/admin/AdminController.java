package phm.chassiautentication.controller.admin;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import phm.chassiautentication.controller.user.UserController;
import phm.chassiautentication.model.User;
import phm.chassiautentication.repository.UserRepository;

import java.security.Principal;

@RequestMapping("/admins")
@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class AdminController {
    final UserRepository userRepository;
    final PasswordEncoder passwordEncoder;


    @GetMapping
    public String AuthTest(Principal principal){
        String username = principal.getName();
        System.out.println(username);
        return "Welcome to admin page";
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }
}
