package br.com.criandoAPI.projeto.b.DAO;

import org.springframework.data.repository.CrudRepository;

import br.com.criandoAPI.projeto.a.model.Usuario;

public interface IUsuario extends CrudRepository<Usuario , Integer> {
	
	
	
}