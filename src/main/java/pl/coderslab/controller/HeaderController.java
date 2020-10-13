package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(produces = "text/html; charset = UTF-8")
public class HeaderController {

    @GetMapping("/showUserAgent/{userAgent}")
    public String userAgent(@RequestHeader("user-agent") String userAgent, Model m){
        m.addAttribute("userAgent", userAgent);
        return "userAgent";
    }
}
