package com.wandson.cliente.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@ConfigurationProperties("cliente")
public class ClienteApiProperty {

	@Setter
	private String originPermitida = "http://localhost:4200";

	private final Seguranca seguranca = new Seguranca();

	@Getter
	@Setter
	public static class Seguranca {
		private boolean enableHttps;
	}

}
