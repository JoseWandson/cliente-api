package com.wandson.cliente.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wandson.cliente.dto.ClienteDTO;
import com.wandson.cliente.event.RecursoCriadoEvent;
import com.wandson.cliente.model.Cliente;
import com.wandson.cliente.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Cliente> listar() {
		return clienteService.listar();
	}

	@PostMapping
	public ResponseEntity<Cliente> criar(@Valid @RequestBody ClienteDTO usuarioDTO, HttpServletResponse response) {
		Cliente usuario = clienteService.criar(modelMapper.map(usuarioDTO, Cliente.class));

		publisher.publishEvent(new RecursoCriadoEvent(this, response, usuario.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarPeloId(@PathVariable Long id) {
		return clienteService.buscarPeloId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		clienteService.remover(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody ClienteDTO usuarioDTO) {
		return ResponseEntity.ok(clienteService.atualizar(id, modelMapper.map(usuarioDTO, Cliente.class)));
	}

}
