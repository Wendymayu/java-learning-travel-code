package com.wendy.cookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/10/26 22:55
 * @Version 1.0
 */
@Controller
@RequestMapping("/hello")
public class CookieSessionTest {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        System.out.println("sessionId: " + session.getId() + "  session is New: " + session.isNew());
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                System.out.println("cookieName: " + cookie.getName() + "  cookieValue:" + cookie.getValue());
            }
        }else{
            Cookie cookie = new Cookie("JSESSIONID",session.getId());
            cookie.setComment("success");
            cookie.setMaxAge(10000);
            response.addCookie(cookie);
        }
        return "world";
    }

    @RequestMapping(value = "/session", method = RequestMethod.GET)
    @ResponseBody
    public String setCookie(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("新的一次请求-----------------");
        HttpSession session = request.getSession();
        System.out.println("sessionId: " + session.getId() + "  session is New: " + session.isNew());
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                System.out.println("cookieName: " + cookie.getName() + "  cookieValue:" + cookie.getValue());
            }
        }else{
            Cookie cookie = new Cookie("JSESSIONID",session.getId());
            cookie.setComment("success");
            cookie.setMaxAge(10000);
            response.addCookie(cookie);
        }
        return "world";
    }
}

