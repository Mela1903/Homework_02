package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(produces = "text/html; charset = UTF-8")
public class RedirectController {

    @GetMapping("/first")
    public String first() {
        return "first";
    }

    @GetMapping("/second")
    public String second() {
        return "redirect:third";
    }

    @GetMapping("/third")
    public String third() {
        return "third";
    }
}
