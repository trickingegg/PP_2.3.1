package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String firstName,
                          @RequestParam String lastName,
                          @RequestParam String email) {
        User newUser = new User(firstName, lastName, email);
        userService.add(newUser);
        return "redirect:/users";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/editUser")
    public String editUserForm(@RequestParam("id") long id, Model model) {
        User existingUser = userService.findById(id);
        model.addAttribute("user", existingUser);
        return "editUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestParam("id") long id,
                             @RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam String email) {
        userService.update(new User(id, firstName, lastName, email));
        return "redirect:/users";
    }
}
