package com.gabrielrossilopes.estabelecimentoapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Estabelecimento extends Usuario {
    private static final long serialVersionUID = 1L;
	private String cnpj;
    private String endereco;
    private boolean edTech;
}
