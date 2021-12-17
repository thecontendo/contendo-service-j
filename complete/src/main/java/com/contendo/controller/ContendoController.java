package com.contendo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContendoController {

	@GetMapping("/")
	public String index() {
		return "Greetings from Contendo!";
	}

}
