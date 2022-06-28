package controller;

import aop.LoginRequired;
import aop.NoLoginRequired;
import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path ="/log")
public class LoginController {

    private UserService userService;

    public LoginController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/in")
    @NoLoginRequired
    public String Login(HttpServletRequest request, HttpSession session)
    {
        String id = request.getParameter("userID");
        String pw = request.getParameter("userPasswd");

        User user = userService.getUserByIdPw(id, pw);
        if(user != null)
        {
            session.setAttribute("user", user);
        }
        return "redirect:/";
    }

    @GetMapping("/out")
    @LoginRequired
    public String Logout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/";
    }

}
