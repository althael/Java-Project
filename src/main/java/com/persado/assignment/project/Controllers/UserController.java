package com.persado.assignment.project.Controllers;

import com.persado.assignment.project.Entities.User;
import com.persado.assignment.project.Services.UserServices.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("users")
public class UserController {

    private UserService userService;

    public UserController(UserService theUserService) {
        userService = theUserService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listUsers(Model theModel) {

        // get users from db
        List<User> theUsers = userService.findAll();

        // add to the spring model
        theModel.addAttribute("users", theUsers);

        return "/users/list-users";
    }

    @GetMapping("/addNewUser")
    public String showFormForAddUser(Model theModel) {

        // create model attribute to bind form data
        User theUser = new User();

        theModel.addAttribute("users", theUser);

        return "/users/user-form";
    }


    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("users") User theUser) {

        // save the user
        userService.save(theUser);

        // use a redirect to prevent duplicate submissions
        return "redirect:/users/list";
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("userId") long theId) {

        // delete the user
        userService.deleteById(theId);

        // redirect to /user/list
        return "redirect:/users/list";

    }


}