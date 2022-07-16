package br.com.CPFVerify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.CPFVerify.enums.CPFStatus;
import br.com.CPFVerify.model.CPF;
import br.com.CPFVerify.service.CPFVerifyService;

@RequestMapping
@RestController
public class IndexController {
	
	@Autowired
	CPFVerifyService cpfVeriyService;
	
	@CrossOrigin
	@PostMapping(value = "/verify", produces = "application/json")
	public CPFStatus cpfVerify(@RequestBody CPF cpfParam) {
		
		CPF cpf = new CPF();
		
		cpf.setCpfNumber(cpfParam.getCpfNumber());
		
		cpfVeriyService.verify(cpf);
		
		return cpf.getCpfStatus();
		
	}

}