package danh.com.Clone.Ecomerce.controller;

import danh.com.Clone.Ecomerce.entity.Role;
import danh.com.Clone.Ecomerce.entity.User;
import danh.com.Clone.Ecomerce.service.RoleService;
import danh.com.Clone.Ecomerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/users")
    public String listAll(Model model) {
        List<User> listUsers = userService.listAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }


    @GetMapping("/users/create")
    public String createUser(Model model){
        List<Role> listRoles = roleService.listAll();

        User user = new User();
        user.setEnabled(true);

        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);

        return "user_form";
    }

    @PostMapping("users/save")
    public String saveUser(User user, RedirectAttributes redirectAttributes){
        System.out.println(user);
        userService.saveUser(user);
        redirectAttributes.addFlashAttribute("message", "The user has been saved successfully.");

        return "redirect:/users";
    }

}
