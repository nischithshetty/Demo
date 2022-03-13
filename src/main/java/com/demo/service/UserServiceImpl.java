package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.ResponseDTO;
import com.demo.entity.UserEntity;
import com.demo.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Override
	public List<ResponseDTO> getUser() {
		List<ResponseDTO> responseList = new ArrayList<ResponseDTO>();

		List<UserEntity> user = userRepo.findAll();
		user.forEach(u -> {
			ResponseDTO response = new ResponseDTO();
			response.setFname(u.getFname());
			response.setLname(u.getLname());
			responseList.add(response);
		});
		return responseList;
	}

	@Override
	public String createUser(String fname, String lname) {
		try {
			UserEntity user = new UserEntity();
			user.setFname(fname);
			user.setLname(lname);
			userRepo.save(user);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "success";
	}

}
