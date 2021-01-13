package com.wisleysiqueira.oswisley.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wisleysiqueira.oswisley.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("João");
		cliente1.setTelefone("11 98765-4321");
		cliente1.setEmail("joaoteste@oswisley.com");
		
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Maria");
		cliente2.setTelefone("11 99999-9999");
		cliente2.setEmail("mariateste@oswisley.com");
		
		return Arrays.asList(cliente1, cliente2);
	}
}
