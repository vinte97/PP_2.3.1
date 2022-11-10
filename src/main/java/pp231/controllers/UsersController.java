package pp231.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pp231.dao.UserDAO;
import pp231.models.User;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserDAO userDAO;

    @Autowired
    public UsersController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("users", userDAO.index());
        return "users/list";
    }
//
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user", userDAO.show(id));
//        return "users/show";
//    }
//
    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }
    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userDAO.save(user);
        return "redirect:/users";
    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") int id) {
//        model.addAttribute("user", userDAO.show(id));
//        return "users/editUser";
//    }
//
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
//        userDAO.update(id, user);
//        return "redirect:/users";
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") int id) {
//        userDAO.deleteUser(id);
//        return "redirect:/users";
//    }

}
