package com.gabrielrossilopes.estabelecimentoapp.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gabrielrossilopes.estabelecimentoapp.model.Role;
import com.gabrielrossilopes.estabelecimentoapp.model.Usuario;
import com.gabrielrossilopes.estabelecimentoapp.service.RoleService;
import com.gabrielrossilopes.estabelecimentoapp.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping(value="/usuario")
	public String telaCadastro(Model model) {
		
		model.addAttribute("roles", roleService.obterLista());
		
		return "usuario/cadastro";
	}
	
	@PostMapping(value="/usuario/incluir")
	public String incluir(Usuario usuario, @RequestParam Integer acesso) {
		
		usuario.setRoles(Arrays.asList(new Role(acesso)));
		usuarioService.incluir(usuario);
		
		return "redirect:/";
	}

}
