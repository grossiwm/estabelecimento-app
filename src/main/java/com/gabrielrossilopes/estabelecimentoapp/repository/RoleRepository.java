package com.gabrielrossilopes.estabelecimentoapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gabrielrossilopes.estabelecimentoapp.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{
	
	Role findByNome(String nome);
	
}
