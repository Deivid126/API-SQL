package br.com.criandoAPI.projeto.controler;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.criandoAPI.projeto.a.model.Usuario;
import br.com.criandoAPI.projeto.service.UsuarioService;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioControler{
	
	
	private UsuarioService usuarioService;
	
	public UsuarioControler (UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping
	 public ResponseEntity<List<Usuario>> listadeUsuarios() {
		return ResponseEntity.status(200).body(usuarioService.ListarUsuario());   
		}

	@PostMapping
	public ResponseEntity<Usuario> criarUsuario (@RequestBody Usuario usuario) {
		return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuario));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> exluirUsuario (@PathVariable Integer id) { 
		usuarioService.excluirUsuario(id);
		return ResponseEntity.status(204).build();
		
	}
	
	
}
