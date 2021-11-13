package com.LuanGabriel.polinomium;

import com.LuanGabriel.polinomium.domain.Usuario;
import com.LuanGabriel.polinomium.repository.UsuarioRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PolinomiumApplication {

	public static void main(String[] args) {

		SpringApplication.run(PolinomiumApplication.class, args);
		
		UsuarioRepository usuarioRepository;
	
		Usuario user = new Usuario();
		user.setNome("Luan");

		System.out.println("teste");
	
	}

}
