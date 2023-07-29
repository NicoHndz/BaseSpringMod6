package com.secure.horizon.upload;

import java.sql.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.secure.horizon.model.Usuario;
import com.secure.horizon.repositories.UsersRepository;

@Component
public class UsersLoader implements ApplicationListener<ContextRefreshedEvent> {
	private UsersRepository usersRepository;
	private Logger log = LogManager.getLogger();

	@Autowired
	public void setAdvisoryRepository(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNombreUsuario("carla");
		usuario.setRun("12345678-K");
		usuario.setFechaNacimiento(Date.valueOf("1993-7-18"));
		usersRepository.save(usuario);
		log.info("SAVED" + usuario.getRun());
	}
}
