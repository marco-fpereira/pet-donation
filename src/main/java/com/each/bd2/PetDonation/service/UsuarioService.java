package com.each.bd2.PetDonation.service;

import com.each.bd2.PetDonation.config.Authorities;
import com.each.bd2.PetDonation.config.Users;
import com.each.bd2.PetDonation.dto.CadastroUsuarioDTO;
import com.each.bd2.PetDonation.entities.Adotante;
import com.each.bd2.PetDonation.entities.Responsavel;
import com.each.bd2.PetDonation.entities.Usuario;
import com.each.bd2.PetDonation.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


    @Autowired
    ResponsavelRepository responsavelRepository;

    @Autowired
    AdotanteRepository adotanteRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PetRepository petRepository;

    public Usuario findUsuarioById(Long id){
        return usuarioRepository.findById(id);
    }

    public Users findUsersById(String id){
        return usersRepository.findById(id);
    }

    public Usuario findByUsername(String username){
        return usuarioRepository.findByUsername(username);
    }

    @Transactional
    public Usuario saveUsuario(CadastroUsuarioDTO cadastroUsuarioDTO, Users user, Long id_endereco){

        Usuario usuario = cadastroUsuarioDTO.toUsuario();

        usuario.getEndereco().setId_endereco(id_endereco);
        usuario.setUser(user);

        usuarioRepository.save(usuario);
        return usuario;
    }

    @Transactional
    public Users saveUsers(CadastroUsuarioDTO cadastroUsuarioDTO){
        Users user = cadastroUsuarioDTO.toUsers();
        Authorities authorities = new Authorities(
                cadastroUsuarioDTO.getTipoUsuario().equalsIgnoreCase(
                "Responsavel") ? "RESPONSAVEL" : "ADOTANTE"
                );
        usersRepository.save(user);
        usersRepository.persistAuthority(authorities, user);
        return user;
    }

    @Transactional
    public void executeAdotanteSave(Usuario usuario){
        Adotante adotante = new Adotante(usuario.getNome(), usuario.getCpf(),
                usuario.getData_nasc(), usuario.getTelefone(), usuario.getEndereco(), 0.00);
        adotante.setId_usuario(usuarioRepository.getLastInsertId().longValue());
        adotanteRepository.save(adotante);
    }

    @Transactional
    public void executeResponsavelSave(Usuario usuario){
        Responsavel responsavel = new Responsavel(usuario.getNome(), usuario.getCpf(),
                usuario.getData_nasc(), usuario.getTelefone(), usuario.getEndereco());
        responsavel.setId_usuario(usuarioRepository.getLastInsertId().longValue());
        responsavelRepository.save(responsavel);
    }

}
