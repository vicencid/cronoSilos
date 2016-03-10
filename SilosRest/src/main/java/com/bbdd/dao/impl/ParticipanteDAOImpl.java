package com.bbdd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bbdd.ConectaDB;
import com.bbdd.dao.ParticipanteDAO;
import com.bbdd.dto.Participante;

public class ParticipanteDAOImpl implements ParticipanteDAO {

	public ConectaDB db;

    public ParticipanteDAOImpl() {
        db = new ConectaDB();
    }
	
	@Override
	public List<Participante> list() {
		List<Participante> list = null;
        String sql = "select * from silostiempos";
        try {
            Connection cn = db.getConnection();
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            list = new ArrayList<Participante>();
            while (rs.next()) {
                Participante p = new Participante();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                /*c.setApellidos(rs.getString(3));
                c.setDni(rs.getString(4));
                c.setDireccion(rs.getString(5));*/
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return list;
	}

	/*@Override
	public String insertar(int punto, Participante participante) {
		String result = null;
        String sql = "INSERT INTO silostiempos (punto,tiempo, dorsal)"
                + "VALUES (?,?,?)";
        try {
            Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, punto);
            ps.setTime(2, new java.sql.Time(participante.getTiempo().getTime()));
            ps.setInt(3, participante.getDorsal());
            ps.executeUpdate();
            ps.close();
            cn.close();
        } catch (SQLException e) {
        	e.printStackTrace();
            
        }
        return result;
	}*/
	
	@Override
	public String insertar(int punto, Date date, List listaDorsales) throws SQLException {
		String result = null;
        String sql = "INSERT INTO silostiempos (punto,tiempo, dorsal)"
                + "VALUES (?,?,?)";
        Connection cn=null;
        try {
            cn = db.getConnection();
            for(int i=0;i<listaDorsales.size();i++){
	            PreparedStatement ps = cn.prepareStatement(sql);
	            ps.setInt(1, punto);
	            ps.setTime(2, new java.sql.Time(date.getTime()));
	            ps.setInt(3, Integer.parseInt(listaDorsales.get(i).toString()));
	            ps.executeUpdate();
	            ps.close();
            }
            
        } catch (SQLException e) {
        	e.printStackTrace();
            
        }finally{
       	 /*This block should be added to your code
       	  * You need to release the resources like connections
       	  */
       	 if(cn!=null)
       	  cn.close();
       }
        return result;
	}
	
	@Override
	public String insertarSeparado(int punto, Date date, List listaDorsales) throws SQLException {
		String result = null;
        String sql = "INSERT INTO tiempo"+punto+" (tiempo, dorsal)"
                + "VALUES (?,?)";
        Connection cn=null;
        try {
             cn = db.getConnection();
            for(int i=0;i<listaDorsales.size();i++){
	            PreparedStatement ps = cn.prepareStatement(sql);
	            ps.setTime(1, new java.sql.Time(date.getTime()));
	            ps.setInt(2, Integer.parseInt(listaDorsales.get(i).toString()));
	            ps.executeUpdate();
	            ps.close();
            }
            
        } catch (SQLException e) {
        	e.printStackTrace();
            
        }finally{
        	 /*This block should be added to your code
        	  * You need to release the resources like connections
        	  */
        	 if(cn!=null)
        	  cn.close();
        }
        return result;
	}
	
	
	@Override
	public String insertar1(Date date, List listaDorsales) throws SQLException {
		String result = null;
        String sql = "INSERT INTO silostiemposcompletos (dorsal, tiempo1)"
                + "VALUES (?,?)";
        Connection cn=null;
        try {
            cn = db.getConnection();
            
            for(int i=0;i<listaDorsales.size();i++){
            	PreparedStatement ps = cn.prepareStatement(sql);
	            ps.setInt(1, Integer.parseInt(listaDorsales.get(i).toString()));
	            ps.setTime(2, new java.sql.Time(date.getTime()));
	            ps.executeUpdate();         
	            ps.close();
            }
            
            cn.close();
        } catch (SQLException e) {
        	e.printStackTrace();
            
        }finally{
       	 /*This block should be added to your code
       	  * You need to release the resources like connections
       	  */
       	 if(cn!=null)
       	  cn.close();
       }
        return result;
	}
	
	/*@Override
	public String update2(int punto, Date date, List listaDorsales) {
		String result = null;
        String sql = "UPDATE silostiemposcompletos (punto=?,tiempo2=?) where dorsal = ?";
               
        try {
            Connection cn = db.getConnection();
            
            for(int i=0;i<listaDorsales.size();i++){
            	PreparedStatement ps = cn.prepareStatement(sql);
	            ps.setInt(1, punto);
	            ps.setTime(2, new java.sql.Time(date.getTime()));
	            ps.setInt(3, Integer.parseInt(listaDorsales.get(i).toString()));
	            ps.executeUpdate();         
	            ps.close();
            }
            
            cn.close();
        } catch (SQLException e) {
        	e.printStackTrace();
            
        }
        return result;
	}*/
	
	@Override
	public List<Participante> listaPunto(String punto) {
		List<Participante> list = null;
        String sql = "select * from silostiempos where punto = "+punto +" order by tiempo";
        try {
            Connection cn = db.getConnection();
            PreparedStatement st = cn.prepareStatement(sql);
            //st.setString(1, punto);
            ResultSet rs = st.executeQuery(sql);
            
            list = new ArrayList<Participante>();
            while (rs.next()) {
                Participante p = new Participante();
                p.setId(rs.getInt(1));
                p.setPunto(rs.getString(2));
                p.setTiempo(rs.getTime(3));
                p.setDorsal(rs.getInt(4));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return list;
	}
	
	@Override
	public List<Participante> listaFinal(int dorsal, int i) {
		List<Participante> list = null;
        String sql = "select * from silostiemposcompletos where dorsal = "+dorsal+" order by tiempo"+i;
        try {
            Connection cn = db.getConnection();
            PreparedStatement st = cn.prepareStatement(sql);
            //st.setString(1, "punto");
            ResultSet rs = st.executeQuery(sql);
            
            list = new ArrayList<Participante>();
            while (rs.next()) {
                Participante p = new Participante();
                p.setId(rs.getInt(1));
                p.setPunto(rs.getString(2));
                p.setTiempo(rs.getTime(3));
                p.setDorsal(rs.getInt(4));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return list;
	}
	
	@Override
	public List<Participante> listaDirecto(int i, String dorsales) throws SQLException {
		List<Participante> list = null;
		Connection cn = null;
        String sql = "select * from tiempo"+i+" where dorsal not in(0"+dorsales+") order by tiempo";
        try {
            cn = db.getConnection();
            PreparedStatement st = cn.prepareStatement(sql);
            //st.setString(1, "punto");
            ResultSet rs = st.executeQuery(sql);
            list = new ArrayList<Participante>();
            while (rs.next()) {
                Participante p = new Participante();
                p.setPunto(i+"");
                p.setTiempo(rs.getTime(1));
                p.setDorsal(rs.getInt(2));
                list.add(p);
            }
            
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }finally{
        	 /*This block should be added to your code
        	  * You need to release the resources like connections
        	  */
        	 if(cn!=null)
        	  cn.close();
        }
        return list;
	}
	
	@Override
	public Participante buscarCategoria(Participante participante) {
		
		String fin="nulo";
		Connection cn = db.getConnection();
		//int j=0;
		try {
		
			for(int i=1;i<7;i++){
	        String sql = "select count(*) from tiempo"+i+" where dorsal ="+participante.getDorsal();
	        
	            
	            PreparedStatement st = cn.prepareStatement(sql);
	            //st.setString(1, "punto");
	            ResultSet rs = st.executeQuery(sql);
	            
	            while (rs.next()) {
	            	if(rs.getInt(1)>0){
		            	//j++;
		            	if(i==1){
		            		fin="posibleBronce";
		            	}else if(i==2){
		            		fin="posibleBronce";
		            	}else if(i==3){
		            		fin="posiblePlata";
		            	}else if(i==4){
		            		fin="posiblePlata";
		            	}else if(i==5){
		            		fin="posibleOro";
		            	}else if(i==6){	
		            			if(fin.equals("nulo")){
		            				fin="Bronce";
		            			}else{
		            				fin=fin.substring(7,fin.length());
		            			}
		            	}
		                participante.setFin(fin);
		            }
	            }
	                /*c.setApellidos(rs.getString(3));
	                c.setDni(rs.getString(4));
	                c.setDireccion(rs.getString(5));*/
	        }
	        } catch (SQLException e) {
	        	//j++;
	        	
	            System.out.println("Error : " + e.getMessage());
	        }finally{
	        	
	        	
		        try {
		        	 if(cn!=null)
			        	  cn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        }
        return participante;
	}
	
	@Override
	public Participante ponerNombre(Participante participante) {
		
		String nombre="Nombre";
		Connection cn = db.getConnection();
		
	    String sql = "select nombre from nombres where dorsal ="+participante.getDorsal();
	    

        PreparedStatement st;
        ResultSet rs;
		try {
			st = cn.prepareStatement(sql);
			rs = st.executeQuery(sql);
			 while (rs.next()) {
	            	if(rs.getString(1)!=null){
	            		nombre=rs.getString(1);
	            	}
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(cn!=null)
				try {
					cn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	   
	        
		participante.setNombre(nombre);
		return participante;
	}
	
	
	@Override
	public Participante ponerPuntosIntermedios(Participante participante) {
		
		
		Connection cn = db.getConnection();
		
		
		for(int i=1;i<=6;i++){
	    String sql = "select tiempo from tiempo"+i+" where dorsal ="+participante.getDorsal();
	    

	        PreparedStatement st;
	        ResultSet rs;
			try {
				st = cn.prepareStatement(sql);
				rs = st.executeQuery(sql);
				 while (rs.next()) {
		            	if(rs.getString(1)!=null){
		            		if(i==1){
		            			participante.setTiempo1(rs.getTime(1));
		            		}else if(i==2){
		            			participante.setTiempo2(rs.getTime(1));
		            		}else if(i==3){
		            			participante.setTiempo3(rs.getTime(1));
		            		}else if(i==4){
		            			participante.setTiempo4(rs.getTime(1));
		            		}else if(i==5){
		            			participante.setTiempo5(rs.getTime(1));
		            		}else if(i==6){
		            			participante.setTiempo6(rs.getTime(1));
		            		}
		            		
		            	}
				 }
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	        try {
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return participante;
	}
	
	@Override
	public List<Integer> listaDorsalPunto(int punto) {
		List<Integer> list = null;
        String sql = "select dorsal from silostiemposcompletos where tiempo"+punto+ " != "+"'null'";
        try {
            Connection cn = db.getConnection();
            PreparedStatement st = cn.prepareStatement(sql);
            //st.setString(1, "punto");
            ResultSet rs = st.executeQuery(sql);
            
            list = new ArrayList<Integer>();
            while (rs.next()) {
                Integer p = new Integer(0);
                p=rs.getInt(1);
               
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        return list;
	}

	@Override
	public int id() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Participante get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Participante participante) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
