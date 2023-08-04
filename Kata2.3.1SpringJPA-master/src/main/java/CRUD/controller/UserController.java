package CRUD.controller;

import CRUD.model.User;
import CRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public String printTable(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);
        return "users";
    }

    @GetMapping(value = "/add")
    public String addUser(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email
    ) {
        if (name != null && lastName != null && email != null) {
            userService.add(new User(name, lastName, email));
        }
        return "redirect:/";
    }

    @GetMapping(value = "/update")
    public String updateUserById(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email
    ) {
        if (id != null && name != null && lastName != null && email != null) {
            userService.updateUserById(id, name, lastName, email);
        }
        return "redirect:/";
    }

    @GetMapping(value = "/delete")
    public String deleteUserById(@RequestParam(required = false) Long id) {
        if (id != null) {
            userService.removeUserById(id);
        }
        return "redirect:/";
    }
}
