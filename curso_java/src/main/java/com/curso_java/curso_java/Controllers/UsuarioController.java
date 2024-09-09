package com.curso_java.curso_java.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso_java.curso_java.Models.Rol;
import com.curso_java.curso_java.Models.Usuario;
import com.curso_java.curso_java.Models.UsuarioRol;
import com.curso_java.curso_java.Services.UsuarioService;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioService = usuarioService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/")
    public Usuario saveUser(@RequestBody Usuario usuario) throws Exception {
        usuario.setPerfil("foto.png");

        usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));

        Set<UsuarioRol> roles = new HashSet<>();

        Rol rol = new Rol();

        rol.setRolId(2L);
        rol.setNombre("NORMAL");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);
        roles.add(usuarioRol);

        return usuarioService.saveUsuario(usuario, roles);
    }

    @GetMapping("/{username}")
    public Usuario getUsuario(@PathVariable("username") String Username) {
        return usuarioService.getOneUser(Username);
    }

    @DeleteMapping("/{usuarioId}")
    public void deleteUser(@PathVariable("usuarioId") Long usuarioId) {
        usuarioService.deleteOneUser(usuarioId);
    }

}
