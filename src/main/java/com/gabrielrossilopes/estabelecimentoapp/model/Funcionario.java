package com.gabrielrossilopes.estabelecimentoapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Funcionario extends Usuario {
    private static final long serialVersionUID = 1L;
	private String cpf;
    private String email;
    private String telefone;
    private Estabelecimento estabelecimento;
}
