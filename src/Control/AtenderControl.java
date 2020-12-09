package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.AtencionDao;
import Dao.CasoDao;
import Dto.Atencion;
import Dto.Caso;

/**
 * Servlet implementation class AtenderControl
 */
@WebServlet("/AtenderControl")
public class AtenderControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public int var=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtenderControl() {
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
		case "atenderC":
			var = Integer.parseInt(request.getParameter("ids"));
			System.out.println("var----"+var);
			response.sendRedirect("WebApp/atenderCaso.jsp");
			
			break;
			
		case "atenderCaso":
			
			Atencion a = new Atencion();
			AtencionDao ad = new AtencionDao();
			Caso c = new Caso();

			
			String titulo = request.getParameter("titulo");
			String hora = request.getParameter("hora");
			String fecha = request.getParameter("fecha");
			String descripcion = request.getParameter("descripcion");
			c.setId(var);
			
			a.setTitulo(titulo);
			a.setHora(hora);
			a.setFecha(fecha);
			a.setDescripcion(descripcion);
			a.setCaso(c);
			
			ad.registrar(a);
			
			HttpSession sesion8 = request.getSession();
			sesion8.setAttribute("atenderC", 1);
			response.sendRedirect("WebApp/atenderCaso.jsp");
			
			break;
			
		case "historial":
			var = Integer.parseInt(request.getParameter("ids"));			
			HttpSession sesion2 = request.getSession();
			sesion2.setAttribute("var", var);
			response.sendRedirect("WebApp/historialAtencion.jsp");
			
			break;
			
			
		case "historialA":
			var = Integer.parseInt(request.getParameter("ids"));
			System.out.println("-----------------"+var);
			HttpSession sesion3 = request.getSession();
			sesion3.setAttribute("var1", var);
			response.sendRedirect("WebApp/historial.jsp");
			
			break;
			
			

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
