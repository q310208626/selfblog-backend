package com.lsj.selfblog.selfblog.views;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lsj.selfblog.selfblog.service.SelfBlogUserService;

@Controller
public class LoginController {

    @Autowired
    private SelfBlogUserService selfBlogUserService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/authticate")
    @ResponseBody
    public ResponseEntity<Boolean> userAuthticate(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        boolean authResult = selfBlogUserService.authenBlogUser(username, password);
        ResponseEntity<Boolean> response = ResponseEntity.ok(authResult);
        return response;
    }
}
