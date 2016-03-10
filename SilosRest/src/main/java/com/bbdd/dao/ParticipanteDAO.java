package com.bbdd.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.bbdd.dto.Participante;

public interface ParticipanteDAO {
	
	
	    public List<Participante> list();
	    //public String insertar (int punto,Participante participante);
	    public int id();
	    public Participante get(int id);
	    public String delete (int id);
	    public String update (Participante participante);
		String insertar(int punto, Date date, List listaDorsales) throws SQLException;
		String insertar1(Date date, List listaDorsales) throws SQLException;
		public List<Participante> listaPunto(String punto);
		public List<Participante> listaFinal(int dorsal, int i);
		public List<Integer> listaDorsalPunto(int punto);
		public String insertarSeparado(int punto, Date date, List listaDorsales) throws SQLException;
		public List<Participante> listaDirecto(int i, String dorsales) throws SQLException;
		public Participante buscarCategoria(Participante participante);
		public Participante ponerNombre(Participante participante);
		public Participante ponerPuntosIntermedios(Participante participante);
	

}
