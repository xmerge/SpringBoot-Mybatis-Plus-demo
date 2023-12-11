package com.example.demo.controller;

import com.example.demo.entity.DO.UsersDO;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author Xmerge
 * @since 2023-12-11
 */
@RestController
@RequestMapping("/demo/usersDO")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/add")
    public boolean addUser(@RequestBody UsersDO user) {
        return usersService.save(user);
    }

    @PutMapping("/update")
    public boolean updateUser(@RequestBody UsersDO user) {
        return usersService.updateById(user);
    }

    @GetMapping("/get")
    public UsersDO getUser(@RequestParam("id") String id) {
        return usersService.getById(id);
    }

    @GetMapping("/list")
    public List<UsersDO> listUsers() {
        return usersService.list();
    }
}
