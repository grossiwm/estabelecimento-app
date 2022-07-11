package com.gabrielrossilopes.estabelecimentoapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TRole")
@Getter
@Setter
public class Role implements GrantedAuthority {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@ManyToMany(mappedBy = "roles")
	private List<Usuario> usuarios;

	public Role() {
		
	}
	
	public Role(String nome) {
		super();
		this.nome = nome;
	}
	
	public Role(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String getAuthority() {
		return this.nome;
	}
}
