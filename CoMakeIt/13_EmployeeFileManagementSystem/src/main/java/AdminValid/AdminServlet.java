package AdminValid;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		if (request.getParameter("button1") != null) {
			/*
			 * for adding new user it redirects to a new .jsp page where admin enters the
			 * details of the user to be added
			 */
			response.sendRedirect("AddUser.jsp");
		}
		if (request.getParameter("button2") != null) {

			Client client = ClientBuilder.newClient(new ClientConfig());
			String s = request.getParameter("deleteuser");
			Integer id = Integer.parseInt(s);
			// Call to MyResource3.java to delete the entered userid details
			WebTarget webTarget = client
					.target("http://localhost:8081/13_EmployeeFileManagementSystem/webapi/myres1/" + id);
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			invocationBuilder.delete();
			response.sendRedirect("admin.jsp");
		}
		if (request.getParameter("button3") != null) {
			// Call to MyResource3.java to display the list of users in sorted order
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client
					.target("http://localhost:8081/13_EmployeeFileManagementSystem/webapi/myres1/list");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response res = invocationBuilder.get();
			@SuppressWarnings("unchecked")
			List<String> users = res.readEntity(List.class);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/display.jsp");
			request.setAttribute("list", users);
			rd.forward(request, response);
		}
		if (request.getParameter("button4") != null) {
			/*
			 * Call to MyResource3.java to display the list of users who have completed
			 * their 100 days and grant them update permissions
			 */
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client
					.target("http://localhost:8081/13_EmployeeFileManagementSystem/webapi/myres1/list1");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response res = invocationBuilder.get();
			@SuppressWarnings("unchecked")
			List<String> users = res.readEntity(List.class);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/display.jsp");
			request.setAttribute("list", users);
			rd.forward(request, response);
		}
	}
}
