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
			if(a!=null) {
				HttpSession sesion1 = request.getSession();
				sesion1.setAttribute("registroA", 1);

				response.sendRedirect("WebApp/regAbogado.jsp");
				//sesion1.invalidate();	
			}
			
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
	
			AbogadoDao pD3 = new AbogadoDao();
			Abogado a1=new Abogado();
			
			String cedula1 = request.getParameter("cedula");
			String pass1 = request.getParameter("pass");
			a1= pD3.validar(cedula1, pass1);
			System.out.print(".------ "+a1);
			
			
			if(a1!=null) {
				
				HttpSession sesion = request.getSession();
				sesion.setAttribute("abogado", a1);
				
				response.sendRedirect("WebApp/inicioAbogado.jsp");
			}else {
				
				HttpSession sesion3 = request.getSession();
				sesion3.setAttribute("abogado", 1);
				response.sendRedirect("WebApp/loginAbogado.jsp");
			}
			break;
			
		case "actualizar":
			
			Persona pa = new Persona();
			PersonaDao pda = new PersonaDao();
			Abogado aa = new Abogado();
			AbogadoDao ada = new AbogadoDao();
			
			String cedulaa = request.getParameter("cedula");
			String nombrea = request.getParameter("nombre");
			String correoa = request.getParameter("correo");
			String especializaciona = request.getParameter("especializacion");
			String passa = request.getParameter("pass");
			String estadoa = request.getParameter("estado");
			String fotoa = request.getParameter("foto");

			pa.setCedula(cedulaa);
			pa.setNombre(nombrea);
			pa.setCorreo(correoa);
			
			aa.setEspecializacion(especializaciona);
			aa.setPass(passa);
			aa.setEstado(estadoa);
			aa.setFoto(fotoa);
			aa.setPersona(pa);
			
			pda.actualizar(pa);
			ada.actualizar(aa);
			
			
			if(aa!=null) {
			HttpSession sesion5 = request.getSession();
			sesion5.setAttribute("abogado", aa);
			HttpSession sesion6 = request.getSession();
			sesion6.setAttribute("abogadoA", 1);
			response.sendRedirect("WebApp/misDatos.jsp");
			
			
			}
			
			break;
			
		case "cerrar":
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("../abogadosAyD/WebApp/loginAbogado.jsp");
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
