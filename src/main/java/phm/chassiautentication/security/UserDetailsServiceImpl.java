package phm.chassiautentication.security;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import phm.chassiautentication.repository.UserRepository;

@Service
@AllArgsConstructor
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userLogin = userRepository.findByMail(username).orElseThrow(() -> new UsernameNotFoundException("User not found : " + username));
        return new User(userLogin.getUsername(),
                userLogin.getPassword(), true,
                true, true, true,
                userLogin.getAuthorities());
    }

}
