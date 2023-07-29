package com.secure.horizon.services.servicesIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secure.horizon.model.Usuario;
import com.secure.horizon.repositories.UsersRepository;
import com.secure.horizon.services.UserService;

@Service
public class UserServiceIMPL implements UserService {

	private UsersRepository usersRepository;

	@Autowired
	public void setUsersRepository(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;

	}

	@Override
	public Iterable<Usuario> listAllUsers() {
		return usersRepository.findAll();
	}

	@Override
	public Usuario addUser(Usuario usuario) {
		return usersRepository.save(usuario);
	}

	@Override
	public Usuario getUsuarioById(int id) {

		return usersRepository.findById(id).orElse(null);
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		return usersRepository.save(usuario);
	}

	@Override
	public void deleteUser(int id) {
		usersRepository.deleteById(id);
	}

}
