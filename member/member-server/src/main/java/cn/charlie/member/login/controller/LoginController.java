package cn.charlie.member.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author charlie
 * @date 2/26/2023 10:39 AM
 **/
@RestController
@RequestMapping("/session")
public class LoginController {

    @GetMapping("")
    public String getSession() {
        return "hello world";
    }
}
