package com.lsj.selfblog.selfblog.views;

import java.util.HashMap;
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
import com.lsj.selfblog.selfblog.utils.JwtUtils;

@Controller
public class LoginController {

    private static String AUTH_RESULT = "authResult";

    @Autowired
    private SelfBlogUserService selfBlogUserService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/authticate")
    @ResponseBody
    public ResponseEntity<Map<String,String>> userAuthticate(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        boolean authResult = selfBlogUserService.authenBlogUser(username, password);
        String userToken = null;
        if(authResult) {
            userToken = selfBlogUserService.createUserToken(username);
        }

        Map<String,String> payload = new HashMap<>();
        payload.put(AUTH_RESULT, String.valueOf(authResult));
        payload.put(JwtUtils.FLG_USER_TOKEN, userToken);
        ResponseEntity<Map<String,String>> response = ResponseEntity.ok(payload);
        return response;
    }
}
