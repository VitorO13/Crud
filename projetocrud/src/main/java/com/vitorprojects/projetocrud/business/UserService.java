package com.vitorprojects.projetocrud.business;

import com.vitorprojects.projetocrud.infrastructure.entitys.User;
import com.vitorprojects.projetocrud.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final  UserRepository repository;

    public UserService(UserRepository repository){
        this.repository= repository;
    }

    public void saveUser (User usuario){
        repository.saveAndFlush(usuario);
    }

    public User searchUserEmail(String email){

        return repository.findByEmail(email).orElseThrow(
                ()-> new RuntimeException("Email não encontrado"));

    }

    public void deletarPorEmail(String email){
        repository.deleteByEmail(email);
    }

    public void atualizarUsuarioPorId(Integer id, Integer celular,User usuario){
        User usuarioEntity= repository.findById(id).orElseThrow(() ->
            new RuntimeException("usuario não encontrado"));

        User usuarioAtualizado = User.builder()
                .email(usuario.getEmail()!= null ? usuario.getEmail() :
                        usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome():
                        usuarioEntity.getNome()).id(usuario.getId())
                .celular(usuario.getCelular() != null ? usuario.getCelular():
                        usuarioEntity.getCelular())
        .build();
        repository.saveAndFlush(usuarioAtualizado);
    }

}

//orElseTrow não retornar porra nenhuma
// orElse não achou o email retorna um user vazio
//orElseTrow e possivel retornar uma exceptiption personalizada

//se ele for diferente de nulo eu preencho o email com outro email
//se não vai preencher com o email que foi buscado na entity, msm coisa para o nome


