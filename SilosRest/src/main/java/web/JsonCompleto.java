package web;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class JsonCompleto {

	
	@SerializedName("Clasificacion")
    private ArrayList <Participante> participantes;

	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}
}
