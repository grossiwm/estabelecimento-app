package com.gabrielrossilopes.estabelecimentoapp.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.gabrielrossilopes.estabelecimentoapp.model.Estabelecimento;
import com.gabrielrossilopes.estabelecimentoapp.model.Funcionario;
import com.gabrielrossilopes.estabelecimentoapp.model.Usuario;

@FeignClient(url = "${estabelecimento-api.url}", name = "estabelecimentoClient")
public interface EstabelecimentoClient {
    @GetMapping("/usuario/listar")
    List<Usuario> obterLista();

    @DeleteMapping("usuario/{id}/excluir")
    void excluir(@PathVariable Integer id);

    @PostMapping("usuario/validar")
    Usuario validar(@RequestParam String login, @RequestParam String senha);

    @PostMapping("funcionario/incluir")
    void incluirFuncionario(@RequestBody Funcionario funcionario);

    @GetMapping("funcionario/{idEstabelecimento}/listar")
    List<Funcionario> funcionariosPorEstabelecimento(@PathVariable Integer idEstabelecimento);

    @PostMapping("estabelecimento/incluir")
    void incluirEstabelecimento(@RequestBody Estabelecimento estabelecimento);

    @GetMapping("estabelecimento/listar")
    List<Estabelecimento> listarEstabelecimento();
}
