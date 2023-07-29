package com.secure.horizon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.secure.horizon.model.Contacto;
import com.secure.horizon.services.ContactService;

@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;

	@RequestMapping("/contact")
	public String contactMain() {
		return "contacto/contactMain";
	}

	@RequestMapping("/contact/new")
	public String newContactForm(Model modelo) {
		Contacto contacto = new Contacto();
		modelo.addAttribute("contacto", contacto);
		return "contacto/newContact";
	}

	@PostMapping("/contact")
	public String newContact(@ModelAttribute("contacto") Contacto contacto) {
		contactService.addContact(contacto);
		return "redirect:/contact/list";
	}

	@RequestMapping("/contact/list")
	public String contactList(Model modelo) {
		modelo.addAttribute("contactos", contactService.listAllContacts());
		return "contacto/contactList";
	}

	@RequestMapping("/contact/edit/{id}")
	public String editContactForm(@PathVariable int id, Model modelo) {
		modelo.addAttribute("contacto", contactService.getContactById(id));
		return "contacto/editContact";
	}

	@PostMapping("/contact/{id}")
	public String editContact(@PathVariable int id, @ModelAttribute("contacto") Contacto contacto, Model modelo) {
		Contacto contactToEdit = contactService.getContactById(id);
		contactToEdit.setId(id);
		contactToEdit.setUserName(contacto.getUserName());
		contactToEdit.setMessage(contacto.getMessage());
		contactService.updateContact(contactToEdit);
		return "redirect:/contact/list";
	}

	@RequestMapping("/contact/delete/{id}")
	public String deleteContact(@PathVariable int id) {
		contactService.deleteContact(id);
		return "redirect:/contact/list";
	}

}
