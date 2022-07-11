package com.gabrielrossilopes.estabelecimentoapp.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gabrielrossilopes.estabelecimentoapp.repository.UsuarioRepository;

@Service
public class CustomAuthProvider implements AuthenticationProvider {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
	    String username = auth.getName();
	    String password = auth.getCredentials().toString();

	    UserDetails user = usuarioRepository.findByEmail(username);
	    if (user == null) {
	      throw new BadCredentialsException("invalid_username_or_pass");
	    }

	    if (!passwordEncoder.matches(password, user.getPassword())) {
	      throw new BadCredentialsException("invalid_username_or_pass");
	    }

	    return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
