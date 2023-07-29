package com.secure.horizon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.secure.horizon.model.Usuario;
import com.secure.horizon.services.UserService;

@Controller
public class UsersController {
	@Autowired
	private UserService userService;

	@RequestMapping("/users")
	public String userMain() {
		return "usuarios/usersMain";
	}

	@RequestMapping("/users/new")
	public String newUserForm(Model modelo) {
		Usuario usuario = new Usuario();
		modelo.addAttribute("usuario", usuario);
		return "usuarios/newUser";
	}

	@PostMapping("/users")
	public String newUser(@ModelAttribute("usuario") Usuario usuario) {
		userService.addUser(usuario);
		return "redirect:/users/list";
	}

	@RequestMapping("/users/list")
	public String usersList(Model modelo) {
		modelo.addAttribute("usuarios", userService.listAllUsers());
		return "usuarios/usersList";
	}

	@RequestMapping("/users/edit/{id}")
	public String editUserForm(@PathVariable int id, Model modelo) {
		modelo.addAttribute("usuario", userService.getUsuarioById(id));
		return "usuarios/editUser";
	}

	@PostMapping("/users/{id}")
	public String editUser(@PathVariable int id, @ModelAttribute("usuario") Usuario usuario, Model modelo) {
		Usuario userToEdit = userService.getUsuarioById(id);
		userToEdit.setId(id);
		userToEdit.setNombreUsuario(usuario.getNombreUsuario());
		userToEdit.setRun(usuario.getRun());
		userToEdit.setFechaNacimiento(usuario.getFechaNacimiento());
		userService.updateUsuario(userToEdit);
		return "redirect:/users/list";
	}

	@RequestMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		return "redirect:/users/list";
	}

}
