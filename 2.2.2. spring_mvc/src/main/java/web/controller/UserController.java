package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/readUsers")
    public String printUsers(ModelMap modelMap) {

        if (userService.getUserList() == null) {
            modelMap.addAttribute("user", "empty user storage");
        } else modelMap.addAttribute("user", userService.getUserList());
        return "readUser";
    }

    @GetMapping(value = "/createUser")
    public String createUser(ModelMap modelMap) {
        User user = new User();
        modelMap.addAttribute("user", user);
        return "createUser";
    }

    @PostMapping(value = "/createUser")
    public String submitUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/readUser";
    }
}
