package com.secure.horizon.services;

import com.secure.horizon.model.Contacto;

public interface ContactService {

	public Iterable<Contacto> listAllContacts();
	
	public Contacto addContact(Contacto contacto);
	
	public Contacto getContactById(int id);
	
	public Contacto updateContact(Contacto contacto);
	
	public void deleteContact(int id);
}
