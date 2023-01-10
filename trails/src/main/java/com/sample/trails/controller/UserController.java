package com.sample.trails.controller;

import com.sample.trails.model.request.UserRequest;
import com.sample.trails.model.response.UserResponse;
import com.sample.trails.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
@Api(value = "User Application using soap")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userService) {
        this.userServiceImpl = userService;
    }

    @ApiOperation(value = "Save User Details")
    @PostMapping("/save-user")
    public UserResponse create(@RequestBody UserRequest userRequest){
        return userServiceImpl.createUser(userRequest);
    }

    @ApiOperation("Get User Details by Id")
    @GetMapping("/get-user{userId}")
    public UserResponse get(@PathVariable String userId){
        return userServiceImpl.getUser(userId);
    }

    @ApiOperation("Get User Details by Id")
    @PutMapping("/update-user")
    public UserResponse update(@RequestBody UserRequest userRequest){
        return userServiceImpl.updateUser(userRequest);
    }
}