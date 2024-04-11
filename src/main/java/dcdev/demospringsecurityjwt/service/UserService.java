package dcdev.demospringsecurityjwt.service;

import dcdev.demospringsecurityjwt.model.User;
import dcdev.demospringsecurityjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createUser(User user) {
        String pass = user.getPassword();

        user.setPassword(passwordEncoder.encode(pass));
        userRepository.save(user);
    }
}
