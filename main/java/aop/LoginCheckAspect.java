package aop;


import auth.AuthException;
import domain.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Component
@Aspect
public class LoginCheckAspect {

    public LoginCheckAspect(){}

    // 로그인이 필요한 페이지에 접근했을 때 실행 됨.
    @Before("@annotation(aop.LoginRequired)")
    public void loginRequired(JoinPoint jp) throws Throwable
    {
        System.out.println("here???");
        HttpSession session = ((ServletRequestAttributes)(RequestContextHolder.
                currentRequestAttributes())).
                getRequest().
                getSession();
        User user = (User)session.getAttribute("user");
        if(user == null)
        {
            throw new AuthException("LOGIN_REQUIRED");
        }
    }

    // 비로그인으로만 접근 가능한 페이지.
    @Before("@annotation(aop.NoLoginRequired)")
    public void noLoginRequired(JoinPoint jp) throws Throwable
    {
        System.out.println("here?");
        HttpSession session = ((ServletRequestAttributes)(RequestContextHolder.
                currentRequestAttributes())).
                getRequest().
                getSession();
        User user = (User)session.getAttribute("user");
        if(user != null)
        {
            throw new AuthException("NO_LOGIN_REQUIRED");
        }
    }

}
