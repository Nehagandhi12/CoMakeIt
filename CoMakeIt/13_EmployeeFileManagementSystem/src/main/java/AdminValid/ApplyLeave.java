package AdminValid;

import java.io.IOException;
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
import ManagerValid.Leave;

public class ApplyLeave extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int adminid;
	private static String password;

	public ApplyLeave() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplyLeave(Admin a) {
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
		if (request.getParameter("button5") != null) {
			//When admin applies for leave
			response.sendRedirect("form.jsp");
		}
		if (request.getParameter("button1") != null) {
			//Retrieves different fields from form.jsp
			String date = request.getParameter("startdate");
			Leave leave = new Leave();
			leave.setLeavereason(request.getParameter("leavereasons"));
			leave.setNumberofdays(Integer.parseInt(request.getParameter("count")));
			leave.setStartdate(date);
			leave.setEmpid(adminid);
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client
					.target("http://localhost:8081/13_EmployeeFileManagementSystem/webapi/myresource")
					.path("validate1");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response res = invocationBuilder.post(Entity.entity(leave, MediaType.APPLICATION_JSON));
			String restResponse = res.readEntity(String.class);
			int i = Integer.parseInt(restResponse);
			response.sendRedirect("admin.jsp");
		}
		if (request.getParameter("checkstatus") != null) {
			//Calls 
			Client client = ClientBuilder.newClient(new ClientConfig());
			WebTarget webTarget = client
					.target("http://localhost:8081/13_EmployeeFileManagementSystem/webapi/myresource")
					.path("validate3");
			Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			Response res = invocationBuilder.post(Entity.entity(adminid, MediaType.APPLICATION_JSON));
			String restResponse = res.readEntity(String.class);
			int status = Integer.parseInt(restResponse);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/displaystatus.jsp");
			request.setAttribute("knowstatus", status);
			rd.forward(request, response);
		}
	}

}
