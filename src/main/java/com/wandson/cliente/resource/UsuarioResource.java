package com.wandson.cliente.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wandson.cliente.dto.UsuarioDTO;
import com.wandson.cliente.event.RecursoCriadoEvent;
import com.wandson.cliente.model.Usuario;
import com.wandson.cliente.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	public ResponseEntity<Usuario> criar(@Valid @RequestBody UsuarioDTO usuarioDTO, HttpServletResponse response) {
		Usuario usuario = usuarioService.criar(modelMapper.map(usuarioDTO, Usuario.class));

		publisher.publishEvent(new RecursoCriadoEvent(this, response, usuario.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	}

}
