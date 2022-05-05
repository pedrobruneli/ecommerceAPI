package com.estreet.security;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class AccountCredentialsVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preencha o campo username corretamente.")
	private String username;
	
	@NotEmpty(message = "Preencha o campo password correntamente.")
	private String password;

}
