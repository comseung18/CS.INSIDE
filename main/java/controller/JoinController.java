package controller;


import domain.User;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String joinInfoPost(@RequestBody User newUser)
    {
        // 신규 유저의 아이디나 비밀번호 등의 제약 조건 검사
        if(!newUser.IsValidNewUser()) return "redirect:/error/404";

        // id 가 중복되는 경우
        if(userService.getUserById(newUser.getId()) != null) return "redirect:/error/404";

        // 고정닉인데 닉네임이 중복되는 경우
        if(newUser.getFixedName() && userService.getUserByNickname(newUser.getNickname()) != null) return "redirect:/error/404";

        // 생성에 실패하면 false 가 반환됨
        if(!userService.registNewUser(newUser)) return "redirect:/error/404";

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
