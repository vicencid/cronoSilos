package com.rest.jersey;


import java.sql.SQLException;
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

@Path("/clasificacion")
public class Clasificacion{
	
	@GET
    @Path("/{parameter}")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject responseMsg( @PathParam("parameter") String parameter,	
            @DefaultValue("Nothing to say") @QueryParam("value") String value) throws SQLException {
				
		
        ParticipanteDAO participanteDAO= new ParticipanteDAOImpl();
        List<Participante> lista=null;
        List<Participante> listaAux=new ArrayList(); 	
        
        String dorsales="";
        for(int i=6;0<i;i--){
        	lista= participanteDAO.listaDirecto(i, dorsales);
        	
        	dorsales=dorsalesAQuitar(dorsales, lista);
        	listaAux=agregarALista(lista,listaAux);
        	
        }
        
        listaAux=calcularCategoria(listaAux, participanteDAO);
        return (getJsonFromListaPArticipantes(listaAux));
		        
		        
	}
	private List<Participante> calcularCategoria(List<Participante> listaAux,ParticipanteDAO participanteDAO) {
		for(int i=0;i<listaAux.size();i++){
			
			Participante participante=participanteDAO.buscarCategoria(listaAux.get(i));
			participante=participanteDAO.ponerNombre(participante);
			participante=participanteDAO.ponerPuntosIntermedios(participante);
			listaAux.remove(i);
			listaAux.add(i, participante);
			
			//listaAux.set(participanteDAO.buscarCategoria(listaAux.get(i)));
			//buscar en las tiempo7,tiempo6,tiempo5,tiempo4,tiempo3,tiempo2,tiempo1 por cada dorsal para asignar la clasificacion
		}
		return listaAux;
		
	}
	private List<Participante> agregarALista(List<Participante> lista,
			List<Participante> listaAux) {
		for(int i =0;i<lista.size();i++){
			listaAux.add(lista.get(i));
		}
		// TODO Auto-generated method stub
		return listaAux;
	}
	private String dorsalesAQuitar(String dorsales, List<Participante> lista){
		for (int i=0;i<lista.size();i++){
			dorsales=dorsales+","+lista.get(i).getDorsal();
		}
		return dorsales;
	
	}
	
