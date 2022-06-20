package controller;


import domain.User;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping(path = "/join")
public class JoinController {

    private UserService userService;

    public JoinController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/agree")
    public String joinAgree()
    {
        return "join-agree";
    }

    @GetMapping("/info")
    public String joinInfo(HttpServletRequest request)
    {
        String referer = request.getHeader("referer");
        if(referer == null || !referer.endsWith("/join/agree")) return "redirect:/error/404";

        return "join-info";
    }

    @PostMapping("/info")
    public String joinInfoPost(HttpServletRequest request)
    {
        String id = request.getParameter("joinInfoId");
        String pw = request.getParameter("joinInfoPw");
        String pwRe = request.getParameter("joinInfoPwRe");
        String nickname = request.getParameter("joinInfoNick");
        boolean fixed = request.getParameter("joinInfoFixed").equals("fixed");
        String email = request.getParameter("joinInfoEmail");

        // 우회했을 수 있으므로 2차 검증 필요함.
        // TODO 기타 길이나 형식 등 검증 필요함.
        if(userService.getUserById(id) != null) return "redirect:/error/404";
        else if(fixed && userService.getUserByNickname(nickname) != null) return "redirect:/error/404";
        else if(!pw.equals(pwRe)) return "redirect:/error/404";


        // 신규 유저 객체를 만듦.
        User user = new User();
        user.setId(id);
        user.setPasswd(pw);
        user.setNickname(nickname);
        user.setFixedName(fixed);
        user.setEmail(email);

        if(!userService.registNewUser(user)) return "redirect:/error/404";

        return "redirect:/join/complete";
    }

    @GetMapping("/complete")
    public String joinComplete(HttpServletRequest request)
    {
        String referer = request.getHeader("referer");
        if(referer == null || !referer.endsWith("/join/info")) return "redirect:/error/404";

        return "join-complete";
    }

}
