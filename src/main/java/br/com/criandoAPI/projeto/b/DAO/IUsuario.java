package br.com.criandoAPI.projeto.b.DAO;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.criandoAPI.projeto.a.model.Usuario;

public interface IUsuario extends JpaRepository<Usuario , Integer> {
	
	
	
}