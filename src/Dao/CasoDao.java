package Dao;

import java.util.List;

import javax.persistence.EntityManager;

import Dto.Caso;
import Util.Conexion;

public class CasoDao {
	
	EntityManager em = null;
	
	public CasoDao() {
		em = Conexion.getEm();

	}


		
	public List<Caso> listar1(){
		return (List<Caso>) em.createQuery("SELECT s from Caso s").getResultList();	
		
	}
	
	public List<Caso> listar(String cedula){
		
		return (List<Caso>) em.createQuery("SELECT DISTINCT s from Caso s, Abogado a where s.abogado= '"+cedula+"'  ").getResultList();	
		
	}
	

	public void registrar(Caso caso) {
		try {
			em.getTransaction().begin();
			em.persist(caso);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// em.close();
		}

	}

	public void actualizar(Caso caso) {
		try {
			em.getTransaction().begin();
			em.merge(caso);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//em.close();
		}

	}

	public void eliminar(String id) {
		try {

			Caso c = em.find(Caso.class, id);
			em.getTransaction().begin();
			em.remove(c);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//em.close();
		}

	}

	public int buscar(int c) {
		int id=0;
		try {
			em.getTransaction().begin();
			Caso u = em.find(Caso.class, c);
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


