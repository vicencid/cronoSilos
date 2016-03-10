package com.bbdd.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Participante implements Serializable{

	private static final long serialVersionUID = 1L;
	
	int id;
	String nombre;
	int dorsal;
	String punto;
	String fin;
	Date tiempo;
	Date tiempo1;
	Date tiempo2;
	Date tiempo3;
	Date tiempo4;
	Date tiempo5;
	Date tiempo6;
	List tiempos;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDorsal() {
		return dorsal;
	}
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	public Date getTiempo() {
		return tiempo;
	}
	public void setTiempo(Date tiempo) {
		this.tiempo = tiempo;
	}
	public String getPunto() {
		return punto;
	}
	public void setPunto(String punto) {
		this.punto = punto;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	public List getTiempos() {
		return tiempos;
	}
	public void setTiempos(List tiempos) {
		this.tiempos = tiempos;
	}
	public Date getTiempo1() {
		return tiempo1;
	}
	public void setTiempo1(Date tiempo1) {
		this.tiempo1 = tiempo1;
	}
	public Date getTiempo2() {
		return tiempo2;
	}
	public void setTiempo2(Date tiempo2) {
		this.tiempo2 = tiempo2;
	}
	public Date getTiempo3() {
		return tiempo3;
	}
	public void setTiempo3(Date tiempo3) {
		this.tiempo3 = tiempo3;
	}
	public Date getTiempo4() {
		return tiempo4;
	}
	public void setTiempo4(Date tiempo4) {
		this.tiempo4 = tiempo4;
	}
	public Date getTiempo5() {
		return tiempo5;
	}
	public void setTiempo5(Date tiempo5) {
		this.tiempo5 = tiempo5;
	}
	public Date getTiempo6() {
		return tiempo6;
	}
	public void setTiempo6(Date tiempo6) {
		this.tiempo6 = tiempo6;
	}
	
	

}
