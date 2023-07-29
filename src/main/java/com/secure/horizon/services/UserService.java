package com.secure.horizon.services;

import com.secure.horizon.model.Usuario;

public interface UserService {

	public Iterable<Usuario> listAllUsers();
	
	public Usuario addUser(Usuario usuario);
	
	public Usuario getUsuarioById(int id);
	
	public Usuario updateUsuario(Usuario usuario);
	
	public void deleteUser(int id);
}
