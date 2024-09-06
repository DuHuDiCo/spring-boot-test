package com.curso_java.curso_java.Services;

import java.util.Set;

import com.curso_java.curso_java.Models.Usuario;
import com.curso_java.curso_java.Models.UsuarioRol;

public interface UsuarioService {
    public Usuario saveUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario getOneUser(String username);

    public void deleteOneUser(Long usuarioId);

}
