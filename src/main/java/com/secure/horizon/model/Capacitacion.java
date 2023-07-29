package com.secure.horizon.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Capacitacion {
  // Atributos de la capacitación
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String runCliente;
  private Date fecha;
  private String hora;
  private String lugar;
  private String duracion;
  private int cantidadAsistentes;

  // Constructors
  public Capacitacion(int id, String runCliente, Date fecha, String hora, String lugar, String duracion,
		  int cantidadAsistentes) {
	  super();
	  this.id = id;
	  this.runCliente = runCliente;
	  this.fecha = fecha;
	  this.hora = hora;
	  this.lugar = lugar;
	  this.duracion = duracion;
	  this.cantidadAsistentes = cantidadAsistentes;
  }
  
  public Capacitacion(int id, String runCliente, String fecha, String hora, String lugar, String duracion,
		  int cantidadAsistentes) {
	  super();
	  Date modifiedDate = Date.valueOf(fecha);
	  this.id = id;
	  this.runCliente = runCliente;
	  this.fecha = modifiedDate;
	  this.hora = hora;
	  this.lugar = lugar;
	  this.duracion = duracion;
	  this.cantidadAsistentes = cantidadAsistentes;
  }
  
  public Capacitacion() {
	super();
}

//getters & setters
  public int getId() {
	  return id;
  }
  
  public void setId(int id) {
	  this.id = id;
  }
  
  public String getRunCliente() {
	  return runCliente;
  }
  
  public void setRunCliente(String runCliente) {
	  this.runCliente = runCliente;
  }
  
  public Date getFecha() {
	  return fecha;
  }
  
  public void setFecha(Date fecha) {
	  this.fecha = fecha;
  }
  
  public String getHora() {
	  return hora;
  }
  
  public void setHora(String hora) {
	  this.hora = hora;
  }
  
  public String getLugar() {
	  return lugar;
  }
  
  public void setLugar(String lugar) {
	  this.lugar = lugar;
  }
  
  public String getDuracion() {
	  return duracion;
  }
  
  public void setDuracion(String duracion) {
	  this.duracion = duracion;
  }
  
  public int getCantidadAsistentes() {
	  return cantidadAsistentes;
  }
  
  public void setCantidadAsistentes(int cantidadAsistentes) {
	  this.cantidadAsistentes = cantidadAsistentes;
  }
  

// Métodos específicos de la capacitación

  // Método para mostrar el detalle de la capacitación
  public void mostrarDetalle() {
    System.out.println("La capacitación será en " + lugar + " a las " + hora + " del día " + fecha + ", y durará "
        + duracion + " minutos.");
  }



  /*
   * Capacitación:
   * 
   * - Identificador: obligatorio, número interno de la capacitación manejado por
   * la empresa
   * - RUT cliente: obligatorio
   * - Día: texto, día de la semana. Debe ser un valor permitido entre “lunes” y
   * “Domingo” (en ese formato)
   * - Hora: debe ser una hora válida del día, en formato HH:MM (hora desde 0 a
   * 23, minutos entre 0 y 59)
   * - Lugar: obligatorio, mínimo 10 caracteres, máximo 50
   * - Duración: máximo 70 caracteres
   * - Cantidad de asistentes: obligatorio, número entero menor que 1000 Accidente
   * - Identificador del accidente: obligatorio, número interno manejado por la
   * compañía.
   * - RUT Cliente: obligatorio
   * - Día: fecha del accidente, independiente si lo declara como una fecha o un
   * String,
   * debe ser desplegado con el formato DD/MM/AAAA
   * - Hora: debe ser una hora válida del día, en formato HH:MM (hora desde 0 a
   * 23, minutos entre 0 y 59)
   * - Lugar: obligatorio, mínimo 10 caracteres, máximo 50
   * - Origen: máximo 100 caracteres
   * - Consecuencias: máximo 100 caracteres
   * 
   */

}
