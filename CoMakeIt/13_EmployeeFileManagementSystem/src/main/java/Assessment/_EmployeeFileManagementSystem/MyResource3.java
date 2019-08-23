package Assessment._EmployeeFileManagementSystem;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import AdminValid.AdminDao;
import UserValid.User;

@Path("myres1")
public class MyResource3 {
	@POST
	@Path("validate2")
	// Calls AdminDao function to add a new user
	public void getIt(User user) {
		AdminDao admindao = new AdminDao();
		admindao.addUser(user);
	}

	@DELETE
	@Path("{id}")
	// Calls AdminDao function to delete a particular user based on the entered id
	public void getIt1(@PathParam("id") int userid) {
		AdminDao admindao = new AdminDao();
		admindao.deleteUser(userid);
	}

	@GET
	@Path("list")
	// Calls AdminDao function to display the list of users in sorted order
	public List<String> getIt2() {
		AdminDao admindao = new AdminDao();
		List<String> users = admindao.displayUsers();
		return users;

	}

	@GET
	@Path("list1")
	// Calls AdminDao function to display the list of users under certain conditions
	public List<String> grantpermission() {
		AdminDao admindao = new AdminDao();
		List<String> users = admindao.grantpermissiontovalidusers();
		return users;
	}
}
