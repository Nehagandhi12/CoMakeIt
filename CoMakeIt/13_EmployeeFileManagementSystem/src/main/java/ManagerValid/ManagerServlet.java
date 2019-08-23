package ManagerValid;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

/**
 * Servlet implementation class ManagerServlet
 */
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String status=request.getParameter("status");
		int id=Integer.parseInt(request.getParameter("leaveid"));
		if(status.equals("accept"))
		{
			//Calls Myresource1 (Rest Api) function to accept leave request
            Client client = ClientBuilder.newClient( new ClientConfig() );
			WebTarget webTarget = client.target("http://localhost:8081/13_EmployeeFileManagementSystem/webapi/myresource1").path("validate2");
			Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
			Response res = invocationBuilder.put(Entity.entity(id, MediaType.APPLICATION_JSON));
			String restResponse = res.readEntity(String.class);
			response.sendRedirect("manager.jsp");
		}
		else
		{
			//Calls Myresource1 (Rest Api) function to reject leave request
            Client client = ClientBuilder.newClient( new ClientConfig() );
			WebTarget webTarget = client.target("http://localhost:8081/13_EmployeeFileManagementSystem/webapi/myresource1").path("validate3");
			Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
			Response res = invocationBuilder.put(Entity.entity(id, MediaType.APPLICATION_JSON));
			String restResponse = res.readEntity(String.class);
			response.sendRedirect("manager.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
