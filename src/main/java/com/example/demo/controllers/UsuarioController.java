package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	

	
	
}
