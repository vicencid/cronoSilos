package com.rest.jersey;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.bbdd.dao.ParticipanteDAO;
import com.bbdd.dao.impl.ParticipanteDAOImpl;
import com.bbdd.dto.Participante;

@Path("/clasificacionPunto")
public class ClasificacionPunto{
	
	@GET
    @Path("/{parameter}")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject responseMsg( @PathParam("parameter") String parameter,	
            @DefaultValue("Nothing to say") @QueryParam("value") String value) {

		String punto= value;
        ParticipanteDAO participanteDAO;
        ArrayList listaParticipantes=new ArrayList();
        
        participanteDAO = new ParticipanteDAOImpl();
        
        List<Participante> lista= participanteDAO.listaPunto(punto);
        return (getJsonFromListaPArticipantes(lista));
		        
		        
	}
	
	public static JSONObject getJsonFromListaPArticipantes(List<Participante> form)
	  {
	    JSONObject responseDetailsJson = new JSONObject();
	    JSONArray jsonArray = new JSONArray();

	    
	    for (int i = 0; i < form.size(); i++)
	    {
	      JSONObject formDetailsJson = new JSONObject();
	      try {
	    	  formDetailsJson.put("ID", form.get(i).getId());
	    	  formDetailsJson.put("Dorsal", form.get(i).getDorsal());
	          formDetailsJson.put("Tiempo", form.get(i).getTiempo());
	          formDetailsJson.put("Punto", form.get(i).getPunto());

	          jsonArray.put(formDetailsJson);
	    	  
		} catch (JSONException e) {
			
		}
	      

	     
	    }
	     
			try {
				responseDetailsJson.put("Clasificacion", jsonArray);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	    return responseDetailsJson;
	  }
	
	public static synchronized java.util.Date restarHoras(java.util.Date fch, int horas) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.HOUR, -horas);
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
