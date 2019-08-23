//From this class the value is returned to the respective rest api calls after validating the data
package Assessment._EmployeeFileManagementSystem;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import AdminValid.Admin;
import UserValid.User;

public class Validatedao {
	public int validation(User user) {

		EntityManager entitymanager = EntityFactory.get();
		entitymanager.getTransaction().begin();
		User user2 = entitymanager.find(User.class, user.getUserid());

		if (user2 != null) {
			if (user2.getPassword().equals(user.getPassword())) {
				entitymanager.getTransaction().commit();

				return 1;

			}
		}
		entitymanager.getTransaction().commit();

		return 2;
	}

	public int validation(Admin admin) {
		EntityManager entitymanager = EntityFactory.get();
		entitymanager.getTransaction().begin();
		Admin admin1 = entitymanager.find(Admin.class,admin.getAdminid());
		if (admin1 != null) {
			Query query = entitymanager.createNativeQuery(
					"SELECT EXISTS(SELECT * FROM admin WHERE reportingTo='" + admin.getAdminid() + "')");
			Long result = (Long) query.getSingleResult();
			if (result == 1) {
				if (admin1.getAdminpassword().equals(admin.getAdminpassword())) {
					entitymanager.getTransaction().commit();
					return 1;
				}
			} else if (admin1.getAdminpassword().equals(admin.getAdminpassword())) {
				entitymanager.getTransaction().commit();
				return 0;
			}

		}
		entitymanager.getTransaction().commit();
		return 2;
	}
}
