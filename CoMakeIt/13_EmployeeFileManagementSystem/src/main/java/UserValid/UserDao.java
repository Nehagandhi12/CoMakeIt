package UserValid;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Assessment._EmployeeFileManagementSystem.EntityFactory;

public class UserDao {
	/*
	 * If the user logs in for the first time he/she should change password first so
	 * they won't be allowed to update address Secondly if the user did not complete
	 * 100 days from the day user was added by admin user won't be allowed to update
	 * address In the rest cases he is allowed to update address So this function
	 * returns result based on the situation
	 */
	public int updateaddress(User user) {
		EntityManager entitymanager = EntityFactory.get();
		entitymanager.getTransaction().begin();
		User user1 = entitymanager.find(User.class, user.getUserid());
		if (user1.getFirsttimelogin() == 1) {
			entitymanager.getTransaction().commit();
			return 2;
		}
		if (user1.getGrantedpermission() != 0) {
			Query query = entitymanager.createNativeQuery(
					"Update user set address='" + user.getAddress() + "' WHERE userid ='" + user.getUserid() + "' ");
			query.executeUpdate();
			entitymanager.getTransaction().commit();
			return 1;
		} else {
			entitymanager.getTransaction().commit();
			return 0;
		}
	}

// If the user enters password in the propr format ,the password will be changed or else no
	public int updatepassword(User user) {
		EntityManager em = EntityFactory.get();
		em.getTransaction().begin();
		if (user.getPassword().matches("^(([A-Za-z])(?=.*\\d)(?=.*\\W)(?=.*[a-zA-Z])).{8,}")) {
			Query query = em.createNativeQuery("Update user set userpassword='" + user.getPassword()
					+ "' WHERE userid ='" + user.getUserid() + "' ");
			query.executeUpdate();
			user.setFirsttimelogin(0);
			em.getTransaction().commit();
			return 1;
		}
		em.getTransaction().commit();
		return 0;

	}

}
