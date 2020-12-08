package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.AbogadoDao;
import Dao.CasoDao;
import Dao.PersonaDao;
import Dto.Abogado;
import Dto.Persona;

/**
 * Servlet implementation class AbogadoControl
 */
@WebServlet("/AbogadoControl")
public class AbogadoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AbogadoControl() {
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
			//instancias
			Persona p = new Persona();
			PersonaDao pd = new PersonaDao();
			Abogado a = new Abogado();
			AbogadoDao ad = new AbogadoDao();
			//entrada persona
			String cedula = request.getParameter("cedula");
			String nombre = request.getParameter("nombre");
			String correo = request.getParameter("correo"); 
			
			//entrada Abogado
			String especializacion = request.getParameter("especializacion");
			String pass = request.getParameter("pass");
			String foto = request.getParameter("foto");
			String nombreFoto=ad.obtenerNombre(foto);
			
			p.setCedula(cedula);
			p.setNombre(nombre);
			p.setCorreo(correo);
			pd.registrar(p);
			
			a.setPersona(p);
			a.setPass(pass);
			a.setEspecializacion(especializacion);
			a.setEstado("LIBRE");
			a.setFoto(nombreFoto);
			ad.registrar(a);
			
			response.sendRedirect("WebApp/regAbogado.jsp");
			break;
			
		case "listar":
			
        	AbogadoDao pD = new AbogadoDao();
        	response.sendRedirect("WebApp/listarAbogado.jsp");
			break;
			
		case "eliminar":
        	AbogadoDao aD1= new AbogadoDao();
        	PersonaDao pD1 = new PersonaDao();
			String id = request.getParameter("id");
			aD1.eliminar(id);
			pD1.eliminar(id);
			response.sendRedirect("WebApp/listarAbogado.jsp");
			break;
			
		case "ingreso":
			Persona p1 = new Persona();
			AbogadoDao pD3 = new AbogadoDao();
			String cedula1 = request.getParameter("cedula");
			String pass1 = request.getParameter("pass");
			p1 = pD3.validar(cedula1, pass1);
			CasoDao AD = new CasoDao();
			
			if(p1!=null) {
				
				HttpSession sesion = request.getSession();
				sesion.setAttribute("abogado", p1);
				response.sendRedirect("WebApp/inicioAbogado.jsp");
			}
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
