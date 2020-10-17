package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CookieController {

    @GetMapping("/add-cookies")
    @ResponseBody
    public String cookiesAdd(HttpServletResponse response){
        Cookie cookie1 = new Cookie("user", "Jan");
        Cookie cookie2 = new Cookie("uid", "ccb1b154-c4ff");
        Cookie cookie3 = new Cookie("IDE", "IntelliJ");
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);

        return "set Cookies";
    }

    @RequestMapping("/all-cookies")
    public String allCookies(HttpServletRequest request, Model m){
        Cookie a = WebUtils.getCookie(request, "user");
        Cookie b = WebUtils.getCookie(request, "uid");
        Cookie c = WebUtils.getCookie(request, "IDE");

        List<Cookie> cookieList = new ArrayList<>();
        cookieList.add(a);
        cookieList.add(b);
        cookieList.add(c);

        m.addAttribute("cookies", cookieList);
        cookieList.toString();

        return "cookies";
    }

    @RequestMapping("/all-cookies2")
    @ResponseBody
    public String allCookies2(@CookieValue("user") String a, @CookieValue("uid") String b, @CookieValue("IDE") String c){



        return "cookie1: " + a + ", cookie2: " + b + ", cookie3: " + c;
    }


}
