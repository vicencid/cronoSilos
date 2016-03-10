<%@page import="java.util.ArrayList"%>
<%@page import="web.Participante"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="org.codehaus.jettison.json.JSONObject" %>
<%@page import="org.json.simple.JSONValue"%>
<%@page import="org.json.simple.parser.JSONParser"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<style>
			table {
    border: 1px solid black;}
    
    
    #table-scroll {
  height:290px;
  overflow:auto;  
  margin-top:20px;
}

    #background {
  background: gray;  
}

.oro{
	background-color:#FFB300;
	border: 1px solid black;
	}
.directo{
	background-color:#F84103;
	border: 1px solid black;
	}
.plata{
	background-color:#9BF1F2;
	border: 1px solid black;
	}
.bronce{
	background-color:#96EF61;
	border: 1px solid black;
	}

    </style>
  <title>COLINA TRISTE EN DIRECTO!</title>
</head>
<body>
<form name="formClasificacion" action="./Clasificacion" method="get" id="idForm">



<div  style="overflow-y: hidden;">
	<IMG SRC="imagenes/perfilReducido.png" ALT="descripcion" WIDTH=60	 HEIGHT=20% BORDER=0 style="width: 100%; ">
</div>
<% ArrayList <Participante>listaDirecto = (ArrayList)request.getAttribute("listaDirecto");
ArrayList <Participante>listaFinOro = (ArrayList)request.getAttribute("listaFinOro");
ArrayList <Participante>listaFinPlata = (ArrayList)request.getAttribute("listaFinPlata");
ArrayList <Participante>listaFinBronce = (ArrayList)request.getAttribute("listaFinBronce");
String numeroPeticiones=request.getAttribute("numeroPeticiones").toString();

%>
<input type="submit" value="Actualizar" />Página consultada <%=numeroPeticiones%> veces

  
 
