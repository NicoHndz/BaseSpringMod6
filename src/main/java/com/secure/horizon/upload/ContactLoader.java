package com.secure.horizon.upload;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.secure.horizon.model.Contacto;
import com.secure.horizon.repositories.ContactRepository;

@Component
public class ContactLoader implements ApplicationListener<ContextRefreshedEvent> {
	private ContactRepository contactRepository;
	private Logger log = LogManager.getLogger();

	@Autowired
	public void setAdvisoryRepository(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Contacto contacto = new Contacto();
		contacto.setId(1);
		contacto.setUserName("Andres");
		contacto.setMessage("Hola, este es un mensaje de prueba");
		contactRepository.save(contacto);
		log.info("SAVED" + contacto.getId());
	}
}
