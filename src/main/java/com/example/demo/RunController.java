package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RunController {
	
	@GetMapping("/api")
	public String Main() {
		return "connectddddd";
	}
	
	@GetMapping("/list")
	public List<User> listBoard() throws Exception {
		final UserDAO dao = new UserDAO();
		List<User> list = dao.getAll();
		return list;
	}
	
    @GetMapping("/data")
    public String handleRequest(@RequestParam String input) {
        return input;
    }
}
