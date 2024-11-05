package ru.ChernomortsevEgor.NauJava.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ChernomortsevEgor.NauJava.PojoClasses.User;
import ru.ChernomortsevEgor.NauJava.transaction.UserServiceImpl;

@Controller
public class RegistrationController {
    private final UserServiceImpl userService;
    @Autowired
    public RegistrationController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @GetMapping("/registration")
    public String registration() {
        return "registrationForm";
    }
    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        if (userService.addUser(user)) {
            return "redirect:/login";
        }
        model.addAttribute("message", "User exists");
        return "registrationForm";
    }
}
