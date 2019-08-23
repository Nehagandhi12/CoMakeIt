
package Assessment._EmployeeFileManagementSystem;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import ManagerValid.Leave;
import ManagerValid.ManagerDao;
import UserValid.User;


@Path("myresource")
public class MyResource {
	@GET
	@Path("validate/{id}/{password}")
	/*This call is made to the Validatedao function to validate whether the logging person is a user*/
	public int getIt(@PathParam("id") int id, @PathParam("password") String password) {
		Validatedao validDao = new Validatedao();
		User user = new User();
		user.setUserid(id);
		user.setPassword(password);
		int userValidate = validDao.validation(user);

		return userValidate;

	}

	@POST
	@Path("validate1")
	//Calls ManagerDao function to apply leave
	public int getIt1(Leave leave) {
		ManagerDao manager = new ManagerDao();
		manager.applyleave(leave);
		return 0;
	}

	@GET
	@Path("validate2/{id}")
	//Calls ManagerDao function to grant leave
	public String getIt1(@PathParam("id") int id) {
		ManagerDao manager = new ManagerDao();
		String listofemployees = manager.grantleave(id);
		return listofemployees;

	}

	@POST
	@Path("validate3")
	//Calls ManagerDao function to get status leave
	public int getIt2(int id) {
		ManagerDao manager = new ManagerDao();
		int status = manager.getstatusofleave(id);
		return status;
	}

}
