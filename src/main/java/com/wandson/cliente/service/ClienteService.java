package com.wandson.cliente.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.wandson.cliente.model.Cliente;
import com.wandson.cliente.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	public Cliente criar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Optional<Cliente> buscarPeloId(Long id) {
		return clienteRepository.findById(id);
	}

	public void remover(Long id) {
		clienteRepository.deleteById(id);
	}

	public Cliente atualizar(Long id, Cliente cliente) {
		Cliente clienteSalvo = buscarClientePeloId(id);
		BeanUtils.copyProperties(cliente, clienteSalvo, "id");
		return clienteRepository.save(clienteSalvo);
	}

	private Cliente buscarClientePeloId(Long id) {
		return buscarPeloId(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

}
