package com.gabrielrossilopes.estabelecimentoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gabrielrossilopes.estabelecimentoapp.model.Usuario;
import com.gabrielrossilopes.estabelecimentoapp.repository.UsuarioRepository;



@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void incluir(Usuario usuario) {
		usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
		usuarioRepository.save(usuario);
	}
	
	public void excluir(Usuario usuario) {
		usuarioRepository.deleteById(usuario.getId());
	}
	
	public void excluirTudo() {
		usuarioRepository.deleteAll();
	}
	
	public List<Usuario> obterLista() {
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	public Usuario autenticar(String email, String senha) {
		
		Usuario usuarioRetornado = usuarioRepository.findByEmail(email);
		
		if(usuarioRetornado != null && usuarioRetornado.getSenha().equals(senha)){
			return usuarioRetornado;
		}
		
		return null;
	}

}
