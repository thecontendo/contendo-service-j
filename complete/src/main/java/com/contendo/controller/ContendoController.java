package com.contendo.controller;

import com.contendo.service.ContendoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContendoController {

    @Autowired
    private ContendoService contendoService;

	@GetMapping("/access-token")
	@ResponseBody
	public String graph(
			@RegisteredOAuth2AuthorizedClient("graph") OAuth2AuthorizedClient graphClient
	) throws JsonProcessingException {
		// oAuth2AuthorizedClient contains access_token. We can use this access_token to access the resource server.
		return graphClient.getAccessToken().getTokenValue();
	}

    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity createUser() {
        contendoService.createUser();
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping(value = "/invite")
    public void sendInvite(){
        contendoService.sendInvite("xyz");
    }

}
