package com.secure.horizon.upload;

import java.sql.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.secure.horizon.model.Capacitacion;
import com.secure.horizon.repositories.TrainingsRepository;

@Component
public class TrainingsLoader implements ApplicationListener<ContextRefreshedEvent> {
	private TrainingsRepository trainingsRepository;
	private Logger log = LogManager.getLogger();

	@Autowired
	public void setAdvisoryRepository(TrainingsRepository trainingsRepository) {
		this.trainingsRepository = trainingsRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Capacitacion capacitacion = new Capacitacion();
		capacitacion.setId(1);
		capacitacion.setRunCliente("12.345.678-9");
		capacitacion.setFecha(Date.valueOf("1999-12-28"));
		capacitacion.setHora("10:10");
		capacitacion.setLugar("Oficina 200");
		capacitacion.setDuracion("2 dias");
		capacitacion.setCantidadAsistentes(20);
		trainingsRepository.save(capacitacion);
		log.info("SAVED" + capacitacion.getRunCliente());
	}
}
