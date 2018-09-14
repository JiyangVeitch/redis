package com.veitch.redis.controller;

import com.veitch.redis.pojo.User;
import com.veitch.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * jumpTo 开头的方法均为跳转页面,因为 WEB-INF下的jsp无法被href访问
     */
    @RequestMapping("goInsert")
    public String jumpToInsert() {
        return "insert";
    }

    @RequestMapping("index")
    public String jumpToIndex() {
        return "index";
    }

    @RequestMapping("success")
    public String jumpToSuccess() {
        return "success";
    }


    @RequestMapping("login")
    public String login(User user, Model model, HttpSession httpSession) {
        User userCheck = userService.login(user);
        if (userCheck != null) {
            httpSession.setAttribute("name", user.getName());
            return "success";
        } else {
            model.addAttribute("info", "账号或密码错误");
            return "index";
        }

    }

    @RequestMapping("select")
    public String select(Model model) {
        List<User> list = userService.selectAll();
        model.addAttribute("list", list);
        return "list";
    }


    @RequestMapping("insert")
    public String insert(User user, Model model) {
        userService.insertUser(user);
        model.addAttribute("info", "注册成功,3秒后跳转到登录页!");
        return "insert";
    }


    @RequestMapping("updateGet")
    public String updateGet(int id, Model model) {
        User user = userService.selectById(id);
        if (user != null) {
            model.addAttribute("user", user);
            return "update";
        } else {
            return "redirect:/select";
        }
    }

    @RequestMapping("updatePost")
    public String updatePost(User user) {
        userService.updateUser(user);
        return "redirect:/select";
    }

    @RequestMapping("delete")
    public String delete(int id) {
        userService.deleteById(id);
        return "redirect:/select";
    }

    @RequestMapping("off")
    public String off(HttpSession session) {
        session.invalidate();
        return "index";
    }

}
