package com.wisleysiqueira.oswisley.domain.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.wisleysiqueira.oswisley.domain.model.Cliente;
import com.wisleysiqueira.oswisley.domain.repository.ClienteRepository;

public class CadastroClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;	

	public Cliente salvar(Cliente cliente) {
			return clienteRepository.save(cliente);
	}
	
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
}
