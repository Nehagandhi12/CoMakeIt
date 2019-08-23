//From this Rest Api I have made calls to UserDao class to fulfill different user requests
package Assessment._EmployeeFileManagementSystem;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import UserValid.User;
import UserValid.UserDao;

@Path("myre")
public class MyResource2 {
	@PUT
	@Path("validate2")
	// Calls UserDao function to update address and returns result based on
	// different conditions
	public int updateaddress(User user) {
		UserDao userdao = new UserDao();
		int result = userdao.updateaddress(user);
		return result;
	}

	@PUT
	@Path("validate3")
	// Calls UserDao function to change password after verifying the entered
	// password
	public int getIt(User user) {
		UserDao userdao = new UserDao();
		int result = userdao.updatepassword(user);
		return result;
	}
}
