package com.gabrielrossilopes.estabelecimentoapp.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.gabrielrossilopes.estabelecimentoapp.model.Role;
import com.gabrielrossilopes.estabelecimentoapp.model.Usuario;
import com.gabrielrossilopes.estabelecimentoapp.service.RoleService;
import com.gabrielrossilopes.estabelecimentoapp.service.UsuarioService;

@Component
public class UsuarioRoleLoader implements ApplicationRunner {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		
		if (roleService.obterLista().isEmpty()) {
			roleService.incluir(new Role("ROLE_ADMIN"));
			roleService.incluir(new Role("ROLE_USER"));
		}
		

		if (usuarioService.obterLista().isEmpty()) {
			Usuario usuario1 = new Usuario();
			usuario1.setEmail("usuario1@usuario.com");
			usuario1.setNome("Usuario 1");
			usuario1.setRoles(Arrays.asList(roleService.obterLista().get(0)));
			usuario1.setSenha("senha1");
			
			usuarioService.incluir(usuario1);

			Usuario usuario2 = new Usuario();
			usuario2.setEmail("usuario2@usuario.com");
			usuario2.setNome("Usuario 2");
			usuario2.setRoles(Arrays.asList(roleService.obterLista().get(1)));
			usuario2.setSenha("senha2");
			
			usuarioService.incluir(usuario2);
		}
		
	}
	

}
