package Dao;

import java.io.File;
import java.math.BigInteger;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Dto.Abogado;
import Dto.Persona;
import Util.Conexion;

public class AbogadoDao {

	EntityManager em = null;

	public AbogadoDao() {

		em = Conexion.getEm();
	}
	
	
	public Persona validar(String cedula1, String pass1) {
		Persona p = new Persona();
		 Query nativeQuery = em.createNativeQuery("SELECT cedula,correo FROM Persona p, Abogado a "
		 		                                 + "WHERE p.cedula =? "
		 		                                 + "and p.cedula=a.persona "
		 		                                 + "and a.pass=?");
	        nativeQuery.setParameter(1, cedula1);
	        nativeQuery.setParameter(2, pass1);
	        Object[] result = (Object[]) nativeQuery.getSingleResult();
	        p.setCedula((String) result[0]);
	        p.setCorreo((String) result[1]);
	      

	       
	
		return p;
	}
	
	public List<Abogado> listar() {
		
		 return (List<Abogado>) em.createNativeQuery("SELECT p.foto,p.cedula, p.nombre, p.edad, p.telefono "
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
	
	public List<Abogado> listar1(){
		return (List<Abogado>) em.createQuery("SELECT a from  Abogado a ").getResultList();	
		
	}

	

	public void registrar(Abogado abogado) {
		try {
			em.getTransaction().begin();
			em.persist(abogado);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// em.close();
		}

	}

	public void actualizar(Abogado abogado) {
		try {
			em.getTransaction().begin();
			em.merge(abogado);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//em.close();
		}

	}

	public void eliminar(String id) {
		try {

			Abogado a = em.find(Abogado.class, id);
			em.getTransaction().begin();
			em.remove(a);
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
			Abogado a = em.find(Abogado.class, m);
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
	
	
	public String obtenerNombre(String url) {
		

		String[] parts = url.split("\\\\");
		String part1 = parts[5];
		System.out.print(part1);
		   
		
		 return part1;
		
	}

}


