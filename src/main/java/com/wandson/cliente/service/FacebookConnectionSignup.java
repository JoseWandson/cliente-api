package com.wandson.cliente.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

import com.wandson.cliente.model.Usuario;
import com.wandson.cliente.repository.UsuarioRepository;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public String execute(Connection<?> connection) {
		Usuario usuario = new Usuario();
		usuario.setNome(connection.getDisplayName());
		usuario.setSenha(RandomStringUtils.randomAlphabetic(8));
		usuarioRepository.save(usuario);
		return usuario.getNome();
	}

}