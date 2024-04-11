package dcdev.demospringsecurityjwt.controller;

import dcdev.demospringsecurityjwt.dto.Login;
import dcdev.demospringsecurityjwt.dto.Session;
import dcdev.demospringsecurityjwt.model.User;
import dcdev.demospringsecurityjwt.repository.UserRepository;
import dcdev.demospringsecurityjwt.security.JWTCreator;
import dcdev.demospringsecurityjwt.security.JWTObject;
import dcdev.demospringsecurityjwt.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LoginController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public Session logar(@RequestBody Login login) {
        User user = userRepository.findByUsername(login.username());

        if(user != null) {
            boolean passwordOk =  passwordEncoder.matches(login.password(), user.getPassword());

            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o login: " + login.username());
            }

            Session session = new Session();
            session.setLogin(user.getUsername());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
            jwtObject.setRoles(user.getRoles());

            session.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
            return session;
        } else {
            throw new RuntimeException("Error ao tentar fazer login!");
        }
    }
}
