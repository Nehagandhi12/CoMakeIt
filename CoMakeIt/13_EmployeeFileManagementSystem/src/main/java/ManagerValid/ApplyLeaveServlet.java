package ManagerValid;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import javax.servlet.RequestDispatcher;
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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import AdminValid.Admin;

public class ApplyLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int adminid;
	private static String password;

	public ApplyLeaveServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplyLeaveServlet(Admin a) {
		adminid = a.getAdminid();
		password = a.getAdminpassword();
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
		if (request.getParameter("button10") != null) {
			// Redirects to leave form page where the manager enter the required details
			response.sendRedirect("leaveform.jsp");
		}
		if (request.getParameter("button1") != null) {
			// Retrieves the details from the leaveform page and send the details to rest
			// api call
			String date = request.getParameter("startdate");
			Leave leave = new Leave();
			leave.setEmpid(adminid);
			leave.setLeavereason(request.getParameter("leavereasons"));
			leave.setNumberofdays(Integer.parseInt(request.getParameter("count")));
			leave.setStartdate(date);
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client
					.target("http://localhost:8081/13_EmployeeFileManagementSystem/webapi/myresource")
					.path("validate1");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response res = invocationBuilder.post(Entity.entity(leave, MediaType.APPLICATION_JSON));
			String restResponse = res.readEntity(String.class);
			int result= Integer.parseInt(restResponse);
			response.sendRedirect("manager.jsp");
		}
		if (request.getParameter("button11") != null) {
			// Rest Api call(MyResource.java) to display the list of admin who made a leave
			// request
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client
					.target("http://localhost:8081/13_EmployeeFileManagementSystem/webapi/myresource")
					.path("validate2/" + adminid);
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response res = invocationBuilder.get();
			String restResponse = res.readEntity(String.class);
			Type type = new TypeToken<List<Leave>>() {
			}.getType();
			List<Leave> listPersons = new Gson().fromJson(restResponse, type);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/grantleave.jsp");
			request.setAttribute("listPersons", listPersons);
			rd.forward(request, response);
			response.sendRedirect("manager.jsp");
		}
		if (request.getParameter("checkstatus") != null) {
			// Rest Api Call(MyResource.java) to check the status of the leave
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client
					.target("http://localhost:8081/13_EmployeeFileManagementSystem/webapi/myresource")
					.path("validate3");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response res = invocationBuilder.post(Entity.entity(adminid, MediaType.APPLICATION_JSON));
			String restResponse = res.readEntity(String.class);
			int status = Integer.parseInt(restResponse);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/displaystatusmanager.jsp");
			request.setAttribute("knowstatus", status);
			rd.forward(request, response);

		}
	}
}
