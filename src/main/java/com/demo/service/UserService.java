package com.demo.service;

import java.util.List;

import com.demo.dto.ResponseDTO;

public interface UserService {

	public List<ResponseDTO> getUser();

	public String createUser(String fname, String lname);
}
