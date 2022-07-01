package com.gabrielrossilopes.estabelecimentoapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gabrielrossilopes.estabelecimentoapp.model.Estabelecimento;
import com.gabrielrossilopes.estabelecimentoapp.model.Funcionario;
import com.gabrielrossilopes.estabelecimentoapp.service.EstabelecimentoService;

@Controller
public class EstabelecimentoController {

    @Autowired
    EstabelecimentoService estabelecimentoService;

    @GetMapping(value = "/estabelecimentos")
    public String telaListaEstabelecimentos(Model model){
        model.addAttribute("lista", estabelecimentoService.listarEstabelecimentos());
        return "estabelecimento/estabelecimentos";
    }

    @GetMapping(value = "/funcionarios/{id}")
    public String telaListFuncionarios(Model model, @PathVariable Integer id){
        Optional<Estabelecimento> estabelecimento = estabelecimentoService.listarEstabelecimentos()
                .stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();

        model.addAttribute("lista", estabelecimentoService.listarFuncionariosPorIdEstabelecimento(id));
        estabelecimento.ifPresent(value -> model.addAttribute("estabelecimento", value));
        return "funcionario/funcionarios";
    }

    @GetMapping(value = "/funcionario/{idFuncionario}/{idEstabelecimento}")
    public String excluirFuncionario(@PathVariable Integer idFuncionario, @PathVariable Integer idEstabelecimento){
        estabelecimentoService.excluir(idFuncionario);
        return "redirect:/funcionarios/" + idEstabelecimento;
    }

    @GetMapping(value = "/estabelecimento/excluir/{idEstabelecimento}")
    public String excluirEstabelecimento(@PathVariable Integer idEstabelecimento){
        estabelecimentoService.excluir(idEstabelecimento);
        return "redirect:/estabelecimentos";
    }

    @GetMapping(value = "/funcionario/incluir/{idEstabelecimento}")
    public String telaCadastroFuncionario(Model model, @PathVariable Integer idEstabelecimento){
        Funcionario funcionario = new Funcionario();

        Estabelecimento estabelecimento = estabelecimentoService.listarEstabelecimentos()
                .stream()
                .filter(e -> e.getId().equals(idEstabelecimento))
                .findFirst()
                .orElse(null);

        model.addAttribute("estabelecimento", estabelecimento);
        model.addAttribute("funcionario", funcionario);
        return "funcionario/cadastro";
    }

    @PostMapping(value = "/funcionario/incluir/{idEstabelecimento}")
    public String incluiFuncionario(Model model, Funcionario funcionario, @PathVariable Integer idEstabelecimento){
        Estabelecimento estabelecimento = estabelecimentoService.listarEstabelecimentos()
                .stream()
                .filter(e -> e.getId().equals(idEstabelecimento))
                .findFirst()
                .orElse(null);

        funcionario.setEstabelecimento(estabelecimento);

        estabelecimentoService.incluirFuncionario(funcionario);
        model.addAttribute("lista", estabelecimentoService.listarEstabelecimentos());
        return "redirect:/funcionarios/" + idEstabelecimento;
    }


    @GetMapping(value = "/estabelecimento")
    public String telaCadastroEstabelecimento(Model model){
        model.addAttribute("estabelecimento", new Estabelecimento());
        return "estabelecimento/cadastro";
    }


    @PostMapping(value = "/estabelecimento/incluir")
    public String incluiFuncionario(Estabelecimento estabelecimento){
        estabelecimentoService.incluirEstabelecimento(estabelecimento);
        return "redirect:/estabelecimentos";
    }

}
