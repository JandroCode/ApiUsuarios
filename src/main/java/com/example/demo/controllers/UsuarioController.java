package com.example.demo.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.dao.IUsuarioDAO;
import com.example.demo.models.entities.Usuario;

@RestController
@RequestMapping("/api")
@CrossOrigin({"*"})
public class UsuarioController {
	
	@Autowired
	private IUsuarioDAO usuarioDAO;
	
	@PostMapping("/save")
	public void save(@RequestBody Usuario usuario) {
		usuarioDAO.save(usuario);
	}
	
	@GetMapping("/list")
	public List<Usuario> list(){
		return usuarioDAO.findAll();
	}
	
	@GetMapping("/{id}")
	public Usuario getUser(@PathVariable(name = "id")Long id) {
		return usuarioDAO.findById(id).orElse(null);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable Long id){
		usuarioDAO.deleteById(id);
	}
	
	@PutMapping("/update/{id}")
	public Usuario updateUser(Usuario usuario, @PathVariable Long id) {
		Usuario nuevoUsuario = usuarioDAO.findById(id).orElse(null);
		nuevoUsuario.setNombre(usuario.getNombre());
		nuevoUsuario.setApellidos(usuario.getApellidos());
		nuevoUsuario.setEmail(usuario.getEmail());
		nuevoUsuario.setTelefono(usuario.getTelefono());
		
		return nuevoUsuario;
		
	
	}
	
	

	
	
}
