package com.gabrielrossilopes.estabelecimentoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielrossilopes.estabelecimentoapp.client.EstabelecimentoClient;
import com.gabrielrossilopes.estabelecimentoapp.model.Estabelecimento;
import com.gabrielrossilopes.estabelecimentoapp.model.Funcionario;
import com.gabrielrossilopes.estabelecimentoapp.model.Usuario;

@Service
public class EstabelecimentoService {
    @Autowired
    EstabelecimentoClient estabelecimentoClient;

    public List<Usuario> listarUsuarios(){
        return estabelecimentoClient.obterLista();
    }

    public Usuario validarUsuario(String login, String senha){
        return estabelecimentoClient.validar(login, senha);
    }

    public void excluir(Integer id){
        estabelecimentoClient.excluir(id);
    }

    public void incluirFuncionario(Funcionario funcionario){
        estabelecimentoClient.incluirFuncionario(funcionario);
    }

    public void incluirEstabelecimento(Estabelecimento estabelecimento){
        estabelecimentoClient.incluirEstabelecimento(estabelecimento);
    }

    public List<Funcionario> listarFuncionariosPorIdEstabelecimento(Integer id){
        return estabelecimentoClient.funcionariosPorEstabelecimento(id);
    }

    public List<Estabelecimento> listarEstabelecimentos(){
        return estabelecimentoClient.listarEstabelecimento();
    }

}
