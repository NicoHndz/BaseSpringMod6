package com.secure.horizon.services.servicesIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secure.horizon.model.Capacitacion;
import com.secure.horizon.repositories.TrainingsRepository;
import com.secure.horizon.services.TrainingsService;
@Service
public class TrainingServiceIMPL implements TrainingsService {

	private TrainingsRepository trainingsRepository;

	@Autowired
	public void setTrainingsRepository(TrainingsRepository trainingsRepository) {
		this.trainingsRepository = trainingsRepository;

	}

	@Override
	public Iterable<Capacitacion> listAllTrainings() {
		return trainingsRepository.findAll();
	}

	@Override
	public Capacitacion addTraining(Capacitacion capacitacion) {
		return trainingsRepository.save(capacitacion);
	}

	@Override
	public Capacitacion getTrainingById(int id) {

		return trainingsRepository.findById(id).orElse(null);
	}

	@Override
	public Capacitacion updateTraining(Capacitacion capacitacion) {
		return trainingsRepository.save(capacitacion);
	}

	@Override
	public void deleteTraining(int id) {
		trainingsRepository.deleteById(id);
	}

}
