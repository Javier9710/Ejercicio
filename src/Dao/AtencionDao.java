package Dao;

import java.util.List;

import javax.persistence.EntityManager;

import Dto.Atencion;
import Util.Conexion;

public class AtencionDao {
	
	EntityManager em = null;
	
	public AtencionDao() {
		em = Conexion.getEm();

	}


		
	public List<Atencion> listar1(){
		return (List<Atencion>) em.createQuery("SELECT s from Atencion s").getResultList();	
		
	}
	
	public List<Atencion> listar(int id){
		
		return (List<Atencion>) em.createQuery("SELECT DISTINCT a from Atencion a where a.caso= '"+id+"'  ").getResultList();	
		
	}
	

	public void registrar(Atencion atencion) {
		try {
			em.getTransaction().begin();
			em.persist(atencion);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// em.close();
		}

	}

	public void actualizar(Atencion atencion) {
		try {
			em.getTransaction().begin();
			em.merge(atencion);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//em.close();
		}

	}

	public void eliminar(int id) {
		try {

			Atencion c = em.find(Atencion.class, id);
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
			Atencion u = em.find(Atencion.class, c);
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


