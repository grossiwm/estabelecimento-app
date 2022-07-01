package com.gabrielrossilopes.estabelecimentoapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    private Integer id;
    private String login;
    private String nome;
    private String senha;
}
