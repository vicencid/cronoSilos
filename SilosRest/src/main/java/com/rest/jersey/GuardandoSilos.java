package com.rest.jersey;


import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.bbdd.dao.ParticipanteDAO;
import com.bbdd.dao.impl.ParticipanteDAOImpl;
import com.bbdd.dto.Participante;

@Path("/guardandoSilos")
public class GuardandoSilos{
	
	@GET
    @Path("/{parameter}")
	public Response responseMsg( @PathParam("parameter") String parameter,	
            @DefaultValue("Nothing to say") @QueryParam("value") String value) throws SQLException {

		int punto=0;
		
        String output= "";
        ParticipanteDAO participanteDAO;
        ArrayList listaDorsales=new ArrayList();
        
        participanteDAO = new ParticipanteDAOImpl();
        
        
        Participante participante = new Participante();
        String[] parts = value.split(",");
        
        punto=Integer.parseInt(parts[0]);
        
        listaDorsales=generarListaDorsal(parts);
        
        
        Date date = new Date();
        date=restarMinutos(date, 540);
        
        
        participante.setTiempo(date);
        
        
        	//participanteDAO.insertar(punto,date,listaDorsales);
        	//participanteDAO.insertar1(date,listaDorsales);
        	participanteDAO.insertarSeparado(punto, date, listaDorsales);
       
        
       
        return Response.status(200).entity(output).build();
        
	}
	
	public static synchronized java.util.Date restarMinutos(java.util.Date fch, int minutos) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.MINUTE, -minutos);
        return new java.util.Date(cal.getTimeInMillis());
    }
	
	public ArrayList generarListaDorsal(String[]lista){
		ArrayList listaDorsales=new ArrayList();
		for(int i=0;i<lista.length;i++){
        	if(i==0){
        		
        	}else{
        		listaDorsales.add(lista[i]);
        	}
		}
		return listaDorsales;
	}

}
