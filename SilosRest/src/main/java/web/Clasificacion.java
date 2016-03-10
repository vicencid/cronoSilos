package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import com.google.gson.Gson;

/**
 * Servlet implementation class Clasificacion
 */
@WebServlet("/Clasificacion")
public class Clasificacion extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1L;
	private int numeroPeticiones=0;

    /**
     * Default constructor. 
     */
    public Clasificacion() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		numeroPeticiones++;
		System.out.println(numeroPeticiones);
		Participante participante =new Participante();
		
		
		HttpClient httpclient = new DefaultHttpClient();
		// Creación del objeto petición
		HttpGet httpget = new HttpGet("http://localhost:8090/SilosRest/rest/clasificacion/Silos");
		
		HttpResponse response; 
		try {
		// Ejecución de la petición y guardado de respuesta
		response = httpclient.execute(httpget);
		// Mostramos el resultado  de la petición
		// Leemos los datos de la respuesta
		HttpEntity entity = response.getEntity();
		// Si hay datos la petición se hizo correctamente y procedemos a mostrarlos
		if (entity != null) {
		InputStream instream = entity.getContent();
		String result= convertStreamToString(instream);
		instream.close();
		
		Gson gson= new Gson();
		JsonCompleto jsonCompleto=new JsonCompleto();
		ArrayList <Participante> listaParticipantes=new ArrayList<Participante>();
		ArrayList <Participante> listaFinOro=new ArrayList<Participante>();
		ArrayList <Participante> listaFinPlata=new ArrayList<Participante>();
		ArrayList <Participante> listaFinBronce=new ArrayList<Participante>();
		ArrayList <Participante> listaDirecto=new ArrayList<Participante>();
		jsonCompleto=gson.fromJson(result, JsonCompleto.class);
		
		
		listaParticipantes=jsonCompleto.getParticipantes();
		
		for(int i=0;i<listaParticipantes.size();i++){
			if(listaParticipantes.get(i).getFin().equalsIgnoreCase("oro")){
				listaFinOro.add(listaParticipantes.get(i));
			}else if(listaParticipantes.get(i).getFin().equalsIgnoreCase("plata")){
				listaFinPlata.add(listaParticipantes.get(i));
			}else if(listaParticipantes.get(i).getFin().equalsIgnoreCase("bronce")){
				listaFinBronce.add(listaParticipantes.get(i));
			}else{
				listaDirecto.add(listaParticipantes.get(i));
			}
		
		}
		
		/*try {
			ArrayList lista =jsonStringToArray(result);
			for(int i =0;i<listaParticipantes.size();i++){
				System.out.println(listaParticipantes.get(i).getNombre());
				System.out.println(listaParticipantes.get(i).getTiempo());
				System.out.println(listaParticipantes.get(i).getTiempo1());
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//System.out.println("Datos: "+result);
		
		request.setAttribute("listaFinOro", listaFinOro);
		request.setAttribute("listaFinPlata", listaFinPlata);
		request.setAttribute("listaFinBronce", listaFinBronce);
		request.setAttribute("listaDirecto", listaDirecto);
		request.setAttribute("numeroPeticiones", numeroPeticiones);
		
		 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/clasificacion.jsp");
         dispatcher.forward(request,  resp);   
		
		}
		} catch (ClientProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
				
		
	}
	
	public static String convertStreamToString(InputStream is) {
	      BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	      StringBuilder sb = new StringBuilder();

	      String line = null;
	      try {
	          while ((line = reader.readLine()) != null) {
	              sb.append(line + "\n");
	          }
	      } catch (IOException e) {
	          e.printStackTrace();
	      } finally {
	          try {
	              is.close();
	          } catch (IOException e) {
	              e.printStackTrace();
	          }
	      }
	      return sb.toString();
	  }
	
	ArrayList<String> jsonStringToArray(String jsonString) throws JSONException {

	    ArrayList<String> stringArray = new ArrayList<String>();
	    
	    jsonString=jsonString.substring(17,jsonString.length());

	    JSONArray jsonArray = new JSONArray(jsonString);

	    for (int i = 0; i < jsonArray.length(); i++) {
	        stringArray.add(jsonArray.getString(i));
	    }

	    return stringArray;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