	public static JSONObject getJsonFromListaPArticipantes(List<Participante> listaTotal)
	  {
	    JSONObject responseDetailsJson = new JSONObject();
	    JSONArray jsonArray = new JSONArray();

	    List<Participante> listaOro=new ArrayList<Participante>();
	    List<Participante> listaPlata=new ArrayList<Participante>();
	    List<Participante> listaBronce=new ArrayList<Participante>();
	    for (int i = 0; i < listaTotal.size(); i++)
	    {
	    	if(listaTotal.get(i).getFin()!=null && listaTotal.get(i).getFin().toLowerCase().contains("oro")){
	    		listaOro.add(listaTotal.get(i));
	    	}else if(listaTotal.get(i).getFin()!=null && listaTotal.get(i).getFin().toLowerCase().contains("plata")){
	    		listaPlata.add(listaTotal.get(i));
	    	}else if(listaTotal.get(i).getFin()!=null && listaTotal.get(i).getFin().toLowerCase().contains("bronce")){
	    		listaBronce.add(listaTotal.get(i));
	    	}
	    }
	    
	    for (int i = 0; i < listaOro.size(); i++)
	    {
	      JSONObject formDetailsJson = new JSONObject();
	      try {
	    	  formDetailsJson.put("Dorsal", listaOro.get(i).getDorsal());
	    	  formDetailsJson.put("Nombre", listaOro.get(i).getNombre());
	          formDetailsJson.put("Tiempo", listaOro.get(i).getTiempo());
	          formDetailsJson.put("Tiempo", listaOro.get(i).getTiempo());
	          formDetailsJson.put("Tiempo1", listaOro.get(i).getTiempo1());
	          formDetailsJson.put("Tiempo2", listaOro.get(i).getTiempo2());
	          formDetailsJson.put("Tiempo3", listaOro.get(i).getTiempo3());
	          formDetailsJson.put("Tiempo4", listaOro.get(i).getTiempo4());
	          formDetailsJson.put("Tiempo5", listaOro.get(i).getTiempo5());
	          formDetailsJson.put("Tiempo6", listaOro.get(i).getTiempo6());
	          
	          
	          int punto = Integer.parseInt(listaOro.get(i).getPunto());
	          String km="";
	          switch (punto) {
	            case 1:  km = "15.4";
	                     break;
	            case 2:  km = "35.4";
	                     break;
	            case 3:  km = "46";
	                     break;
	            case 4:  km = "64.4";
	                     break;
	            case 5:  km = "78.5";
	                     break;
	            case 6:  km = "Meta";
	                     break;	          
	          }
	          formDetailsJson.put("Km", km);
	        
	          
	          
	          //formDetailsJson.put("Puesto", i);
	          formDetailsJson.put("Fin", listaOro.get(i).getFin());
	         

	          jsonArray.put(formDetailsJson);
	    	  
			} catch (JSONException e) {
				
			}
	      
	    }
	    
	    
	    for (int i = 0; i < listaPlata.size(); i++)
	    {
	      JSONObject formDetailsJson = new JSONObject();
	      try {
	    	  formDetailsJson.put("Dorsal", listaPlata.get(i).getDorsal());
	    	  formDetailsJson.put("Nombre", listaPlata.get(i).getNombre());
	          formDetailsJson.put("Tiempo", listaPlata.get(i).getTiempo());
	          formDetailsJson.put("Tiempo", listaPlata.get(i).getTiempo());
	          formDetailsJson.put("Tiempo1", listaPlata.get(i).getTiempo1());
	          formDetailsJson.put("Tiempo2", listaPlata.get(i).getTiempo2());
	          formDetailsJson.put("Tiempo3", listaPlata.get(i).getTiempo3());
	          formDetailsJson.put("Tiempo4", listaPlata.get(i).getTiempo4());
	          formDetailsJson.put("Tiempo5", listaPlata.get(i).getTiempo5());
	          formDetailsJson.put("Tiempo6", listaPlata.get(i).getTiempo6());

	          int punto = Integer.parseInt(listaPlata.get(i).getPunto());
	          String km="";
	          switch (punto) {
	            case 1:  km = "15.4";
	                     break;
	            case 2:  km = "35.4";
	                     break;
	            case 3:  km = "46";
	                     break;
	            case 4:  km = "64.4";
	                     break;
	            case 5:  km = "78.5";
	                     break;
	            case 6:  km = "Meta";
	                     break;	          
	          }
	          formDetailsJson.put("Km", km);
	          //formDetailsJson.put("Puesto", i);
	          formDetailsJson.put("Fin", listaPlata.get(i).getFin());
	         

	          jsonArray.put(formDetailsJson);
	    	  
			} catch (JSONException e) {
				
			}
	    }
	    for (int i = 0; i < listaBronce.size(); i++)
	    {
	      JSONObject formDetailsJson = new JSONObject();
	      try {
	    	  formDetailsJson.put("Dorsal", listaBronce.get(i).getDorsal());
	    	  formDetailsJson.put("Nombre", listaBronce.get(i).getNombre());
	          formDetailsJson.put("Tiempo", listaBronce.get(i).getTiempo());
	          formDetailsJson.put("Tiempo", listaBronce.get(i).getTiempo());
	          formDetailsJson.put("Tiempo1", listaBronce.get(i).getTiempo1());
	          formDetailsJson.put("Tiempo2", listaBronce.get(i).getTiempo2());
	          formDetailsJson.put("Tiempo3", listaBronce.get(i).getTiempo3());
	          formDetailsJson.put("Tiempo4", listaBronce.get(i).getTiempo4());
	          formDetailsJson.put("Tiempo5", listaBronce.get(i).getTiempo5());
	          formDetailsJson.put("Tiempo6", listaBronce.get(i).getTiempo6());
	          

	          int punto = Integer.parseInt(listaBronce.get(i).getPunto());
	          String km="";
	          switch (punto) {
	            case 1:  km = "15.4";
	                     break;
	            case 2:  km = "35.4";
	                     break;
	            case 3:  km = "46";
	                     break;
	            case 4:  km = "64.4";
	                     break;
	            case 5:  km = "78.5";
	                     break;
	            case 6:  km = "Meta";
	                     break;	          
	          }
	          formDetailsJson.put("Km", km);
	          //formDetailsJson.put("Puesto", i);
	          formDetailsJson.put("Fin", listaBronce.get(i).getFin());
	         

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
