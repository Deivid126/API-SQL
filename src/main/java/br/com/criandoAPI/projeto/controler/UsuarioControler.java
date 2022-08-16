package br.com.criandoAPI.projeto.controler;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.criandoAPI.projeto.a.model.Usuario;
import br.com.criandoAPI.projeto.b.DAO.IUsuario;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioControler{
	
	@Autowired
	private IUsuario dao;
	
	@GetMapping
	 public List<Usuario> listadeUsuarios() {
        return (List<Usuario>) dao.findAll();
    }

	@PostMapping
	public Usuario criarUsuario (@RequestBody Usuario usuario) {
		Usuario usuarioNovo = dao.save(usuario);
		return usuarioNovo;
	}
	
	@PutMapping
	public Usuario editarUsuario (@RequestBody Usuario usuario) {
		Usuario usuarioNovo = dao.save(usuario);
		return usuarioNovo;
	}
	
	@DeleteMapping("/{id}")
	public Optional <Usuario> exluirUsuario (@PathVariable Integer id) { 
		Optional <Usuario> usuario = dao.findById(id);
		dao.deleteById(id);
		return usuario;
		
	}
	
	
}
