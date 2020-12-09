package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
