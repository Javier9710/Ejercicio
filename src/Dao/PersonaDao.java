package Dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
//import javax.servlet.http.Part;

import Dto.Persona;
import Util.Conexion;

public class PersonaDao {

	EntityManager em = null;

	public PersonaDao() {
		em = Conexion.getEm();

	}

	public int validar(String cedula, String pass) {
		Persona p = new Persona();
		p=null;
		int x=0;
		
		Query nativeQuery = em.createNativeQuery("SELECT count(*) nombre,correo FROM Persona p, Secretario s "
		 		                                 + "WHERE p.cedula =? "
		 		                                 + "and p.cedula=s.persona "
		 		                                 + "and s.pass=?");
		
	        nativeQuery.setParameter(1, cedula);
	        nativeQuery.setParameter(2, pass);
	       
	        	
	        	Object[] result = (Object[]) nativeQuery.getSingleResult();
	        	Integer dato1 = ((BigInteger) result[0]).intValue();
	        	System.out.println("sdfsdfsdfsdfs"+dato1);
	        	
	        	if(dato1!=0) {
	        		
	        		x=1;
	        	}
	        	//int x= (Integer) result[0];
	 	        //p.setNombre((String) result[0]);
	 	        //p.setEdad((Integer) result[1]);
	        	System.out.println(x);
	 	       
	        
	       
	
		return x;
	}
	
	public List<Persona> listar() {
		
		 return (List<Persona>) em.createNativeQuery("SELECT p.foto,p.cedula, p.nombre, p.edad, p.telefono "
				 + "FROM Persona p "
                 + "WHERE p.id = e.persona "
                 ).getResultList();
		  //List<Persona> results = x.getResultList();
		  //System.out.println(results[0].);
		   //Persona p = new Persona();
		  // p.setFoto(""+(String)results[0]);
		   //p.setFoto((String)result[0]);
		   //System.out.println("foto "+ p.getFoto());
		

		//Persona p = new Persona();
		//p.setCedula((String) result[0]);
		//p.setNombre((String) result[1]);
		//p.setEdad((Integer) result[2]);
		//p.setTelefono((String) result[3]);
		//p.setFoto((String) result[4]);
		//lista.add(p);
		
		
	}
	
	public List<Persona> listar1(){
		return (List<Persona>) em.createQuery("SELECT p from Persona p, Abogado a Where p.cedula=a.persona").getResultList();	
		
	}
	
	
	public void Actualizar1(String Correo, String cedula) {
		Query nativeQuery=em.createNativeQuery("UPDATE persona SET correo = ? WHERE cedula = ?");
		nativeQuery.setParameter(1, Correo);
        nativeQuery.setParameter(2, cedula);
		
	}
	

	

	public void registrar(Persona persona) {
		try {
			em.getTransaction().begin();
			em.persist(persona);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// em.close();
		}

	}

	public void actualizar(Persona persona) {
		try {
			em.getTransaction().begin();
			em.merge(persona);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//em.close();
		}

	}

	public void eliminar(String id) {
		try {

			Persona u = em.find(Persona.class, id);
			em.getTransaction().begin();
			em.remove(u);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//em.close();
		}

	}

	public int buscar(int m) {
		int id=0;
		try {
			em.getTransaction().begin();
			Persona u = em.find(Persona.class, m);
			em.getTransaction().commit();
			//System.out.println(u.getNombre());
			//id=u.getId();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//em.close();
		}
		
		return id;

	}
	
/*	public String fileName(final Part part) {
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}*/

}
