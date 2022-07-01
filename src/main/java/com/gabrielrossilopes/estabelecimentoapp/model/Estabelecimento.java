package com.gabrielrossilopes.estabelecimentoapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Estabelecimento extends Usuario {
    private String cnpj;
    private String endereco;
    private boolean edTech;
}
