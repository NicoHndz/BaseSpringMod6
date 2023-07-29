package com.secure.horizon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.secure.horizon.model.Capacitacion;
import com.secure.horizon.services.TrainingsService;

@Controller
public class TrainingsController {
	@Autowired
	private TrainingsService trainingService;

	@RequestMapping("/trainings")
	public String trainingMain() {
		return "capacitaciones/trainingsMain";
	}

	@RequestMapping("/trainings/new")
	public String newTrainingForm(Model modelo) {
		Capacitacion capacitacion = new Capacitacion();
		modelo.addAttribute("capacitacion", capacitacion);
		return "capacitaciones/newTraining";
	}

	@PostMapping("/trainings")
	public String newUser(@ModelAttribute("usuario") Capacitacion usuario) {
		trainingService.addTraining(usuario);
		return "redirect:/trainings/list";
	}

	@RequestMapping("/trainings/list")
	public String trainingsList(Model modelo) {
		modelo.addAttribute("capacitaciones", trainingService.listAllTrainings());
		return "capacitaciones/trainingsList";
	}

	@RequestMapping("/trainings/edit/{id}")
	public String editUserForm(@PathVariable int id, Model modelo) {
		modelo.addAttribute("capacitacion", trainingService.getTrainingById(id));
		return "capacitaciones/editTraining";
	}

	@PostMapping("/trainings/{id}")
	public String editUser(@PathVariable int id, @ModelAttribute("capacitacion") Capacitacion capacitacion,
			Model modelo) {
		Capacitacion trainingToEdit = trainingService.getTrainingById(id);
		trainingToEdit.setId(id);
		trainingToEdit.setRunCliente(capacitacion.getRunCliente());
		trainingToEdit.setFecha(capacitacion.getFecha());
		trainingToEdit.setHora(capacitacion.getHora());
		trainingToEdit.setLugar(capacitacion.getLugar());
		trainingToEdit.setDuracion(capacitacion.getDuracion());
		trainingToEdit.setCantidadAsistentes(capacitacion.getCantidadAsistentes());
		trainingService.updateTraining(trainingToEdit);
		return "redirect:/trainings/list";
	}

	@RequestMapping("/trainings/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		trainingService.deleteTraining(id);
		return "redirect:/trainings/list";
	}

}
