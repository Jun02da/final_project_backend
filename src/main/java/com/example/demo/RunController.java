package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RunController {

	@GetMapping("/aaaa")
	public String AAA() {

		return "11111111";
	}
	
	@GetMapping("/apiaaa")
	public String Mainaaaaa() {

		return "1111111";
	}
	@GetMapping("/apii")
	public String Ma() {

		return "test";
	}
	@GetMapping("/api")
	public String Main() {

		return "connectddddddaaaaaaaa";
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