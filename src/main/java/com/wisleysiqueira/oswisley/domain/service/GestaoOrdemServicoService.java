package com.wisleysiqueira.oswisley.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisleysiqueira.oswisley.api.model.Comentario;
import com.wisleysiqueira.oswisley.domain.exception.EntidadeNaoEncontradaException;
import com.wisleysiqueira.oswisley.domain.exception.NegocioException;
import com.wisleysiqueira.oswisley.domain.model.Cliente;
import com.wisleysiqueira.oswisley.domain.model.OrdemServico;
import com.wisleysiqueira.oswisley.domain.model.StatusOrdemServico;
import com.wisleysiqueira.oswisley.domain.repository.ClienteRepository;
import com.wisleysiqueira.oswisley.domain.repository.ComentarioRepository;
import com.wisleysiqueira.oswisley.domain.repository.OrdemServicoRepository;

@Service
public class GestaoOrdemServicoService {
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	public OrdemServico criar(OrdemServico ordemServico) {
		
		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId()).orElseThrow(()-> new NegocioException("Cliente não encontrado"));
		
		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(OffsetDateTime.now());
		
		return ordemServicoRepository.save(ordemServico);
	}
	
	public Comentario adicionarComentario(Long ordemServicoID, String descricao) {
		
		OrdemServico ordemServico = ordemServicoRepository.findById(ordemServicoID)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de serviço não encontrada"));
		
		Comentario comentario = new Comentario();
		comentario.setDataEnvio(OffsetDateTime.now());
		comentario.setDescricao(descricao);
		comentario.setOrdemServico(ordemServico);
		
		return comentarioRepository.save(comentario);
	}
}
