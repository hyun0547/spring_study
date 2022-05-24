package com.example.demo.home;

import com.example.demo.model.TO.MemberTO;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/")
    public String homeView() {
        return "home";
    }

    @GetMapping("/login")
    public String loginView() {
        return "login";
    }

    @GetMapping("/signupPage")
    public String signupView() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(MemberTO memberTO) {
        memberService.save(memberTO);
        return "redirect:/login";
    }

    @PreAuthorize("hasRole('ROLE_MEMBER')")
    @GetMapping("/member/info")
    public String userInfoView() {
        return "user_info";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String adminView() {
        return "admin";
    }

    @GetMapping("/denied")
    public String deniedView() {
        return "denied";
    }
}