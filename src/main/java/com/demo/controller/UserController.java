package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.ResponseDTO;
import com.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping("/get")
	public  List<ResponseDTO> getAllUser() {
		return userService.getUser();
	}
	
	@PostMapping("/create")
	public  String CreateUser(@RequestParam("fname") String fname, @RequestParam("lname") String lname) {
		return userService.createUser(fname, lname);	
	}
}
