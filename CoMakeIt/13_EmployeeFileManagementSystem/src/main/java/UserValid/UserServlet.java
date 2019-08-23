//Servlet redirects to perform different requests made by user
package UserValid;

import java.io.IOException;
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

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int userid;
	private static String password;

	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserServlet(User a) {
		userid = a.getUserid();
		password = a.getPassword();
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
			User user = new User();
			user.setAddress(request.getParameter("updateaddress"));
			user.setUserid(userid);
			user.setPassword(password);
			Client client = ClientBuilder.newClient(new ClientConfig());
			// Calls Put Method in MyResource2.java to update address after checking certain
			// conditions
			WebTarget webTarget = client.target("http://localhost:8081/13_EmployeeFileManagementSystem/webapi/myre")
					.path("validate2");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response res = invocationBuilder.put(Entity.entity(user, MediaType.APPLICATION_JSON));
			String restResponse = res.readEntity(String.class);
			int result = Integer.parseInt(restResponse);
			if (result == 2) {
				response.sendRedirect("firsttimelogin.jsp");
			}
			if (result== 1) {
				response.sendRedirect("success.jsp");
			}
			if (result == 0) {
				response.sendRedirect("alert.jsp");
			}
		}
		if (request.getParameter("button2") != null || request.getParameter("button6") != null) {
			User user = new User();
			String newpassword = (request.getParameter("changepassword"));
			user.setUserid(userid);
			user.setPassword(newpassword);
			// Calls Put Method in MyResource2.java to change password after checking
			// certain conditions
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client.target("http://localhost:8081/13_EmployeeFileManagementSystem/webapi/myre")
					.path("validate3");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response res = invocationBuilder.put(Entity.entity(user, MediaType.APPLICATION_JSON));
			String restResponse = res.readEntity(String.class);
			int result = Integer.parseInt(restResponse);
			if (result == 1) {
				response.sendRedirect("success.jsp");
			} else {
				response.sendRedirect("PasswordFail.jsp");
			}
		}
	}

}
