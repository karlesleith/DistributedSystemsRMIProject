package sw.gmit.ie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Instead of annotations, I moved the config to the file "web.xml"
public class DictionaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello from "+ this.getClass()+ " GET METHOD");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String query = request.getParameter("query");
		System.out.println(query+" has been past through the GET servlet");
		out.println("Hello "+query+" !");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Client client = new Client();
		String def = "";
		System.out.println("Hello from "+ this.getClass()+ " POST METHOD");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String query = request.getParameter("query");
		
		//Try Defining the Client
		try {
			Thread.sleep(1000);
			def = client.run(query.toLowerCase());
			response.sendRedirect("index.jsp?def="+"Query: "+query+", Definition: " + def);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		//Debug Testing Results passed through
		System.out.println(query+" has been past through the POST servlet");
		System.out.println(def+" has been returned through the POST servlet");
		
		//response.sendRedirect("index.jsp?def="+"Query: "+query+", Definition: " + def);
	
		//out.println("Query: "+query+ " Def: "+ def);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}


}
