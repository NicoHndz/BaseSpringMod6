package com.secure.horizon.services.servicesIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.secure.horizon.model.Contacto;
import com.secure.horizon.repositories.ContactRepository;
import com.secure.horizon.services.ContactService;

@Service
public class ContactServiceIMPL implements ContactService {

	private ContactRepository contactRepository;

	@Autowired
	public void setContactRepository(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;

	}

	@Override
	public Iterable<Contacto> listAllContacts() {
		return contactRepository.findAll();
	}

	@Override
	public Contacto addContact(Contacto contacto) {
		return contactRepository.save(contacto);
	}

	@Override
	public Contacto getContactById(int id) {

		return contactRepository.findById(id).orElse(null);
	}

	@Override
	public Contacto updateContact(Contacto contacto) {
		return contactRepository.save(contacto);
	}

	@Override
	public void deleteContact(int id) {
		contactRepository.deleteById(id);
	}

}
