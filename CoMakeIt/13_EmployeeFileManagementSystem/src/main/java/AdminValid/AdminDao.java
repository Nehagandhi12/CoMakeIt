package AdminValid;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Assessment._EmployeeFileManagementSystem.EntityFactory;
import UserValid.User;

public class AdminDao {
	// Function to add new user
	public void addUser(User user) {
		EntityManager entity = EntityFactory.get();
		entity.getTransaction().begin();
		user.setFirsttimelogin(1);
		user.setGrantedpermission(0);
		user.setPassword("Hello@123");
		user.setStartdate(LocalDate.now().toString());
		entity.persist(user);
		entity.getTransaction().commit();
	}

//Function to delete a user
	public void deleteUser(int userid) {
		EntityManager entitymanager = EntityFactory.get();
		entitymanager .getTransaction().begin();
		User user = entitymanager .find(User.class, userid);
		entitymanager .remove(user);
		entitymanager .getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	// Function to display the list of users in sorted order
	public List<String> displayUsers() {
		EntityManager entity = EntityFactory.get();
		entity.getTransaction().begin();
		List<String> users = new ArrayList<String>();
		users = (List<String>) entity.createNativeQuery("SELECT username from user order by username").getResultList();
		entity.getTransaction().commit();
		return users;
	}

	@SuppressWarnings("unchecked")
	/*
	 * Function to display list of users who have completed their 100 days and the
	 * admin grants permission to those users
	 */
	public List<String> grantpermissiontovalidusers() {
		EntityManager entitymanager  = EntityFactory.get();
		entitymanager .getTransaction().begin();
		List<Integer> users = new ArrayList<Integer>();
		users = (List<Integer>) entitymanager 
				.createNativeQuery(
						" SELECT userid from user where DATEDIFF(CURDATE(),startdate)>=100 and grantedpermission=0")
				.getResultList();
		List<String> users1 = new ArrayList<String>();
		@SuppressWarnings("unused")
		Iterator<Integer> i1 = users.iterator();
		for (Integer x : users) {
			Query query = entitymanager .createNativeQuery(" Update user set grantedpermission=1  where userid='" + x + "'");
			query.executeUpdate();
		}
		for (Integer x : users) {
			User u = entitymanager .find(User.class, x);
			users1.add(u.getUsername());
		}
		entitymanager .getTransaction().commit();
		return users1;
	}
}
