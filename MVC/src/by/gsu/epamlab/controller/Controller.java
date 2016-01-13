package by.gsu.epamlab.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.gsu.epamlab.services.Operations;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");  
		  rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] flags = request.getParameterValues("flag");
		
		if(flags!= null && Operations.isDataOk(flags)){
			String operation=request.getParameter("select").toUpperCase();
			StringBuilder out=new StringBuilder();
			out.append("(").
				append(Operations.arratToString(flags)).
				append(")");
			request.setAttribute("oper", operation);
			request.setAttribute("data", out);
			request.setAttribute("result", Operations.getResult(operation, flags));	
			request.getRequestDispatcher("/result.jsp").forward(request, response);
				
		}else{
			doGet(request, response);
		}
		
		
		
		

	}

}
