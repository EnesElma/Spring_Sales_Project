package com.enes.user.controller;

import com.enes.user.entity.User;
import com.enes.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("create")
    public ResponseEntity<?> createUser(@RequestBody User user){
        return ResponseEntity.ok(userService.create(user));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<>("User delete successful", HttpStatus.ACCEPTED);
    }

    @GetMapping("listAll")
    public ResponseEntity<?> listAllUser(){
        return ResponseEntity.ok(userService.listAll());
    }

    @GetMapping("find/{id}")
    public ResponseEntity<?> findUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.findUser(id));
    }

}
