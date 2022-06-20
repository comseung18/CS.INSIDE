package controller;


import domain.User;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/exist-id")
    public boolean userExistById(@RequestParam String id)
    {
        User user = userService.getUserById(id);
        return user != null;
    }

    @GetMapping("/exist-nickname")
    public boolean userExistByNickname(@RequestParam String nickname)
    {
        User user = userService.getUserByNickname(nickname);
        return user != null;
    }

    @GetMapping("/users")
    public List<User> allUsers()
    {
        return userService.getAllUsers();
    }

//    @PostMapping("/user")
//    public boolean registUser(@RequestBody User newUser)
//    {
//        return userService.registNewUser(newUser);
//    }

}
