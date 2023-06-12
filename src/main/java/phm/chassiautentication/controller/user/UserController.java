package phm.chassiautentication.controller.user;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
@AllArgsConstructor
public class UserController {

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping
    public String AuthTest(){
        return "Welcome to user page";
    }
}
