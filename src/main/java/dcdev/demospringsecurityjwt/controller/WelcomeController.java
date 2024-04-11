package dcdev.demospringsecurityjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping
    public String welcome() {
        return  "Bem-vindo!";
    }

    @GetMapping("/users")
    public String users() {
        return "Usuario autorizado!";
    }

    @GetMapping("/managers")
    public String managers() {
        return "Gerentes autorizados!";
    }
}
