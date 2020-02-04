package com.wandson.cliente.security;

import java.util.HashSet;

import org.springframework.security.core.userdetails.User;

import com.wandson.cliente.model.Usuario;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
public class UsuarioSistema extends User {

	private static final long serialVersionUID = 1L;

	@Getter
	private Usuario usuario;

	public UsuarioSistema(Usuario usuario) {
		super(usuario.getEmail(), usuario.getSenha(), new HashSet<>());
		this.usuario = usuario;
	}

}
