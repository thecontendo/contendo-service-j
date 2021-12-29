package com.contendo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContendoController {

	@GetMapping("/create-user")
	public String craeteUser() {

		return "Greetings from Contendo!";
	}

}
