package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CasoDao;
import Dto.Abogado;
import Dto.Caso;
import Dto.Persona;

/**
 * Servlet implementation class CasoDao
 */
@WebServlet("/CasoControl")
public class CasoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CasoControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String accion = request.getParameter("accion");
		switch (accion) {
		
		case "registro":
			Caso c = new Caso();
			CasoDao cd = new CasoDao();
			
			//parametros caso
			String nombreCaso = request.getParameter("nombreCaso");
			String informacion = request.getParameter("informacion");
			String fecha = request.getParameter("fecha");
			String tipo = request.getParameter("tipo");
			String impor = request.getParameter("importancia");
			
			//cliente
			String nombreC = request.getParameter("nombreC");
			String cedula = request.getParameter("cedula");
			String correo = request.getParameter("correo");
			String telefono = request.getParameter("telefono");
			String direccion = request.getParameter("direccion");
			
			//abogado
			String id = request.getParameter("id");
			Abogado a = new Abogado();
			Persona p =  new Persona();
			p.setCedula(id);
			a.setEstado("OCUPADO");
			a.setPersona(p);
			
			
			
			//intancia
			c.setNombreCaso(nombreCaso);
			c.setInfo(informacion);
			c.setFecha(fecha);
			c.setTipoCaso(tipo);
			
			c.setNombreC(nombreC);
			c.setCedulaC(cedula);
			c.setCorreoC(correo);
			c.setTelC(telefono);
			c.setDir(direccion);
			c.setEstado("INCONCLUSO");
			c.setImportancia(impor);
			
			c.setAbogado(a);
			
			cd.registrar(c);
			
			if(c!=null) {
				HttpSession sesion2 = request.getSession();
				sesion2.setAttribute("registroC", 1);
				//request.setAttribute("msg",1);
				//getServletConfig().getServletContext().getRequestDispatcher("/WebApp/regCaso1.jsp").forward(request, response);
				response.sendRedirect("WebApp/regCaso1.jsp");
				//sesion1.invalidate();	
			}
			
			

			break;
			
			
		case "listar":
			
			CasoDao AD = new CasoDao();
			response.sendRedirect("WebApp/listarCaso.jsp");
			break;
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

}