<div id="table-scroll">
 
			<% if(listaFinOro!=null && !listaFinOro.isEmpty()){%>
			<span class="oro">CLASIFICACION PROVISIONAL CATEGORIA ORO</span>
			<div>
				<div >
					 <table style="width:100%">
					  <thead>
					 <tr class="oro">	
					 		<th><span >Puesto</span></th>
					        <th><span >Dorsal</span></th>
					        <th><span >Nombre</span></th>
					        <th><span >KM 15.4</span></th>
					        <th><span >KM 35.4</span></th>
					        <th><span >KM 46</span></th>
					        <th><span >KM 64.4</span></th>
					        <th><span >KM 78.5</span></th>
					        <th><span >Meta</span></th>
					    </tr>
					 </thead>
					 
					 <tbody>
					 
					  <% for (int i=0;i<listaFinOro.size();i++){%>
					 
					  	<tr id = <%if(i%2==0){%> background<%} %>><font color="red">
					  		<td><% out.print(i+1);%></td>
					  		<td><% out.print(listaFinOro.get(i).getDorsal());%></td>
					        <td><% out.print(listaFinOro.get(i).getNombre());%></td>
					        <td><% out.print(listaFinOro.get(i).getTiempo1());%></td>
					        <td><% out.print(listaFinOro.get(i).getTiempo2());%></td>
					        <td><% out.print(listaFinOro.get(i).getTiempo3());%></td>
					        <td><% out.print(listaFinOro.get(i).getTiempo4());%></td>
					        <td><% out.print(listaFinOro.get(i).getTiempo5());%></td>
							<td><% out.print(listaFinOro.get(i).getTiempo6());%></td>
						</font>	</tr>
						
					  <%} %>
					  </tbody>
					  </table>
				</div>
			</div>
			<% }%>
			<% if(listaDirecto!=null && !listaDirecto.isEmpty()){%>
			<br/>
			<span class="directo">LOS PRÓXIMOS EN LLEGAR A META</span>
			<div>
				<div >
					 <table style="width:100%">
					  <thead>
					 <tr class="directo">	
					 		<th><span class="text">Puesto</span></th>
					        <th><span class="text">Dorsal</span></th>
					        <th><span class="text">Nombre</span></th>
					        <th><span class="text">KM 15.4</span></th>
					        <th><span class="text">KM 35.4</span></th>
					        <th><span class="text">KM 46</span></th>
					        <th><span class="text">KM 64.4</span></th>
					        <th><span class="text">KM 78.5</span></th>
					        <th><span class="text">Meta</span></th>
					    </tr>
					 </thead>
					 
					 <tbody>
					 
					  <% for (int i=0;i<listaDirecto.size();i++){%>
					 
					  	<tr id = <%if(i%2==0){%> background<%} %>><font color="red">
					  		<td><% out.print(i+1);%></td>
					  		<td><% out.print(listaDirecto.get(i).getDorsal());%></td>
					        <td><% out.print(listaDirecto.get(i).getNombre());%></td>
					        <td><% out.print(listaDirecto.get(i).getTiempo1());%></td>
					        <td><% out.print(listaDirecto.get(i).getTiempo2());%></td>
					        <td><% out.print(listaDirecto.get(i).getTiempo3());%></td>
					        <td><% out.print(listaDirecto.get(i).getTiempo4());%></td>
					        <td><% out.print(listaDirecto.get(i).getTiempo5());%></td>
							<td><% out.print(listaDirecto.get(i).getTiempo6());%></td>
						</font>	</tr>
						
					  <%} %>
					  </tbody>
					  </table>
				</div>
			</div>
			<% }%>
			<% if(listaFinPlata!=null && !listaFinPlata.isEmpty()){%>
			<br/>
			<span class="plata">CLASIFICACION PROVISIONAL CATEGORIA PLATA</span>
			<div>
				<div >
					 <table style="width:100%">
					  <thead>
					 <tr class="plata">	
					 		<th><span class="text">Puesto</span></th>
					        <th><span class="text">Dorsal</span></th>
					        <th><span class="text">Nombre</span></th>
					        <th><span class="text">KM 15.4</span></th>
					        <th><span class="text">KM 35.4</span></th>
					        <th><span class="text">KM 46</span></th>
					        <th><span class="text">KM 64.4</span></th>
					        <th><span class="text">KM 78.5</span></th>
					        <th><span class="text">Meta</span></th>
					    </tr>
					 </thead>
					 
					 <tbody>
					 
					  <% for (int i=0;i<listaFinPlata.size();i++){%>
					 
					  	<tr id = <%if(i%2==0){%> background<%} %>><font color="red">
					  		<td><% out.print(i+1);%></td>
					  		<td><% out.print(listaFinPlata.get(i).getDorsal());%></td>
					        <td><% out.print(listaFinPlata.get(i).getNombre());%></td>
					        <td><% out.print(listaFinPlata.get(i).getTiempo1());%></td>
					        <td><% out.print(listaFinPlata.get(i).getTiempo2());%></td>
					        <td><% out.print(listaFinPlata.get(i).getTiempo3());%></td>
					        <td><% out.print(listaFinPlata.get(i).getTiempo4());%></td>
					        <td><% out.print(listaFinPlata.get(i).getTiempo5());%></td>
							<td><% out.print(listaFinPlata.get(i).getTiempo6());%></td>
						</font>	</tr>
						
					  <%} %>
					  </tbody>
					  </table>
				</div>
			</div>
			<% }%>
				<% if(listaFinBronce!=null && !listaFinBronce.isEmpty()){%>
				<br/>
			<span class="bronce">CLASIFICACION PROVISIONAL CATEGORIA BRONCE</span>
			<div>
				<div>
					 <table style="width:100%">
					  <thead>
					 <tr class="bronce">	
					 		<th><span class="text">Puesto</span></th>
					        <th><span class="text">Dorsal</span></th>
					        <th><span class="text">Nombre</span></th>
					        <th><span class="text">KM 15.4</span></th>
					        <th><span class="text">KM 35.4</span></th>
					        <th><span class="text">KM 46</span></th>
					        <th><span class="text">KM 64.4</span></th>
					        <th><span class="text">KM 78.5</span></th>
					        <th><span class="text">Meta</span></th>
					    </tr>
					 </thead>
					 
					 <tbody>
					 
					  <% for (int i=0;i<listaFinBronce.size();i++){%>
					 
					  	<tr id = <%if(i%2==0){%> background<%} %>><font color="red">
					  		<td><% out.print(i+1);%></td>
					  		<td><% out.print(listaFinBronce.get(i).getDorsal());%></td>
					        <td><% out.print(listaFinBronce.get(i).getNombre());%></td>
					        <td><% out.print(listaFinBronce.get(i).getTiempo1());%></td>
					        <td><% out.print(listaFinBronce.get(i).getTiempo2());%></td>
					        <td><% out.print(listaFinBronce.get(i).getTiempo3());%></td>
					        <td><% out.print(listaFinBronce.get(i).getTiempo4());%></td>
					        <td><% out.print(listaFinBronce.get(i).getTiempo5());%></td>
							<td><% out.print(listaFinBronce.get(i).getTiempo6());%></td>
						</font>	</tr>
						
					  <%} %>
					  </tbody>
					  </table>
				</div>
			</div>
					
					
			<% }%>
			
	</div>
	
	</form>
</body>
</html>