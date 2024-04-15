package com.example.webAppUserLogin.controller;

import com.example.webAppUserLogin.model.UserDtls;
import com.example.webAppUserLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String index(){
        return "index";
    }
//this signin exactly same as basepage.html
// <li class="nav-item"><a class="nav-link" href="signin">Login</a></li>
    @GetMapping("/signin")
    public String login(){

        return "login";
//        this return login is same as login.html
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    // this is # 1 and 2
//    @PostMapping("/createUsers")
//    public String usersDetails(@ModelAttribute UserDetails user){
        //System.out.println(user);
        /* 1.this is first time we can do that way
        UserDetails userDetails = userService.createUser(user);
        if(userDetails != null) {
            System.out.println("Register Successfully");
        }
        else {
            System.out.println("something error in server");
        }
        */

        //2.  this is the second way to do that
        /* boolean check = userService.checkEmail(user.getEmail());
        if(check) {
            System.out.println("Email is already exist");
        }
        else {
            UserDetails userDetails = userService.createUser(user);
            if (userDetails != null) {
                System.out.println("Register Successfully");
            } else {
                System.out.println("something error in server");
            }
        } */
        // 3.this is the third way to do that !!!, then I need to fetch/ type from the register.html
        //                    <th:block th:if="${session.msg}">
        //                        <p class="text-center fs-4">[[${session.msg}]]</p>
        //                    </th:block>

        @PostMapping("/createUsers")
    public String usersDetails(@ModelAttribute UserDtls user, HttpSession session){

            boolean check = userService.checkEmail(user.getEmail());
        if(check) {
            session.setAttribute("msg","Email Id already exists");
        }
        else {
            UserDtls userDtls = userService.createUser(user);
            if (userDtls != null) {
                session.setAttribute("msg","Register Successfully");
            } else {
                session.setAttribute("msg","something error in server");
            }
        }

        return "redirect:/register";
    }

}
