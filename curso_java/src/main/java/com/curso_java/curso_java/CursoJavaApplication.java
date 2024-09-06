package com.curso_java.curso_java;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso_java.curso_java.Models.Rol;
import com.curso_java.curso_java.Models.Usuario;
import com.curso_java.curso_java.Models.UsuarioRol;
import com.curso_java.curso_java.Services.UsuarioService;

@SpringBootApplication
public class CursoJavaApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(CursoJavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Usuario usuario = new Usuario();

		// usuario.setNombres("Johan");
		// usuario.setApellidos("Hernandez");
		// usuario.setUsername("4rtemis");
		// usuario.setPassword("12345");
		// usuario.setEmail("hernandez.gomez292020@gmail.com");
		// usuario.setTelefono("3023671255");
		// usuario.setPerfil("foto.png");

		// Rol rol = new Rol();
		// rol.setRolId(1L);
		// rol.setNombre("ADMIN");

		// Set<UsuarioRol> usuarioRoles = new HashSet<>();
		// UsuarioRol usuarioRol = new UsuarioRol();
		// usuarioRol.setRol(rol);
		// usuarioRol.setUsuario(usuario);
		// usuarioRoles.add(usuarioRol);

		// Usuario usuarioSaved = usuarioService.saveUsuario(usuario, usuarioRoles);
		// System.out.println(usuarioSaved);

	}

}
