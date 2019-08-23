package Assessment._EmployeeFileManagementSystem;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import AdminValid.Admin;
import ManagerValid.ManagerDao;

@Path("myresource1")
public class MyResource1 {
	/*
	 * This call is made to the Validatedao function to validate whether the logging
	 * person is admin or manager(manager is an admin but admin is not a manager)
	 */
	@GET
	@Path("validate1/{id}/{password}")
	public int getIt(@PathParam("id") int id, @PathParam("password") String password) {
		Validatedao validDao = new Validatedao();
		Admin admin = new Admin();
		admin.setAdminid(id);
		admin.setAdminpassword(password);
		int userValidate = validDao.validation(admin);

		return userValidate;

	}
    //ManagerDao function call to accept leave request
	@PUT
	@Path("validate2")
	public int getIt1(int id) {
		ManagerDao manager = new ManagerDao();
		manager.acceptleaverequest(id);
		return 0;

	}
   //ManagerDao function call to reject leave request
	@PUT
	@Path("validate3")
	public int getIt2(int id) {
		ManagerDao manager = new ManagerDao();
		manager.rejectleaverequest(id);
		return 0;

	}
}
