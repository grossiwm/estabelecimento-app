package com.gabrielrossilopes.estabelecimentoapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.gabrielrossilopes.estabelecimentoapp.model.Usuario;

@Controller
@SessionAttributes("user")
public class AppController {
	
    @GetMapping(value = "/")
    public String telaIndex() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String telaLogin() {
        return "login";
    }

    @GetMapping(value = "/negado")
    public String telaNegado() {
        return "negado";
    }

    @PostMapping(value = "/login")
    public String login(@AuthenticationPrincipal Usuario usuario, Model model) {
        return "redirect:/";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session, SessionStatus status) {
        status.setComplete();
        session.removeAttribute("user");
        return "redirect:/";
    }
	
}
