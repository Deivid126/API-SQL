package br.com.criandoAPI.projeto.service;

import java.util.List;

import org.springframework.stereotype.Service;
import br.com.criandoAPI.projeto.a.model.Usuario;
import br.com.criandoAPI.projeto.b.DAO.IUsuario;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class UsuarioService {
	
	private IUsuario repository;
	
	private PasswordEncoder passwordEncoder;
	
	public UsuarioService(IUsuario repository) {
		this.repository = repository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	public List<Usuario> ListarUsuario(){
		List<Usuario> lista = repository.findAll();
		return lista;
		
	}
	
	public Usuario criarUsuario(Usuario usuario) {
		String encoder =  this.passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encoder);
		Usuario usuarioNovo = repository.save(usuario);
		return usuarioNovo;
	}
	
	
	public Boolean excluirUsuario(Integer id) {
		repository.deleteById(id);
		return true;
		
	}
	

}
