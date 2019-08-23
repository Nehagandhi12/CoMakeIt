/*In this Servlet, the data is retrieved and respective rest api
calls are made for validating the data after which it redirects to different .jsp pages depending on the result*/
package Assessment._EmployeeFileManagementSystem;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import org.glassfish.jersey.client.ClientConfig;

import AdminValid.Admin;
import AdminValid.ApplyLeave;
import ManagerValid.ApplyLeaveServlet;
import UserValid.User;
import UserValid.UserServlet;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ValidateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int id = Integer.parseInt(request.getParameter("uid"));
		String password = request.getParameter("pass");
		User user = new User();
		user.setUserid(id);
		user.setPassword(password);
		//Calls Get Method in MyResource.java
		Client client = ClientBuilder.newClient(new ClientConfig());
		WebTarget webTarget = client.target("http://localhost:8081/13_EmployeeFileManagementSystem/webapi/myresource")
				.path("validate/"+user.getUserid()+"/"+user.getPassword());
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response res = invocationBuilder.get();
		String restResponse = res.readEntity(String.class);
		int result= Integer.parseInt(restResponse);
		if (result == 1) {
			UserServlet b = new UserServlet(user);
			response.sendRedirect("user.jsp");

		} else {
			Admin admin = new Admin();
			admin.setReportingTo(id);
			admin.setAdminid(id);
			admin.setAdminpassword(password);
			//Calls Get Method in MyResource1.java
			webTarget = client.target("http://localhost:8081/13_EmployeeFileManagementSystem/webapi/myresource1")
					.path("validate1/"+admin.getAdminid()+"/"+admin.getAdminpassword());
			invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			res = invocationBuilder.get();
			restResponse = res.readEntity(String.class);
			int result1 = Integer.parseInt(restResponse);
			if (result1 == 0) {
				ApplyLeave b1 = new ApplyLeave(admin);
				response.sendRedirect("admin.jsp");
			} else if (result1 == 1) {
				ApplyLeaveServlet b1 = new ApplyLeaveServlet(admin);
				response.sendRedirect("manager.jsp");
			} else
				response.sendRedirect("error.jsp");
		}
	}

}
