package com.gabrielrossilopes.estabelecimentoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielrossilopes.estabelecimentoapp.model.Role;
import com.gabrielrossilopes.estabelecimentoapp.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public void incluir(Role role) {
		roleRepository.save(role);
	}

	public List<Role> obterLista() {
		return (List<Role>) roleRepository.findAll();
	}

	public Role obterPorNome(String nome) {
		return roleRepository.findByNome(nome);
	}
	
	public void excluirTudo() {
		roleRepository.deleteAll();
	}
}
