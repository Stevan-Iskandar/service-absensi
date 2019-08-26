package com.example.Ujian4;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ujian4.controller.Controller;
import com.example.Ujian4.model.User;

@RestController
public class ServiceController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/helloworld")
	public String HelloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path = "/user/adduser/")
	public void addUser() {
		Controller.getInstance().addUser();
	}
	
	@GetMapping(path = "/user/getalluser/")
	public List<User> getAllUser() {
		return new ArrayList<User>(Controller.getInstance().getAllUser());
	}
	
	@GetMapping(path = "/user/search/{nama}")
	public List<User> searchNamaAnggota(@PathVariable String nama) {
		return new ArrayList<User>(Controller.getInstance().searchNameUser(nama));
	}
}