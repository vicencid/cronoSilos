package web;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Participante implements Serializable{
	
	
	@SerializedName("Dorsal")
    private String Dorsal;
	
	@SerializedName("Nombre")
    private String Nombre;
	
	String punto;
	String Fin;
	@SerializedName("Tiempo")
	private  String Tiempo;
	private String Tiempo1;
	private String Tiempo2;
	private String Tiempo3;
	private String Tiempo4;
	private String Tiempo5;
	private String Tiempo6;
	private List Tiempos;

	public String getDorsal() {
		return Dorsal;
	}

	public void setDorsal(String dorsal) {
		Dorsal = dorsal;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getPunto() {
		return punto;
	}

	public void setPunto(String punto) {
		this.punto = punto;
	}

	public String getFin() {
		return Fin;
	}

	public void setFin(String Fin) {
		this.Fin = Fin;
	}

	public String getTiempo() {
		return Tiempo;
	}

	public void setTiempo(String Tiempo) {
		this.Tiempo = Tiempo;
	}

	public String getTiempo1() {
		if(Tiempo1==null)
			return "";
		
		return Tiempo1;
	}

	public void setTiempo1(String Tiempo1) {
		this.Tiempo1 = Tiempo1;
	}

	public String getTiempo2() {
		if(Tiempo2==null)
			return "";
		
		return Tiempo2;
	}

	public void setTiempo2(String Tiempo2) {
		this.Tiempo2 = Tiempo2;
	}

	public String getTiempo3() {
		if(Tiempo3==null)
			return "";
		
		return Tiempo3;
	}

	public void setTiempo3(String Tiempo3) {
		this.Tiempo3 = Tiempo3;
	}

	public String getTiempo4() {
		if(Tiempo4==null)
			return "";
		
		return Tiempo4;
	}

	public void setTiempo4(String Tiempo4) {
		this.Tiempo4 = Tiempo4;
	}

	public String getTiempo5() {
		if(Tiempo5==null)
			return "";
		
		return Tiempo5;
	}

	public void setTiempo5(String Tiempo5) {
		this.Tiempo5 = Tiempo5;
	}

	public String getTiempo6() {
		if(Tiempo6==null)
			return "";
		
		return Tiempo6;
	}

	public void setTiempo6(String Tiempo6) {
		this.Tiempo6 = Tiempo6;
	}

	public List getTiempos() {
		return Tiempos;
	}

	public void setTiempos(List Tiempos) {
		this.Tiempos = Tiempos;
	}

}
