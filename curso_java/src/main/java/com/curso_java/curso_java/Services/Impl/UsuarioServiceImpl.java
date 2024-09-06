package com.curso_java.curso_java.Services.Impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso_java.curso_java.Models.Usuario;
import com.curso_java.curso_java.Models.UsuarioRol;
import com.curso_java.curso_java.Repository.RolRepository;
import com.curso_java.curso_java.Repository.UsuarioRepository;
import com.curso_java.curso_java.Services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final RolRepository rolRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, RolRepository rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    @Override
    public Usuario saveUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if (usuarioLocal != null) {
            System.out.println("Usuario: " + usuario + "Ya existe");
            throw new Exception("Usuario Existente");
        } else {
            for (UsuarioRol usuarioRol : usuarioRoles) {
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario getOneUser(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void deleteOneUser(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

}
