package com.lsj.selfblog.selfblog.views;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/authticate")
    public void userAuthticate(@RequestParam(value = "username",required = false) String username, @RequestParam(value = "password",required = false) String password) {
        System.out.println(username+"--"+password);
    }
}
