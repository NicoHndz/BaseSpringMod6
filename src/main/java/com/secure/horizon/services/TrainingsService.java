package com.secure.horizon.services;

import com.secure.horizon.model.Capacitacion;

public interface TrainingsService {

	public Iterable<Capacitacion> listAllTrainings();
	
	public Capacitacion addTraining(Capacitacion capacitacion);
	
	public Capacitacion getTrainingById(int id);
	
	public Capacitacion updateTraining(Capacitacion capacitacion);
	
	public void deleteTraining(int id);
}
