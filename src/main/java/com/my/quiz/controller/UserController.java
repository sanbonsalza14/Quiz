package com.my.quiz.controller;

import com.my.quiz.dto.UserDto;
import com.my.quiz.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }


    @GetMapping("login")
    public String loginForm() { return "/user/login"; }


    @GetMapping("signup")
    public String signupForm(Model model) {
        model.addAttribute("user", new UserDto()); return "/user/signup"; }


    @PostMapping("signup")
    public String signup(@ModelAttribute("user") UserDto dto) {
        userService.saveUser(dto); return "redirect:/"; }


    @GetMapping("list")
    public String userList(Model model) { List<UserDto> list = userService.findAllUser(); model.addAttribute("list", list); return "/user/userList"; }


    @PostMapping("delete")
    public String userDelete(@RequestParam("email") String email) {
        userService.deleteUser(email); return "redirect:/user/list"; }


    @PostMapping("update")
    public String updateUserForm(@RequestParam("email") String email, Model model) {
        UserDto user = userService.findOneUser(email); model.addAttribute("user", user); return "/user/userUpdate"; }


    @PostMapping("updateUser")
    public String updateUser(@ModelAttribute("user") UserDto user) {
        userService.saveUser(user); return "redirect:/user/list"; }


    @PostMapping("login")
    public String login(UserDto dto, HttpSession session) {
        UserDto loginResult = userService.findOneUser(dto.getEmail());
        if (ObjectUtils.isEmpty(loginResult)) return "/user/login";
        else if (dto.getPassword().equals(loginResult.getPassword())) {
            session.setAttribute("loginEmail", dto.getEmail());
            session.setMaxInactiveInterval(60 * 30);
            return "redirect:/";
        } else { return "/user/login"; }
    }


    @GetMapping("logout")
    public String logout(HttpSession session) { session.invalidate(); return "main"; }


    @GetMapping("myInfo")
    public String myInfo(HttpSession session, Model model) {
        String myEmail = session.getAttribute("loginEmail").toString();
        UserDto user = userService.findOneUser(myEmail);
        model.addAttribute("user", user); return "/user/userUpdate"; }


    @GetMapping("myPage")
    public String myPaag() { return "/user/myPage"; }
}