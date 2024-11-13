package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;

@RestController
@RequestMapping(value = "/mylearning/")
public class MainController {

	@GetMapping("/requestparam")
	public void showRequestParamValue(@RequestParam(value = "firstName") String fisrtName) {
		System.out.println(fisrtName);
	}

	@GetMapping("/pathavariable/{id}")
	public void showPathVaribale(@PathVariable(value = "id") int id) {
		System.out.println(id);
	}

	@PostMapping("/requestbody")
	public void showPostMapping(@RequestBody User user) {
		System.out.println(user.getName() + " " + user.getEmail());
	}

	@PostMapping("/responsebody")
	public ResponseEntity<Boolean> returnResponseEnity(@RequestBody User user) {
		System.out.println(user.getName() + " " + user.getEmail());
		return ResponseEntity.status(HttpStatus.OK).body(true);
	}
}
